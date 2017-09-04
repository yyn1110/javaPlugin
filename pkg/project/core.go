package project

import (
	"bufio"
	"database/sql"
	"fmt"
	"github.com/spf13/cobra"
	//"github.com/yyn1110/logs"
	"javaPlugin/pkg/logs"
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
	programName = "javaPlugin"
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
	outputPath  string
	exclude     string

	jdk           string
	pomVersion    string
	dbDriver      string
	redisHost     string
	redisPort     string
	redisPassWord string
	useRedis      bool
	projectName   string
)

type resources struct {
	daoConfigFile   *os.File
	daoConfigWriter *bufio.Writer

	pomFile   *os.File
	pomWriter *bufio.Writer
}
type project_resources struct {
	pomFile   *os.File
	pomWriter *bufio.Writer
}
type project struct {
	g_persistencePath string
	g_servicePath     string
	g_apiPath         string

	g_packageName string
	g_projectPath string

	g_persistence      *project_persistence
	g_service          *project_service
	g_api              *project_api
	g_project_resource *project_resources
}

//db project
var (
	g_project *project
)

type project_persistence struct {
	g_packageDBName     string
	g_packageDBPath     string
	g_modelPath         string
	g_daoPath           string
	g_dataSourcePath    string
	g_utilPath          string
	g_loggerPath        string
	g_myBatisPath       string
	g_testPath          string
	g_testExceptionPath string
	g_mainResourcesPath string
	g_testResourcesPath string
	g_upperDbName       string
	g_excludeNames      []string
	g_resources         *resources
}

// service project
type project_service struct {
	g_packageServiceName string
	g_packageServicePath string
	g_servicesPath       string
	g_servicesImplPath   string
}

//api project
type project_api struct {
	g_packageApiName string
	g_packageApiPath string
	g_apiPath        string
}

//project

func InitConfig(cmd *cobra.Command) {

	cmd.Flags().BoolVarP(&useRedis, "useRedis", "r", false, "create redis config ")
	cmd.Flags().StringVar(&pomVersion, "version", "0.1", "pom version")
	cmd.Flags().StringVar(&dbDriver, "dbDriver", "c3p0", "c3p0 or druid")
	cmd.Flags().StringVar(&jdk, "jdk", "1.7", "jdk version")
	cmd.Flags().StringVar(&dbAddr, "dbAddr", "10.6.80.97:3306", "The MySQL connect link.")
	cmd.Flags().StringVar(&dbUser, "dbUser", "root", "The MySQL user name.")
	cmd.Flags().StringVar(&dbPassword, "dbPassword", "dev123", "The MySQL password.")
	cmd.Flags().StringVar(&dbName, "dbName", "yzadmin", "The DB name.")
	cmd.Flags().StringVar(&dbNameTest, "dbNameTest", "", "The empty DB name for unit test.")
	cmd.Flags().StringVar(&packageName, "packageName", "com.java.demo", "The package name of Java classes.")
	cmd.Flags().IntVar(&maxCore, "maxCore", 1, "The max core number. (0: Number of CPU - 1)")
	cmd.Flags().StringVar(&outputPath, "outputPath", "./", "The output file path.")
	cmd.Flags().StringVar(&exclude, "exclude", "open_app_log,health_report_stats_month,drug_question_stats_month,video_stats_month", "The exclude tables name.")
	cmd.Flags().StringVar(&redisHost, "redisHost", "127.0.0.1", "redis host")
	cmd.Flags().StringVar(&redisPort, "redisPort", "6379", "redis port")
	cmd.Flags().StringVar(&redisPassWord, "redisPassWord", "", "redis password")
	cmd.Flags().StringVar(&projectName, "projectName", "demo", "project name")

}

type tableDefine struct {
	Field            []byte
	Type             []byte
	DBType           []byte
	Null             []byte
	Key              []byte
	Default          []byte
	Extra            []byte
	Comment          []byte
	CharacterSetName []byte
	Schema           []byte
	TableName        []byte
}

type tableDefineString struct {
	DbFieldName      string
	FieldName        string
	MethodName       string
	Type             int
	TypeString       string
	JDBCType         string
	DbTypeString     string
	Null             string
	Key              string
	Default          string
	Extra            string
	Comment          string
	CharacterSetName string
	DBType           string
	AutoIncrement    bool
	TestValue        string
	FieldLen         int
}

type classDefine struct {
	HasPrefix     bool
	ClassName     string
	TableName     string
	CamelCaseName string
	Fields        map[string]*tableDefineString
	Names         []string
	PrimaryKey    *tableDefineString
	UnionKeys     []*tableDefineString
}

func Run() {
	initEnviroment()
	initPersistenceProject()
	initServiceProject()
	initApiProject()

	dbURL := fmt.Sprintf("%s:%s@tcp(%s)/%s?charset=utf8", (dbUser), (dbPassword), (dbAddr), (dbName))
	logs.Logger.Info(dbURL)
	var dbConn *sql.DB
	dbConn, err := sql.Open("mysql", dbURL)
	if err != nil {
		logs.Logger.Error("Connect database:", dbURL, "Error:", err.Error())
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
		logs.Logger.Info("Canceled by user.")
		os.Exit(-1)
	case <-finishChannel:
		logs.Logger.Info("Convert finished successfully!")
	}
}
func initEnviroment() {

	logs.Logger.Info("%s version[%s]\r\nUsage: %s [OPTIONS]\r\n", programName, version, os.Args[0])

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

	os.RemoveAll(filepath.Join(outputPath))

	var err error
	g_project = new(project)
	g_project.g_projectPath = filepath.Join(outputPath, projectName)
	g_project.g_packageName = packageName
	g_project.g_apiPath = filepath.Join(outputPath, projectName, projectName+"-api")
	if err = os.MkdirAll(g_project.g_apiPath, 0777); err != nil {
		logs.Logger.Error("Create folder", g_project.g_apiPath, "error:", err.Error())
		os.Exit(-1)
	}
	g_project.g_servicePath = filepath.Join(outputPath, projectName, projectName+"-service")
	if err = os.MkdirAll(g_project.g_servicePath, 0777); err != nil {
		logs.Logger.Error("Create folder", g_project.g_servicePath, "error:", err.Error())
		os.Exit(-1)
	}
	g_project.g_persistencePath = filepath.Join(outputPath, projectName, projectName+"-persistence")
	if err = os.MkdirAll(g_project.g_persistencePath, 0777); err != nil {
		logs.Logger.Error("Create folder", g_project.g_persistencePath, "error:", err.Error())
		os.Exit(-1)
	}
	g_persistence := new(project_persistence)
	g_project.g_persistence = g_persistence
	g_persistence.g_packageDBName = packageName + "." + dbName
	g_persistence.g_packageDBPath = strings.Replace(g_persistence.g_packageDBName, ".", string(filepath.Separator), -1)

	g_service := new(project_service)
	g_project.g_service = g_service
	g_service.g_packageServiceName = packageName + ".services"
	g_service.g_packageServicePath = strings.Replace(g_service.g_packageServiceName, ".", string(filepath.Separator), -1)

	g_api := new(project_api)
	g_api.g_packageApiName = packageName + ".api"
	g_api.g_packageApiPath = strings.Replace(g_api.g_packageApiName, ".", string(filepath.Separator), -1)
	g_project.g_api = g_api
	g_persistence.g_upperDbName = strings.ToUpper(dbName)

	pr := new(project_resources)
	pr.init()
	g_project.g_project_resource = pr

}
func initPersistenceProject() {

	var err error

	g_project.g_persistence.g_modelPath = filepath.Join(g_project.g_persistencePath, "src", "main", "java", g_project.g_persistence.g_packageDBPath, "persistence", "model")
	if err = os.MkdirAll(g_project.g_persistence.g_modelPath, 0777); err != nil {
		logs.Logger.Error("Create folder", g_project.g_persistence.g_modelPath, "error:", err.Error())
		os.Exit(-1)
	}
	g_project.g_persistence.g_daoPath = filepath.Join(g_project.g_persistencePath, "src", "main", "java", g_project.g_persistence.g_packageDBPath, "persistence", "dao")
	if err = os.MkdirAll(g_project.g_persistence.g_daoPath, 0777); err != nil {
		logs.Logger.Error("Create folder", g_project.g_persistence.g_daoPath, "error:", err.Error())
		os.Exit(-1)
	}

	g_project.g_persistence.g_dataSourcePath = filepath.Join(g_project.g_persistencePath, "src", "main", "java", g_project.g_persistence.g_packageDBPath, "dataSource")
	if err = os.MkdirAll(g_project.g_persistence.g_dataSourcePath, 0777); err != nil {
		logs.Logger.Error("Create folder", g_project.g_persistence.g_dataSourcePath, "error:", err.Error())
		os.Exit(-1)
	}
	g_project.g_persistence.g_utilPath = filepath.Join(g_project.g_persistencePath, "src", "main", "java", g_project.g_persistence.g_packageDBPath, "utils")
	if err = os.MkdirAll(g_project.g_persistence.g_utilPath, 0777); err != nil {
		logs.Logger.Error("Create folder", g_project.g_persistence.g_utilPath, "error:", err.Error())
		os.Exit(-1)
	}
	g_project.g_persistence.g_loggerPath = filepath.Join(g_project.g_persistencePath, "src", "main", "java", g_project.g_persistence.g_packageDBPath, "logger")
	if err = os.MkdirAll(g_project.g_persistence.g_loggerPath, 0777); err != nil {
		logs.Logger.Error("Create folder", g_project.g_persistence.g_loggerPath, "error:", err.Error())
		os.Exit(-1)
	}

	g_project.g_persistence.g_myBatisPath = filepath.Join(g_project.g_persistencePath, "src", "main", "resources", g_project.g_persistence.g_packageDBPath, "persistence", "sqlmap")
	if err = os.MkdirAll(g_project.g_persistence.g_myBatisPath, 0777); err != nil {
		logs.Logger.Error("Create folder", g_project.g_persistence.g_myBatisPath, "error:", err.Error())
		os.Exit(-1)
	}

	g_project.g_persistence.g_testPath = filepath.Join(g_project.g_persistencePath, "src", "test", "java", g_project.g_persistence.g_packageDBPath)
	if err = os.MkdirAll(g_project.g_persistence.g_testPath, 0777); err != nil {
		logs.Logger.Error("Create folder", g_project.g_persistence.g_testPath, "error:", err.Error())
		os.Exit(-1)
	}
	g_project.g_persistence.g_testExceptionPath = filepath.Join(g_project.g_persistencePath, "src", "test", "java", g_project.g_persistence.g_packageDBPath, "exception")
	if err = os.MkdirAll(g_project.g_persistence.g_testExceptionPath, 0777); err != nil {
		logs.Logger.Error("Create folder", g_project.g_persistence.g_testExceptionPath, "error:", err.Error())
		os.Exit(-1)
	}
	g_project.g_persistence.g_mainResourcesPath = filepath.Join(g_project.g_persistencePath, "src", "main", "resources")
	if err = os.MkdirAll(g_project.g_persistence.g_mainResourcesPath, 0777); err != nil {
		logs.Logger.Error("Create folder", g_project.g_persistence.g_mainResourcesPath, "error:", err.Error())
		os.Exit(-1)
	}
	g_project.g_persistence.g_testResourcesPath = filepath.Join(g_project.g_persistencePath, "src", "test", "resources")
	if err = os.MkdirAll(g_project.g_persistence.g_testResourcesPath, 0777); err != nil {
		logs.Logger.Error("Create folder", g_project.g_persistence.g_testResourcesPath, "error:", err.Error())
		os.Exit(-1)
	}

	excludeStrings := strings.Split(exclude, ",")
	for _, excludeString := range excludeStrings {
		g_project.g_persistence.g_excludeNames = append(g_project.g_persistence.g_excludeNames, excludeString)
	}

}
func initServiceProject() {

	var err error

	g_project.g_service.g_servicesPath = filepath.Join(g_project.g_servicePath, "src", "main", "java", g_project.g_service.g_packageServicePath)
	if err = os.MkdirAll(g_project.g_service.g_servicesPath, 0777); err != nil {
		logs.Logger.Error("Create folder", g_project.g_service.g_servicesPath, "error:", err.Error())
		os.Exit(-1)
	}
	g_project.g_service.g_servicesImplPath = filepath.Join(g_project.g_servicePath, "src", "main", "java", g_project.g_service.g_packageServicePath, "impl")
	if err = os.MkdirAll(g_project.g_service.g_servicesImplPath, 0777); err != nil {
		logs.Logger.Error("Create folder", g_project.g_service.g_servicesImplPath, "error:", err.Error())
		os.Exit(-1)
	}

}
func initApiProject() {

	var err error

	g_project.g_api.g_apiPath = filepath.Join(g_project.g_apiPath, "src", "main", "java", g_project.g_api.g_packageApiPath)
	if err = os.MkdirAll(g_project.g_api.g_apiPath, 0777); err != nil {
		logs.Logger.Error("Create folder", g_project.g_api.g_apiPath, "error:", err.Error())
		os.Exit(-1)
	}

}

////////////////////////////////////////////////////
// Write files
func writeFiles() {
	writeLog4j()
	writeConfigProperties()
	writeAbstractTest()
	writeConstants()
	writeHttpUtil()
	if useRedis {
		writeRedisTest()
	}

}

func writeHttpUtil() {
	var err error
	var file *os.File
	if file, err = os.Create(filepath.Join(g_project.g_persistence.g_utilPath, "HttpClientUtil.java")); err != nil {
		logs.Logger.Error("Create file", filepath.Join(g_project.g_persistence.g_utilPath, "HttpClientUtil.java"), ", error:", err.Error())
		return
	}
	defer file.Close()
	bw := bufio.NewWriter(file)
	redis_content := strings.Replace(http_class, "$(package)$", g_project.g_persistence.g_packageDBName, -1)
	bw.WriteString(redis_content)
	bw.Flush()
}
func writeRedisTest() {
	var err error
	var file *os.File
	if file, err = os.Create(filepath.Join(g_project.g_persistence.g_testPath, "RedisTest.java")); err != nil {
		logs.Logger.Error("Create file", filepath.Join(g_project.g_persistence.g_testResourcesPath, "RedisTest.java"), ", error:", err.Error())
		return
	}
	defer file.Close()
	bw := bufio.NewWriter(file)
	redis_content := strings.Replace(redis_test_class, "$(package)$", g_project.g_persistence.g_packageDBName, -1)
	bw.WriteString(redis_content)
	bw.Flush()
}
func writeLog4j() {
	var err error
	var file *os.File
	if file, err = os.Create(filepath.Join(g_project.g_persistence.g_testResourcesPath, "log4j.xml")); err != nil {
		logs.Logger.Error("Create file", filepath.Join(g_project.g_persistence.g_testResourcesPath, "log4j.xml"), ", error:", err.Error())
		return
	}
	defer file.Close()
	bw := bufio.NewWriter(file)
	log4jxml := strings.Replace(log4jXML, "$(packageName)$", g_project.g_persistence.g_packageDBName, -1)
	bw.WriteString(log4jxml)
	bw.Flush()

	var logClassFile *os.File
	if file, err = os.Create(filepath.Join(g_project.g_persistence.g_loggerPath, "YzLogger.java")); err != nil {
		logs.Logger.Error("Create file", filepath.Join(g_project.g_persistence.g_loggerPath, "YzLogger.java"), ", error:", err.Error())
		return
	}
	defer logClassFile.Close()
	bw = bufio.NewWriter(file)
	logClass := strings.Replace(logger_class, "$(packageName)$", g_project.g_persistence.g_packageDBName, -1)
	bw.WriteString(logClass)
	bw.Flush()

}

func writeConfigProperties() {
	var err error
	var file *os.File
	if file, err = os.Create(filepath.Join(g_project.g_persistence.g_testResourcesPath, (dbName)+"-db.properties")); err != nil {
		logs.Logger.Error("Create file", filepath.Join(g_project.g_persistence.g_testResourcesPath, (dbName)+"-db.properties"), ", error:", err.Error())
		return
	}
	defer file.Close()
	bw := bufio.NewWriter(file)

	mysql_properties := strings.Replace(ProPerties_Mysql, "$(dbAddr)$", dbAddr, -1)
	mysql_properties = strings.Replace(mysql_properties, "$(dbUser)$", dbUser, -1)
	mysql_properties = strings.Replace(mysql_properties, "$(dbPassword)$", dbPassword, -1)
	mysql_properties = strings.Replace(mysql_properties, "$(dbName)$", dbName, -1)

	bw.WriteString(mysql_properties)
	if useRedis {
		redis_properties := strings.Replace(Redis_Config, "$(redisHost)$", redisHost, -1)
		redis_properties = strings.Replace(redis_properties, "$(redisPort)$", redisPort, -1)
		redis_properties = strings.Replace(redis_properties, "$(redisPassWord)$", redisPassWord, -1)
		bw.WriteString(redis_properties)
	}

	bw.Flush()
}

func writeAbstractTest() {
	var err error
	var file *os.File
	if file, err = os.Create(filepath.Join(g_project.g_persistence.g_testPath, "AbstractTest.java")); err != nil {
		logs.Logger.Error("Create file", filepath.Join(g_project.g_persistence.g_testPath, "AbstractTest.java"), ", error:", err.Error())
		return
	}
	defer file.Close()
	bw := bufio.NewWriter(file)

	bw.WriteString("package ")
	bw.WriteString(g_project.g_persistence.g_packageDBName)
	bw.WriteString(";\n")
	bw.WriteString(`
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 描述：测试基类，所有的Dao测试类都必须继承此类
 * @Transactional 引入事务控制
 * @TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true) 引入事务控制管理器
 * AbstractTransactionalDataSourceSpringContextTests 继承事务测试基类，避免测试框架带来脏数据，取消事务控制时修改为false
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:`)
	bw.WriteString(dbName)
	bw.WriteString(`-daoConfig.xml"})
public abstract class AbstractTest {

}`)
	bw.Flush()
}

func writeConstants() {
	var err error
	var file *os.File
	if file, err = os.Create(filepath.Join(g_project.g_persistence.g_daoPath, "DataSourceConstants.java")); err != nil {
		logs.Logger.Error("Create file", filepath.Join(g_project.g_persistence.g_daoPath, "DataSourceConstants.java"), ", error:", err.Error())
		return
	}
	defer file.Close()
	bw := bufio.NewWriter(file)

	bw.WriteString(`package `)
	bw.WriteString(g_project.g_persistence.g_packageDBName)
	bw.WriteString(".persistence.dao;\n\n")

	bw.WriteString("public class DataSourceConstants {\n")

	bw.WriteString("\tpublic static final String DATASOURCE_R_")
	bw.WriteString(g_project.g_persistence.g_upperDbName)
	bw.WriteString(" = \"dataSource_R_")
	bw.WriteString(dbName)
	bw.WriteString("\";\n")

	bw.WriteString("\tpublic static final String DATASOURCE_W_")
	bw.WriteString(g_project.g_persistence.g_upperDbName)
	bw.WriteString(" = \"dataSource_W_")
	bw.WriteString(dbName)
	bw.WriteString("\";\n")

	bw.WriteString("}\n")
	bw.Flush()
}

////////////////////////////////////////////////////

func projectInit() {

}

////////////////////////////////////////////////////

func (res *project_resources) init() {
	var err error

	if res.pomFile, err = os.Create(filepath.Join(g_project.g_projectPath, "pom.xml")); err != nil {
		logs.Logger.Error("Create pom file error %s", err.Error())
		return
	}
	res.pomWriter = bufio.NewWriter(res.pomFile)
	pomxml := strings.Replace(POM_XML, "$(groupId)$", packageName, -1)
	pomxml = strings.Replace(pomxml, "$(artifactId)$", projectName, -1)
	pomxml = strings.Replace(pomxml, "$(name)$", projectName, -1)
	pomxml = strings.Replace(pomxml, "$(description)$", "description for this project", -1)
	pomxml = strings.Replace(pomxml, "$(jdk)$", jdk, -1)
	pomxml = strings.Replace(pomxml, "$(version)$", pomVersion, -1)
	jedis := `
		<dependency>
			<groupId>redis.clients</groupId>
			<artifactId>jedis</artifactId>
			<version>2.7.3</version>
		</dependency>
			`
	if useRedis {
		pomxml = strings.Replace(pomxml, "$(redisDependency)$", jedis, -1)

	} else {
		pomxml = strings.Replace(pomxml, "$(redisDependency)$", "", -1)
	}

	res.pomWriter.WriteString(pomxml)
	res.pomWriter.Flush()
}

// Resource files
func (res *resources) init() {

	var err error

	if res.pomFile, err = os.Create(filepath.Join(g_project.g_persistencePath, "pom.xml")); err != nil {
		logs.Logger.Error("Create pom file error %s", err.Error())
		return
	}
	res.pomWriter = bufio.NewWriter(res.pomFile)
	pomxml := strings.Replace(DB_POM_XML, "$(groupId)$", packageName, -1)
	pomxml = strings.Replace(pomxml, "$(artifactId)$", projectName+"-persistence", -1)
	pomxml = strings.Replace(pomxml, "$(projectName)$", projectName, -1)
	pomxml = strings.Replace(pomxml, "$(name)$", projectName+"-persistence", -1)
	pomxml = strings.Replace(pomxml, "$(description)$", "description for this project", -1)
	pomxml = strings.Replace(pomxml, "$(jdk)$", jdk, -1)
	pomxml = strings.Replace(pomxml, "$(version)$", pomVersion, -1)

	jedis := `
		<dependency>
			<groupId>redis.clients</groupId>
			<artifactId>jedis</artifactId>
			<version>2.7.3</version>
		</dependency>
			`
	if useRedis {
		pomxml = strings.Replace(pomxml, "$(redisDependency)$", jedis, -1)

	} else {
		pomxml = strings.Replace(pomxml, "$(redisDependency)$", "", -1)
	}

	res.pomWriter.WriteString(pomxml)

	if res.daoConfigFile, err = os.Create(filepath.Join(g_project.g_persistence.g_testResourcesPath, (dbName)+"-daoConfig.xml")); err != nil {
		logs.Logger.Error("Create file", filepath.Join(g_project.g_persistence.g_testResourcesPath, (dbName)+"-daoConfig.xml"), ", error:", err.Error())
		return
	}
	res.daoConfigWriter = bufio.NewWriter(res.daoConfigFile)
	daoConfigXml := strings.Replace(daoConfigXML, "$(packageName)$", g_project.g_persistence.g_packageDBName, -1)

	daoConfigXml = strings.Replace(daoConfigXml, "$(classPath)$", strings.Replace(g_project.g_persistence.g_packageDBName, ".", "/", -1)+"/persistence/sqlmap/*.xml", -1)
	daoConfigXml = strings.Replace(daoConfigXml, "$(classPathExt)$", strings.Replace(g_project.g_persistence.g_packageDBName, ".", "/", -1)+"/persistence/sqlmap/ext/*.xml", -1)

	switch dbDriver {
	case "c3p0":
		daoConfigXml = strings.Replace(daoConfigXml, "$(driverExtR)$", c3p0_r, -1)
		daoConfigXml = strings.Replace(daoConfigXml, "$(driverExtW)$", c3p0_w, -1)
		daoConfigXml = strings.Replace(daoConfigXml, "$(init)$", "", -1)

		daoConfigXml = strings.Replace(daoConfigXml, "$(driver)$", "com.mchange.v2.c3p0.ComboPooledDataSource", -1)
	case "druid":
		daoConfigXml = strings.Replace(daoConfigXml, "$(driverExtR)$", druid_r, -1)
		daoConfigXml = strings.Replace(daoConfigXml, "$(driverExtW)$", druid_w, -1)
		daoConfigXml = strings.Replace(daoConfigXml, "$(init)$", `init-method="init"`, -1)
		daoConfigXml = strings.Replace(daoConfigXml, "$(driver)$", "com.alibaba.druid.pool.DruidDataSource", -1)
	}
	daoConfigXml = strings.Replace(daoConfigXml, "$(properties)$", dbName+"-db.properties", -1)
	daoConfigXml = strings.Replace(daoConfigXml, "$(dbName)$", dbName, -1)
	if useRedis {
		daoConfigXml = strings.Replace(daoConfigXml, "$(redisConfig)$", redis_config, -1)

	} else {
		daoConfigXml = strings.Replace(daoConfigXml, "$(redisConfig)$", "", -1)
	}

	res.daoConfigWriter.WriteString(daoConfigXml)

}
func (res *resources) writeLine(class *classDefine) {
}
func (res *resources) close() {
	//res.daoConfigWriter.WriteString("\n</beans>")
	res.daoConfigWriter.Flush()
	res.daoConfigFile.Close()
	res.pomWriter.Flush()
	res.pomFile.Close()
}

////////////////////////////////
// Test file
func writeTestHeader(bw *bufio.Writer, class *classDefine) {
	bw.WriteString(`package ` + g_project.g_persistence.g_packageDBName + ";\n\n")
	bw.WriteString("import " + g_project.g_persistence.g_packageDBName + ".persistence.model." + class.ClassName + ";\n")
	bw.WriteString("import " + g_project.g_persistence.g_packageDBName + ".persistence.dao." + class.ClassName + "Dao;\n")
	bw.WriteString("import " + g_project.g_persistence.g_packageDBName + ".logger.YzLogger;\n")
	header := packageName + "." + dbName + ".exception"
	bw.WriteString("import " + header + ".UnitTestException;\n")
	bw.WriteString("import org.junit.Test;\n")
	bw.WriteString("import javax.annotation.Resource;\n")
	bw.WriteString("import org.springframework.transaction.annotation.Transactional;\n\n")

	bw.WriteString("public class " + class.ClassName + "Test extends AbstractTest {\n")

}
func writeTestBody(bw *bufio.Writer, class *classDefine) {
	bw.WriteString("\t@Resource\n")
	bw.WriteString("\tprivate " + class.ClassName + "Dao dao;\n")

	// setObjVal function
	bw.WriteString("\n\tprivate void setObjVal(" + class.ClassName + " sObj) {\n")

	index := 0
	keyType := "Integer"
	keyValue := ""
	var unionKeys []string
	for _, fieldName := range class.Names {
		field := class.Fields[fieldName]
		if field == class.PrimaryKey {
			if field.AutoIncrement {
				continue
			}
			keyType = field.TypeString
		}

		if field == class.PrimaryKey {
			keyValue = field.TestValue
		}
		bw.WriteString("\t\tsObj.set" + field.MethodName + "(" + field.TestValue + ");\n")
		index++
	}
	for _, field := range class.UnionKeys {
		unionKeys = append(unionKeys, field.TestValue)
	}

	bw.WriteString("\t}\n\n")

	//add
	bw.WriteString("\t@Test\n\t@Transactional(rollbackFor=Exception.class)\n")
	// Test case

	bw.WriteString("\tpublic void testCase() throws UnitTestException {\n")
	new := fmt.Sprintf("\t\t%s  objInsert = new %s();\n", class.ClassName, class.ClassName)
	//bw.WriteString(class.ClassName+" objInsert = new "+class.ClassName+"")
	//bw.WriteString(" objInsert = new ")
	bw.WriteString(new)
	bw.WriteString("\t\tsetObjVal(objInsert);\n\n")
	bw.WriteString("\t\tYzLogger.info(\"insert [")
	bw.WriteString(class.ClassName)
	bw.WriteString("]\");\n")

	bw.WriteString("\t\tdao.insert(objInsert);\n")

	if class.PrimaryKey != nil {
		if class.PrimaryKey.AutoIncrement {
			bw.WriteString("\t\tInteger key = objInsert.get")
			bw.WriteString(class.PrimaryKey.MethodName)
			bw.WriteString("();\n")
			bw.WriteString("\t\tif (key == null || key == 0) {\n")
			bw.WriteString("\t\t\tthrow new UnitTestException(\"")
			bw.WriteString(class.ClassName)
			bw.WriteString("Test\", \"test of insert is failed\");\n")
			bw.WriteString("\t\t}\n")
			bw.WriteString("\t\tYzLogger.info(\"\tinsert OK\");\n\n")

			bw.WriteString("\t\t")
			bw.WriteString(class.ClassName)
			bw.WriteString(" objSelect = dao.get")
			bw.WriteString(class.ClassName)
			bw.WriteString("ByKey(key);\n")
			bw.WriteString("\t\tif (objSelect == null) {\n")
			bw.WriteString("\t\t\tthrow new UnitTestException(\"")
			bw.WriteString(class.ClassName)
			bw.WriteString("Test\", \"test of select is failed\");\n")
			bw.WriteString("\t\t}\n")
			bw.WriteString("\t\tYzLogger.info(\"\tselect OK \"+objSelect.toString());\n\n")
		} else {
			bw.WriteString("\t\t")
			bw.WriteString(keyType)
			bw.WriteString(" key = ")
			bw.WriteString(keyValue)
			bw.WriteString(";\n")
			bw.WriteString("\t\t")
			bw.WriteString(class.ClassName)
			bw.WriteString(" objSelect = dao.get")
			bw.WriteString(class.ClassName)
			bw.WriteString("ByKey(key);\n")
			bw.WriteString("\t\tif (objSelect == null) {\n")

			bw.WriteString("\t\t\tdao.insert(objInsert);\n")
			bw.WriteString("\t\t\tYzLogger.info(\"\tinsert OK\");\n\n")
			bw.WriteString("\t\t\tobjSelect = dao.get")
			bw.WriteString(class.ClassName)
			bw.WriteString("ByKey(key);\n")
			bw.WriteString("\t\t\tif (objSelect == null) {\n")
			bw.WriteString("\t\t\tthrow new UnitTestException(\"")
			bw.WriteString(class.ClassName)
			bw.WriteString("Test\", \"test of select is failed\");\n")
			bw.WriteString("\t\t\t}\n")
			bw.WriteString("\t\t\tYzLogger.info(\"\tselect OK \"+objSelect.toString());\n\n")
			bw.WriteString("\t\t}\n")
		}

		bw.WriteString("\t\tjava.util.List<" + class.ClassName + "> list = dao.get" + class.ClassName + "s(objSelect);\n")
		bw.WriteString("\t\t")
		bw.WriteString(`if (list !=null){
            YzLogger.info("	selectAll OK "+list.toString());
        }else{
            throw new UnitTestException("EcuserWxUserinfoTest", "test of selectAll is failed");
        }` + "\n\n")

		bw.WriteString("\t\tInteger res = dao.update(objSelect);\n")
		bw.WriteString("\t\tif (res == null || res == 0) {\n")
		bw.WriteString("\t\t\tthrow new UnitTestException(\"")
		bw.WriteString(class.ClassName)
		bw.WriteString("Test\", \"test of update is failed\");\n")
		bw.WriteString("\t\t}\n")
		bw.WriteString("\t\tYzLogger.info(\"\tupdate OK\");\n\n")

		bw.WriteString("\t\tInteger del = dao.delete(key);\n")
		bw.WriteString("\t\tif (del == null || del == 0) {\n")
		bw.WriteString("\t\t\tthrow new UnitTestException(\"")
		bw.WriteString(class.ClassName)
		bw.WriteString("Test\", \"test of delete is failed\");\n")
		bw.WriteString("\t\t}\n")
		bw.WriteString("\t\tYzLogger.info(\"\tdelete OK\");\n\n")
	} else if len(class.UnionKeys) > 0 {
		unionKeysString := strings.Join(unionKeys, ", ")
		bw.WriteString("\t\tYzLogger.info(\"\tinsert OK\");\n\n")

		bw.WriteString("\t\t")
		bw.WriteString(class.ClassName)
		bw.WriteString(" objSelect = dao.get")
		bw.WriteString(class.ClassName)
		bw.WriteString("ByKey(")
		bw.WriteString(unionKeysString)
		bw.WriteString(");\n")
		bw.WriteString("\t\tif (objSelect == null) {\n")
		bw.WriteString("\t\t\tthrow new UnitTestException(\"")
		bw.WriteString(class.ClassName)
		bw.WriteString("Test\", \"test of select is failed\");\n")
		bw.WriteString("\t\t}\n")

		bw.WriteString("\t\tYzLogger.info(\"\tselect OK \"+objSelect.toString());\n\n")

		bw.WriteString("\t\tInteger res = dao.update(objSelect);\n")
		bw.WriteString("\t\tif (res == null || res == 0) {\n")
		bw.WriteString("\t\t\tthrow new UnitTestException(\"")
		bw.WriteString(class.ClassName)
		bw.WriteString("Test\", \"test of update is failed\");\n")
		bw.WriteString("\t\t}\n")
		bw.WriteString("\t\tYzLogger.info(\"\tupdate OK\");\n\n")

		bw.WriteString("\t\tInteger del = dao.delete(")
		bw.WriteString(unionKeysString)
		bw.WriteString(");\n")
		bw.WriteString("\t\tif (del == null || del == 0) {\n")
		bw.WriteString("\t\t\tthrow new UnitTestException(\"")
		bw.WriteString(class.ClassName)
		bw.WriteString("Test\", \"test of delete is failed\");\n")
		bw.WriteString("\t\t}\n")
		bw.WriteString("\t\tYzLogger.info(\"\tdelete OK\");\n\n")
	} else {
		bw.WriteString("\t\tdao.insert(objInsert);\n")
		bw.WriteString("\t\tYzLogger.info(\"\tinsert OK\");\n\n")

	}
	bw.WriteString("\t}\n\n")
}
func writeTestTailer(bw *bufio.Writer) {
	bw.WriteString("}\n")
}
