package pkg

import (
	"bufio"
	"database/sql"
	"fmt"
	"github.com/spf13/cobra"
	"github.com/yyn1110/logs"
	"os"
	"os/signal"
	"path/filepath"
	"runtime"
	"strings"
	"sync"
	"syscall"
	"time"
)

const (
	programName = "table2class"
	version     = "0.11"
)

var (
	dbAddr      string
	dbUser      string
	dbPassword  string
	dbName      string
	dbNameTest  string
	packageName string
	maxCore     int
	prefix      string
	outputPath  string
	exclude     string
	logPath     string
	createPom   bool
	jdk         string
	pomVersion  string
	dbDriver    string
)

type resources struct {
	daoConfigFile   *os.File
	daoConfigWriter *bufio.Writer

	pomFile   *os.File
	pomWriter *bufio.Writer
}

var (
	g_resources         *resources
	g_packageName       string
	g_packageNamePath   string
	g_modelPath         string
	g_daoPath           string
	g_dataSourcePath    string
	g_myBatisPath       string
	g_myBatisExtPath    string
	g_testPath          string
	g_testExceptionPath string
	g_mainResourcesPath string
	g_testResourcesPath string
	g_upperDbName       string
	g_excludeNames      []string
)

var (
	logger *logs.BeeLogger
)

func InitConfig(cmd *cobra.Command) {
	cmd.Flags().BoolVarP(&createPom, "createPom", "c", true, "create pom ")
	cmd.Flags().StringVar(&pomVersion, "version", "0.1", "pom version")
	cmd.Flags().StringVar(&dbDriver, "dbDriver", "c3p0", "c3p0 or druid")
	cmd.Flags().StringVar(&jdk, "jdk", "1.7", "jdk version")
	cmd.Flags().StringVar(&dbAddr, "dbAddr", "10.6.80.97:3306", "The MySQL connect link.")
	cmd.Flags().StringVar(&logPath, "logPath", ".", "the log file path")
	cmd.Flags().StringVar(&dbUser, "dbUser", "root", "The MySQL user name.")
	cmd.Flags().StringVar(&dbPassword, "dbPassword", "dev123", "The MySQL password.")
	cmd.Flags().StringVar(&dbName, "dbName", "yzadmin", "The DB name.")
	cmd.Flags().StringVar(&dbNameTest, "dbNameTest", "", "The empty DB name for unit test.")
	cmd.Flags().StringVar(&packageName, "packageName", "com.yao.yz", "The package name of Java classes.")
	cmd.Flags().IntVar(&maxCore, "maxCore", 1, "The max core number. (0: Number of CPU - 1)")
	cmd.Flags().StringVar(&prefix, "prefix", "yw", "The prefix of table name.")
	cmd.Flags().StringVar(&outputPath, "outputPath", "/Users/hujie/yizhen/tmp", "The output file path.")
	cmd.Flags().StringVar(&exclude, "exclude", "open_app_log,health_report_stats_month,drug_question_stats_month,video_stats_month", "The exclude tables name.")

}
func init() {
	log := logs.NewLogger(10000)
	p := filepath.Join(logPath, "table2class.log")
	lp := fmt.Sprint(`{"filename":"%s", "perm": "0666"}`, p)
	log.SetLogger("file", lp)

	log.SetLogger("console", "")
	logger = log
}

func Run() {
	initEnviroment()
	dbURL := fmt.Sprintf("%s:%s@tcp(%s)/%s?charset=utf8", (dbUser), (dbPassword), (dbAddr), (dbName))
	logger.Info(dbURL)
	var dbConn *sql.DB
	dbConn, err := sql.Open("mysql", dbURL)
	if err != nil {
		logger.Error("Connect database:", dbURL, "Error:", err.Error())
		os.Exit(-1)
	}
	defer dbConn.Close()

	var wg sync.WaitGroup
	go run(dbConn, &wg)
	time.Sleep(time.Second)
	ch := make(chan os.Signal)
	signal.Notify(ch, syscall.SIGINT)
	finishChannel := make(chan bool)
	go wait(&wg, finishChannel)
	select {
	case <-ch:
		logger.Info("Canceled by user.")
		os.Exit(-1)
	case <-finishChannel:
		logger.Info("Convert finished successfully!")
	}
}
func initEnviroment() {

	logger.Info("%s version[%s]\r\nUsage: %s [OPTIONS]\r\n", programName, version, os.Args[0])

	numcpu := runtime.NumCPU()
	currentcpu := runtime.GOMAXPROCS(0)
	cpu := 0
	if maxCore > 0 && maxCore < numcpu-1 {
		cpu = maxCore
	} else {
		cpu = numcpu - 1
	}
	if cpu > 1 && currentcpu != cpu {
		runtime.GOMAXPROCS(cpu)
	}
	g_upperDbName = strings.ToUpper(dbName)
	g_packageName = packageName + "." + dbName
	g_packageNamePath = strings.Replace(g_packageName, ".", string(filepath.Separator), -1)

	os.RemoveAll(filepath.Join(outputPath, "src"))

	var err error
	g_modelPath = filepath.Join(outputPath, "src", "main", "java", g_packageNamePath, "persistence", "model")
	if err = os.MkdirAll(g_modelPath, 0777); err != nil {
		logger.Error("Create folder", g_modelPath, "error:", err.Error())
		os.Exit(-1)
	}
	g_daoPath = filepath.Join(outputPath, "src", "main", "java", g_packageNamePath, "persistence", "dao")
	if err = os.MkdirAll(g_daoPath, 0777); err != nil {
		logger.Error("Create folder", g_daoPath, "error:", err.Error())
		os.Exit(-1)
	}

	g_dataSourcePath = filepath.Join(outputPath, "src", "main", "java", g_packageNamePath, "dataSource")
	if err = os.MkdirAll(g_dataSourcePath, 0777); err != nil {
		logger.Error("Create folder", g_dataSourcePath, "error:", err.Error())
		os.Exit(-1)
	}
	g_myBatisPath = filepath.Join(outputPath, "src", "main", "resources", g_packageNamePath, "persistence", "sqlmap")
	if err = os.MkdirAll(g_myBatisPath, 0777); err != nil {
		logger.Error("Create folder", g_myBatisPath, "error:", err.Error())
		os.Exit(-1)
	}

	g_myBatisExtPath = filepath.Join(outputPath, "src", "main", "resources", g_packageNamePath, "persistence", "sqlmap", "ext")
	if err = os.MkdirAll(g_myBatisExtPath, 0777); err != nil {
		logger.Error("Create folder", g_myBatisExtPath, "error:", err.Error())
		os.Exit(-1)
	}
	g_testPath = filepath.Join(outputPath, "src", "test", "java", g_packageNamePath)
	if err = os.MkdirAll(g_testPath, 0777); err != nil {
		logger.Error("Create folder", g_testPath, "error:", err.Error())
		os.Exit(-1)
	}
	g_testExceptionPath = filepath.Join(outputPath, "src", "test", "java", g_packageNamePath, "exception")
	if err = os.MkdirAll(g_testExceptionPath, 0777); err != nil {
		logger.Error("Create folder", g_testExceptionPath, "error:", err.Error())
		os.Exit(-1)
	}
	g_mainResourcesPath = filepath.Join(outputPath, "src", "main", "resources")
	if err = os.MkdirAll(g_mainResourcesPath, 0777); err != nil {
		logger.Error("Create folder", g_mainResourcesPath, "error:", err.Error())
		os.Exit(-1)
	}
	g_testResourcesPath = filepath.Join(outputPath, "src", "test", "resources")
	if err = os.MkdirAll(g_testResourcesPath, 0777); err != nil {
		logger.Error("Create folder", g_testResourcesPath, "error:", err.Error())
		os.Exit(-1)
	}

	excludeStrings := strings.Split(exclude, ",")
	for _, excludeString := range excludeStrings {
		g_excludeNames = append(g_excludeNames, excludeString)
	}

}
