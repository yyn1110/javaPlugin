package pkg

import (
	"bufio"
	"bytes"
	"crypto/md5"
	"database/sql"

	"fmt"
	"io"
	"os"
	"os/signal"
	"path/filepath"
	"runtime"
	"strconv"
	"strings"
	"sync"
	"syscall"
	"time"
	"unicode"

	_ "github.com/go-sql-driver/mysql"
	"github.com/spf13/cobra"
	"github.com/yyn1110/logs"

)

const (
	programName = "table2class"
	version     = "0.11"
)


var (
	dbAddr      string;
	dbUser      string
	dbPassword  string
	dbName      string
	dbNameTest  string
	packageName string
	maxCore     int
	prefix      string
	outputPath  string
	exclude     string
	logPath string
	createPom bool
	jdk string
	pomVersion string

)
func InitConfig(cmd *cobra.Command){
	cmd.Flags().BoolVarP(&createPom,"createPom","c", false, "creaete pom ")
	cmd.Flags().StringVar(&pomVersion,"version", "0.1", "pom version")
	cmd.Flags().StringVar(&jdk,"jdk", "1.7", "jdk version")
	cmd.Flags().StringVar(&dbAddr,"dbAddr", "10.6.80.97:3306", "The MySQL connect link.")
	cmd.Flags().StringVar(&logPath,"logPath", ".", "the log file path")
	cmd.Flags().StringVar(&dbUser,"dbUser", "root", "The MySQL user name.")
	cmd.Flags().StringVar(&dbPassword,"dbPassword", "dev123", "The MySQL password.")
	cmd.Flags().StringVar(&dbName,"dbName", "yzadmin", "The DB name.")
	cmd.Flags().StringVar(&dbNameTest,"dbNameTest", "", "The empty DB name for unit test.")
	cmd.Flags().StringVar(&packageName,"packageName", "com.yao.yz", "The package name of Java classes.")
	cmd.Flags().IntVar(&maxCore,"maxCore", 1, "The max core number. (0: Number of CPU - 1)")
	cmd.Flags().StringVar(&prefix,"prefix", "yw", "The prefix of table name.")
	cmd.Flags().StringVar(&outputPath,"outputPath", "/Users/hujie/yizhen/tmp", "The output file path.")
	cmd.Flags().StringVar(&exclude,"exclude", "open_app_log,health_report_stats_month,drug_question_stats_month,video_stats_month", "The exclude tables name.")

}
type resources struct {
	daoConfigFile   *os.File
	daoConfigWriter *bufio.Writer

	pomFile 	*os.File
	pomWriter      *bufio.Writer
}

var (
	g_resources         *resources
	g_packageName       string
	g_packageNamePath   string
	g_modelPath         string
	g_daoPath           string
	g_dataSourcePath    string
	g_myBatisPath       string
	g_testPath          string
	g_testExceptionPath          string
	g_mainResourcesPath string
	g_testResourcesPath string
	g_upperDbName       string
	g_excludeNames      []string
)
var (
	logger *logs.BeeLogger
)
func init(){
	log := logs.NewLogger(10000)
	p:=filepath.Join(logPath,"table2class.log")
	lp := fmt.Sprint(`{"filename":"%s", "perm": "0666"}`, p)
	log.SetLogger("file", lp)

	log.SetLogger("console", "")
	logger = log
}
func Run() {
	logger.Info( "%s version[%s]\r\nUsage: %s [OPTIONS]\r\n", programName, version, os.Args[0])

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


	os.RemoveAll(filepath.Join(outputPath,"src"))

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
	g_testPath = filepath.Join(outputPath, "src", "test", "java", g_packageNamePath)
	if err = os.MkdirAll(g_testPath, 0777); err != nil {
		logger.Error("Create folder", g_testPath, "error:", err.Error())
		os.Exit(-1)
	}
	g_testExceptionPath = filepath.Join(outputPath, "src", "test", "java", g_packageNamePath,"exception")
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

	dbURL := fmt.Sprintf("%s:%s@tcp(%s)/%s?charset=utf8", (dbUser), (dbPassword), (dbAddr), (dbName))
	logger.Info(dbURL)
	var dbConn *sql.DB
	dbConn, err = sql.Open("mysql", dbURL)
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

func wait(wg *sync.WaitGroup, ch chan<- bool) {
	wg.Wait()
	ch <- true
}

func run(dbConn *sql.DB, wg *sync.WaitGroup) {
	var err error
	logger.Info("Begin Enter")
	wg.Add(1)
	defer wg.Done()

	// Get tables name
	var rows *sql.Rows
	if rows, err = dbConn.Query("SHOW tables;"); err != nil {
		logger.Error("SHOW tables err:", err.Error())
		return
	}
	defer rows.Close()

	g_resources = &resources{}
	g_resources.init()
	defer g_resources.close()

	writeFiles()

	var tableName string
	for rows.Next() {
		if err = rows.Scan(&tableName); err != nil {
			logger.Error("rows.Scan err:", err.Error())
			return
		}
		if tableNameFilter(tableName) {
			parseTable(dbConn, tableName, wg)
		}
	}
	time.Sleep(time.Second)
	logger.Info("End")
}

func tableNameFilter(tableName string) bool {
	if strings.HasPrefix(tableName, "view_") {
		return false
	}
	for _, excludeString := range g_excludeNames {
		if strings.Contains(tableName, excludeString) {
			return false
		}
	}
	return true
}

type tableDefine struct {
	Field   []byte
	Type    []byte
	Null    []byte
	Key     []byte
	Default []byte
	Extra   []byte
}

const (
	FIELD_TYPE_STRING      = 1
	FIELD_TYPE_INTEGER     = 2
	FIELD_TYPE_FLOAT       = 3
	FIELD_TYPE_TIMESTAMP   = 4
	FIELD_TYPE_DOUBLE      = 5
	FIELD_TYPE_ENUM        = 6
	FIELD_TYPE_SET         = 7
	FIELD_TYPE_POINT       = 8
	FIELD_TYPE_BID_DECIMAL = 9
)

type tableDefineString struct {
	DbFieldName   string
	FieldName     string
	MethodName    string
	Type          int
	TypeString    string
	DbTypeString  string
	Null          string
	Key           string
	Default       string
	Extra         string
	AutoIncrement bool
	TestValue     string
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

func parseTable(dbConn *sql.DB, tableName string, wg *sync.WaitGroup) {
	var err error
	// Get tables name
	wg.Add(1)
	defer wg.Done()
	var rows *sql.Rows
	if rows, err = dbConn.Query("SHOW fields FROM " + tableName); err != nil {
		return
	}
	defer rows.Close()
	var td tableDefine
	var class classDefine
	var tableNameFields []string
	class.Fields = make(map[string]*tableDefineString)
	class.TableName = tableName
	tableNameFields, class.HasPrefix = parseName(tableName, (prefix))
	class.ClassName = toClassName(tableNameFields)
	if len(class.ClassName) == 0 {
		logger.Info("tableName:", tableName)
		logger.Info("tableNameFields: %+v", tableNameFields)
	}
	class.CamelCaseName = toFieldName(tableNameFields)
	index := 0
	for rows.Next() {
		var tds tableDefineString
		if err = rows.Scan(&td.Field, &td.Type, &td.Null, &td.Key, &td.Default, &td.Extra); err != nil {
			logger.Error("Error parse")
			return
		}
		tds.DbFieldName = string(td.Field)
		fieldWords, _ := parseName(tds.DbFieldName, "")
		tds.FieldName = toFieldName(fieldWords)
		tds.MethodName = toClassName(fieldWords)
		keyName := strings.ToLower(tds.FieldName)
		class.Names = append(class.Names, keyName)

		tds.DbTypeString = string(td.Type)
		if strings.HasPrefix(tds.DbTypeString, "varchar") {
			tds.Type = FIELD_TYPE_STRING
			tds.TypeString = "String"
			tds.TestValue = fmt.Sprintf("\"%s\"", getMaxLength(tds.FieldName, tds.DbTypeString))
		} else if strings.HasPrefix(tds.DbTypeString, "text") {
			tds.Type = FIELD_TYPE_STRING
			tds.TypeString = "String"
			tds.TestValue = fmt.Sprintf("\"%s\"", tds.FieldName)
		} else if strings.HasPrefix(tds.DbTypeString, "char") {
			tds.Type = FIELD_TYPE_STRING
			tds.TypeString = "String"
			tds.TestValue = fmt.Sprintf("\"%s\"", getMaxLength(tds.FieldName, tds.DbTypeString))
		} else if strings.HasPrefix(tds.DbTypeString, "mediumtext")  ||  strings.HasPrefix(tds.DbTypeString, "tinytext") ||  strings.HasPrefix(tds.DbTypeString, "longtext"){
			tds.Type = FIELD_TYPE_STRING
			tds.TypeString = "String"
			tds.TestValue = fmt.Sprintf("\"%s\"", tds.FieldName)
		} else if strings.HasPrefix(tds.DbTypeString, "int") {
			tds.Type = FIELD_TYPE_INTEGER
			tds.TypeString = "Integer"
			tds.TestValue = fmt.Sprintf("%d", index+1)
		} else if strings.HasPrefix(tds.DbTypeString, "tinyint") {
			tds.Type = FIELD_TYPE_INTEGER
			tds.TypeString = "Integer"
			tds.TestValue = fmt.Sprintf("%d", index+1)
		} else if strings.HasPrefix(tds.DbTypeString, "smallint") {
			tds.Type = FIELD_TYPE_INTEGER
			tds.TypeString = "Integer"
			tds.TestValue = fmt.Sprintf("%d", index+1)
		} else if strings.HasPrefix(tds.DbTypeString, "mediumint") {
			tds.Type = FIELD_TYPE_INTEGER
			tds.TypeString = "Integer"
			tds.TestValue = fmt.Sprintf("%d", index+1)
		} else if strings.HasPrefix(tds.DbTypeString, "bigint") {
			tds.Type = FIELD_TYPE_INTEGER
			tds.TypeString = "Integer"
			tds.TestValue = fmt.Sprintf("%d", index+1)
		} else if strings.HasPrefix(tds.DbTypeString, "float") {
			tds.Type = FIELD_TYPE_FLOAT
			tds.TypeString = "Float"
			tds.TestValue = fmt.Sprintf("%d.0f", index+1)
		} else if strings.HasPrefix(tds.DbTypeString, "double") {
			tds.Type = FIELD_TYPE_DOUBLE
			tds.TypeString = "Double"
			tds.TestValue = fmt.Sprintf("%d.0", index+1)
		} else if strings.HasPrefix(tds.DbTypeString, "decimal") {
			tds.Type = FIELD_TYPE_BID_DECIMAL
			tds.TypeString = "java.math.BigDecimal"
			tds.TestValue = fmt.Sprintf("new java.math.BigDecimal(%d.0)", index+1)
			logger.Info("%s|%s|%s|odd type: BigDecimal", tableName, class.ClassName, tds.DbFieldName)
		} else if strings.HasPrefix(tds.DbTypeString, "timestamp") {
			tds.Type = FIELD_TYPE_TIMESTAMP
			tds.TypeString = "java.util.Date"
			tds.TestValue = "new java.util.Date()"
			logger.Info("%s|%s|%s|odd type: timestamp", tableName, class.ClassName, tds.DbFieldName)
		} else if strings.HasPrefix(tds.DbTypeString, "date") {
			tds.Type = FIELD_TYPE_TIMESTAMP
			tds.TypeString = "java.util.Date"
			tds.TestValue = "new java.util.Date()"
			logger.Info("%s|%s|%s|odd type: %s", tableName, class.ClassName, tds.DbFieldName, tds.DbTypeString)
		} else if strings.HasPrefix(tds.DbTypeString, "time") {
			tds.Type = FIELD_TYPE_TIMESTAMP
			tds.TypeString = "java.util.Date"
			tds.TestValue = "new java.util.Date()"
			logger.Info("%s|%s|%s|odd type: %s", tableName, class.ClassName, tds.DbFieldName, tds.DbTypeString)
		} else if strings.HasPrefix(tds.DbTypeString, "set") {
			tds.Type = FIELD_TYPE_SET
			tds.TypeString = "String"
			tds.TestValue = fmt.Sprintf("\"%s\"", getFirstItemFromSet(tds.DbTypeString))
			logger.Info("%s|%s|%s|odd type: %s", tableName, class.ClassName, tds.DbFieldName, tds.DbTypeString)
		} else if strings.HasPrefix(tds.DbTypeString, "enum") {
			tds.Type = FIELD_TYPE_ENUM
			tds.TypeString = "String"
			tds.TestValue = fmt.Sprintf("\"%s\"", getFirstItemFromSet(tds.DbTypeString))
			logger.Info("%s|%s|%s|odd type: %s", tableName, class.ClassName, tds.DbFieldName, tds.DbTypeString)
		} else if strings.HasPrefix(tds.DbTypeString, "point") {
			tds.Type = FIELD_TYPE_POINT
			tds.TypeString = "String"
			tds.TestValue = `""` //"\"POINT(1 1)\""
			logger.Info("%s|%s|%s|odd type: %s", tableName, class.ClassName, tds.DbFieldName, tds.DbTypeString)
		} else {
			logger.Info("%s|%s|%s|odd type: %s", tableName, class.ClassName, tds.DbFieldName, tds.DbTypeString)
			continue
		}

		tds.Null = string(td.Null)
		tds.Key = string(td.Key)
		tds.Default = string(td.Default)
		tds.Extra = string(td.Extra)
		if tds.Extra == "auto_increment" {
			tds.AutoIncrement = true
		}
		class.Fields[keyName] = &tds
		switch tds.Key {
		case "PRI":
			class.PrimaryKey = &tds
		case "MUL":
			class.UnionKeys = append(class.UnionKeys, &tds)
		case "UNI":
			class.UnionKeys = append(class.UnionKeys, &tds)
		}
	}
	if class.PrimaryKey == nil {
		if len(class.UnionKeys) == 1 {
			// Fix mysql show fields bug.
			// Get unique key by create table
			var rowsCreateTable *sql.Rows
			if rowsCreateTable, err = dbConn.Query("SHOW create table " + tableName); err != nil {
				return
			}
			defer rowsCreateTable.Close()
			if rowsCreateTable.Next() {
				var t1, t2 string
				if err = rowsCreateTable.Scan(&t1, &t2); err != nil {
					logger.Error("Error parse create table")
					return
				}
				uniqueKeys := getUniqueKeyFrom(t2)
				for _, uniqueKey := range uniqueKeys {
					keyName := strings.ToLower(uniqueKey)
					if field, ok := class.Fields[keyName]; ok {
						if len(field.Key) == 0 {
							field.Key = "UNI"
							class.UnionKeys = append(class.UnionKeys, field)
						}
					}
				}
			} else {
				logger.Error("create table no respones")
			}
			if len(class.UnionKeys) == 1 {
				class.PrimaryKey = class.UnionKeys[0]
				class.UnionKeys = nil
				logger.Info("%s|%s|%s|odd key: Not Primary Key", tableName, class.ClassName, class.PrimaryKey.DbFieldName)
				//fmt.Printf("table %s (class %s) only one key %s\n", class.TableName, class.ClassName, class.PrimaryKey.DbFieldName)
			} else {
				logger.Info("%s|%s|", tableName, class.ClassName)
				for index, key := range class.UnionKeys {
					if index > 0 {
						fmt.Print(",")
					}
					fmt.Print(key.DbFieldName)
				}
				logger.Info("|odd key: Union Key")
			}
		} else if len(class.UnionKeys) > 1 {
			logger.Info("%s|%s|", tableName, class.ClassName)
			for index, key := range class.UnionKeys {
				if index > 0 {
					fmt.Print(", ")
				}
				fmt.Print(key.DbFieldName)
			}
			logger.Info("|odd key: Multi Key")
		}
		if class.PrimaryKey == nil && len(class.UnionKeys) == 0 {
			logger.Info("%s|%s||odd key: No Key", tableName, class.ClassName)
		}
	}
	if class.PrimaryKey != nil {
		if class.PrimaryKey.Type != FIELD_TYPE_INTEGER {
			logger.Info("%s|%s|%s|odd key: Key type is %s", tableName, class.ClassName, class.PrimaryKey.FieldName, class.PrimaryKey.TypeString)
		} else if !class.PrimaryKey.AutoIncrement {
			logger.Info("%s|%s|%s|odd key: not auto increment", tableName, class.ClassName, class.PrimaryKey.FieldName)
		}
	}
	/*
		if class.PrimaryKey != nil && class.PrimaryKey.FieldName != "id" {
			fmt.Printf("table %s (class %s) primary key is %s\n", class.TableName, class.ClassName, class.PrimaryKey.FieldName)
		}*/

	composeClassFile(&class)
	composeDaoFiles(&class)
	composeMappingFiles(&class)
	composeTestFiles(&class)
	composeDataSourceFiles()
	composeTestException()
	g_resources.writeLine(&class)
}

func getMaxLength(name, varcharString string) (result string) {
	ss := strings.Split(varcharString, "(")
	if len(ss) < 2 {
		return
	}
	ss = strings.Split(ss[1], ")")
	var err error
	var length int
	if length, err = strconv.Atoi(ss[0]); err != nil {
		logger.Info("getMaxLength(", name, ", ", varcharString, ", error:", err.Error())
		return
	}
	if len(name) < length {
		result = name
	} else {
		result = name[:length]
	}

	return
}

func getFirstItemFromSet(setString string) (result string) {
	ss := strings.Split(setString, "(")
	if len(ss) < 2 {
		return
	}
	ss = strings.Split(ss[1], ")")
	ss = strings.Split(ss[0], ",")
	result = strings.Trim(ss[0], "' ")
	return
}

func getUniqueKeyFrom(createTableSql string) (uniqueKeys []string) {
	index := strings.Index(createTableSql, "UNIQUE KEY")
	if index < 0 {
		return
	}
	s := createTableSql[index+len("UNIQUE KEY"):]
	ss := strings.Split(s, "(")
	if len(ss) < 2 {
		return
	}
	ss = strings.Split(ss[1], ")")
	if len(ss) < 2 {
		return
	}
	ss = strings.Split(ss[0], ",")
	for _, s = range ss {
		uniqueKeys = append(uniqueKeys, strings.Trim(s, "` "))
	}
	return
}

func composeClassFile(class *classDefine) {
	var err error
	var file *os.File
	if file, err = os.Create(filepath.Join(g_modelPath, class.ClassName+".java")); err != nil {
		logger.Error(filepath.Join(g_modelPath, class.ClassName+".java"), ", error:", err.Error())
		return
	}

	defer file.Close()
	bw := bufio.NewWriter(file)
	writeClassHeader(bw, class)
	writeClassFields(bw, class)
	writeClassGetAndSet(bw, class)
	writeToString(bw, class)
	writeClassTailer(bw)
	bw.Flush()
}
func composeTestException(){
	var err error
	var file *os.File
	if file, err = os.Create(filepath.Join(g_testExceptionPath,"UnitTestException.java")); err != nil {
		logger.Error("Create file", filepath.Join( g_dataSourcePath+"UnitTestException.java"), ", error:", err.Error())
		return
	}

	defer file.Close()
	bw := bufio.NewWriter(file)

	header:=packageName+"."+dbName+".exception"
	bw.WriteString("package "+header+";")
	bw.WriteString(`
	public class UnitTestException extends Exception {
	private static final long serialVersionUID = -6233799140764822106L;
	private String context;
	public UnitTestException(String context, Exception ex) {
		super(ex);
		this.context = context;
	}
	public UnitTestException(String context, String message) {
		super(message);
		this.context = context;
	}
	public String toString() {
		return context + " - " + super.toString();
	}
}
	`)

	bw.Flush()
}
func composeDataSourceFiles() {
	var err error
	var file *os.File
	var dynamicFile *os.File
	var dynamicAspectFile *os.File
	var dynamicAspectHolderFile *os.File
	if file, err = os.Create(filepath.Join( g_dataSourcePath,"DataSource.java")); err != nil {
		logger.Error("Create file", filepath.Join( g_dataSourcePath+"DataSource.java"), ", error:", err.Error())
		return
	}

	defer file.Close()

	if dynamicFile, err = os.Create(filepath.Join( g_dataSourcePath,"DynamicDataSource.java")); err != nil {
		logger.Error("Create file", filepath.Join( g_dataSourcePath+"DynamicDataSource.java"), ", error:", err.Error())
		return
	}

	defer dynamicFile.Close()



	if dynamicAspectFile, err = os.Create(filepath.Join( g_dataSourcePath,"DynamicDataSourceAspect.java")); err != nil {
		logger.Error("Create file", filepath.Join(g_dataSourcePath+"DynamicDataSourceAspect.java"), ", error:", err.Error())
		return
	}

	defer dynamicAspectFile.Close()



	if dynamicAspectHolderFile, err = os.Create(filepath.Join( g_dataSourcePath,"DynamicDataSourceHolder.java")); err != nil {
		logger.Error("Create file", filepath.Join(g_dataSourcePath+"DynamicDataSourceHolder.java"), ", error:", err.Error())
		return
	}

	defer dynamicAspectHolderFile.Close()


	dybw := bufio.NewWriter(dynamicFile)
	dyAsbw := bufio.NewWriter(dynamicAspectFile)
	holder:=bufio.NewWriter(dynamicAspectHolderFile)
	bw := bufio.NewWriter(file)

	header:=packageName+"."+dbName+".dataSource"
	bw.WriteString("package "+header+";")
	bw.WriteString(`
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

	/**
	* 描述: 自定义数据源注解
	*
	*/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface DataSource{

	String value();

}
	`)



	dybw.WriteString("package "+header+";\n")
	dybw.WriteString(`import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;`)
	dybw.WriteString(`
public class DynamicDataSource extends AbstractRoutingDataSource{
   	@Override
   	protected Object determineCurrentLookupKey() {
       		return DynamicDataSourceHolder.getDataSource();
    		}
	}
`)



	dyAsbw.WriteString("package "+header+";")
	dyAsbw.WriteString(`
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;
/**
* 描述：自定义数据源切面
*/
public class DynamicDataSourceAspect {

    private static final Logger logger = Logger.getLogger(DynamicDataSourceAspect.class);

    public void before(JoinPoint point) {
	Object target = point.getTarget();
	String method = point.getSignature().getName();

	Class<?>[] classz = target.getClass().getInterfaces();
	Class<?>[] parameterTypes = ((MethodSignature) point.getSignature()).getMethod().getParameterTypes();
	try {
	    Method m = classz[0].getMethod(method, parameterTypes);
	    if (m != null && m.isAnnotationPresent(DataSource.class)) {
		DataSource data = m.getAnnotation(DataSource.class);
		DynamicDataSourceHolder.setDataSource(data.value());
		logger.debug("Set dataSource of SqlSession : [" + data.value() + "]");
	    }
	} catch (Exception e) {
	    logger.error(e);
	}
    }
}
	`)


	holder.WriteString("package "+header+";")
	holder.WriteString(`
public class DynamicDataSourceHolder {

    public static final ThreadLocal<String> holder = new ThreadLocal<String>();

    public static String getDataSource() {
        return holder.get();
    }

    public static void setDataSource(String dataSourceName) {
        holder.set(dataSourceName);
    }
}
`)



	bw.Flush()
	dyAsbw.Flush()
	dybw.Flush()
	holder.Flush()
}
func composeDaoFiles(class *classDefine) {
	var err error
	var file *os.File
	if file, err = os.Create(filepath.Join(g_daoPath, class.ClassName+"Dao.java")); err != nil {
		logger.Error("Create file", filepath.Join(g_daoPath, class.ClassName+"Dao.java"), ", error:", err.Error())
		return
	}

	defer file.Close()
	bw := bufio.NewWriter(file)
	writeDaoHeader(bw, class)
	writeDaoBody(bw, class)
	writeDaoTailer(bw)
	bw.Flush()
}
func composeMappingFiles(class *classDefine) {
	var err error
	var file *os.File
	if file, err = os.Create(filepath.Join(g_myBatisPath, class.CamelCaseName+"SqlMap.xml")); err != nil {
		logger.Error("Create file", filepath.Join(g_myBatisPath, class.CamelCaseName+"SqlMap.xml"), ", error:", err.Error())
		return
	}

	defer file.Close()
	bw := bufio.NewWriter(file)
	writeMappingHeader(bw, class)
	writeMappingBody(bw, class)
	writeMappingTailer(bw)
	bw.Flush()
}
func composeTestFiles(class *classDefine) {
	var err error
	var file *os.File
	if file, err = os.Create(filepath.Join(g_testPath, class.ClassName+"Test.java")); err != nil {
		logger.Error("Create file", filepath.Join(g_testPath, class.ClassName+"Test.java"), ", error:", err.Error())
		return
	}

	defer file.Close()
	bw := bufio.NewWriter(file)
	writeTestHeader(bw, class)
	writeTestBody(bw, class)
	writeTestTailer(bw)
	bw.Flush()
}

func toClassName(words []string) (result string) {
	for _, word := range words {
		result = result + strings.Title(word)
	}
	return
}

func toFieldName(words []string) (result string) {
	for _, word := range words {
		if len(result) == 0 {
			result = word
		} else {
			result = result + strings.Title(word)
		}
	}
	switch result {
	case "new":
		result = "mNew"
	case "package":
		result = "mPackage"
	}
	return
}

func appendWord(words []string, word string) []string {
	if len(word) == 0 {
		return words
	}
	return append(words, word)
}

func parseName(tableName string, prefixString string) (words []string, hasPrefix bool) {
	word := ""
	for _, c := range tableName {
		if c == '_' {
			// new word
			if len(words) == 0 && len(prefixString) > 0 && word == prefixString {
				hasPrefix = true
			} else {
				words = appendWord(words, word)
			}
			word = ""
		} else if unicode.IsUpper(c) {
			// new word
			words = appendWord(words, word)
			word = string(unicode.ToLower(c))
		} else {
			word = word + string(c)
		}
	}
	words = appendWord(words, word)
	return
}

func writeClassHeader(bw *bufio.Writer, class *classDefine) {
	bw.WriteString(`package `)
	bw.WriteString(g_packageName)
	bw.WriteString(".persistence.model;\n\n")
	bw.WriteString("import java.io.Serializable;\n\n")
	bw.WriteString(`public class `)
	bw.WriteString(class.ClassName)
	bw.WriteString(" implements Serializable {\n")
}
func writeClassFields(bw *bufio.Writer, class *classDefine) {
	hash := md5.New()
	hash.Write([]byte(class.ClassName))
	for _, fieldName := range class.Names {
		logger.Info(class.ClassName + "::" + fieldName)
		field := class.Fields[fieldName]
		hash.Write([]byte(field.TypeString))
		hash.Write([]byte(field.FieldName))
	}
	bw.WriteString(fmt.Sprintf("\tprivate static final long serialVersionUID = 0X%XL;\n", hash.Sum(nil)[4:12]))

	for _, fieldName := range class.Names {
		field := class.Fields[fieldName]
		bw.WriteString("\tprivate ")
		bw.WriteString(field.TypeString)
		bw.WriteString(" ")
		bw.WriteString(field.FieldName)
		bw.WriteString("; // type in db: ")
		bw.WriteString(field.DbTypeString)
		bw.WriteString("\n")
	}
	bw.WriteString("\n")
}
func writeClassGetAndSet(bw *bufio.Writer, class *classDefine) {
	for _, fieldName := range class.Names {
		field := class.Fields[fieldName]
		bw.WriteString("\tpublic ")
		bw.WriteString(field.TypeString)
		bw.WriteString(" get")
		bw.WriteString(field.MethodName)
		bw.WriteString("() {\n\t\treturn this.")
		bw.WriteString(field.FieldName)
		bw.WriteString(";\n\t}\n")
		bw.WriteString("\tpublic void set")
		bw.WriteString(field.MethodName)
		bw.WriteString("(")
		bw.WriteString(field.TypeString)
		bw.WriteString(" ")
		bw.WriteString(field.FieldName)
		bw.WriteString(") {\n\t\tthis.")
		bw.WriteString(field.FieldName)
		bw.WriteString(" = ")
		bw.WriteString(field.FieldName)
		bw.WriteString(";\n\t}\n\n")
	}
}
func writeToString(bw *bufio.Writer, class *classDefine) {
	bw.WriteString("\n\t@Override\n")
	bw.WriteString("\tpublic String toString() {\n")
	bw.WriteString("\t\treturn \"")
	bw.WriteString(class.ClassName)
	bw.WriteString(" [")
	for index, fieldName := range class.Names {
		if index != 0 {
			bw.WriteString(" + \", ")
		}
		field := class.Fields[fieldName]
		bw.WriteString(field.FieldName)
		bw.WriteString("=\" + ")
		bw.WriteString(field.FieldName)
	}
	bw.WriteString(" + \"]\";\n\t}\n")
}
func writeClassTailer(bw *bufio.Writer) {
	bw.WriteString("}\n")
}

////////////////////////////////
// DAO file
func writeDaoHeader(bw *bufio.Writer, class *classDefine) {
	header:=packageName+"."+dbName+".dataSource"
	bw.WriteString(`package `)
	bw.WriteString(g_packageName)
	bw.WriteString(".persistence.dao;\n\n")
	bw.WriteString("import "+header+".DataSource;\n")
	bw.WriteString("import ")
	bw.WriteString(g_packageName)
	bw.WriteString(".persistence.model.")
	bw.WriteString(class.ClassName)
	bw.WriteString(";\n\npublic interface ")
	bw.WriteString(class.ClassName)
	bw.WriteString("Dao {\n")
}
func writeDaoBody(bw *bufio.Writer, class *classDefine) {
	dsw := "\t@DataSource(DataSourceConstants.DATASOURCE_W_" + g_upperDbName + ")\n"
	dsr := "\t@DataSource(DataSourceConstants.DATASOURCE_R_" + g_upperDbName + ")\n"
	// insert method
	bw.WriteString(dsw)
	bw.WriteString("\tpublic int insert(")
	bw.WriteString(class.ClassName)
	bw.WriteString(" s")
	bw.WriteString(class.ClassName)
	bw.WriteString(");\n")

	if class.PrimaryKey != nil {
		keyField := class.PrimaryKey
		// update method
		bw.WriteString(dsw)
		bw.WriteString("\tpublic int update(")
		bw.WriteString(class.ClassName)
		bw.WriteString(" s")
		bw.WriteString(class.ClassName)
		bw.WriteString(");\n")
		// delete method
		bw.WriteString(dsw)
		bw.WriteString("\tpublic int delete(")
		bw.WriteString(keyField.TypeString)
		bw.WriteString(" ")
		bw.WriteString(keyField.FieldName)
		bw.WriteString(");\n")
		// select method
		bw.WriteString(dsr)
		bw.WriteString("\tpublic ")
		bw.WriteString(class.ClassName)
		bw.WriteString(" get")
		bw.WriteString(class.ClassName)
		bw.WriteString("ByKey(")
		bw.WriteString(keyField.TypeString)
		bw.WriteString(" ")
		bw.WriteString(keyField.FieldName)
		bw.WriteString(");\n")
	} else if len(class.UnionKeys) > 0 {
		bw.WriteString("\t/*\n\t * Use union key:\n")
		for _, keyField := range class.UnionKeys {
			bw.WriteString("\t * - ")
			bw.WriteString(keyField.TypeString)
			bw.WriteString(" ")
			bw.WriteString(keyField.FieldName)
			bw.WriteString("\n")
		}
		bw.WriteString("\t */\n")
		// update method
		bw.WriteString(dsw)
		bw.WriteString("\tpublic int update(")
		bw.WriteString(class.ClassName)
		bw.WriteString(" s")
		bw.WriteString(class.ClassName)
		bw.WriteString(");\n")

		// delete method
		bw.WriteString(dsw)
		bw.WriteString("\tpublic int delete(")
		for index, keyField := range class.UnionKeys {
			if index > 0 {
				bw.WriteString(", ")
			}
			bw.WriteString(keyField.TypeString)
			bw.WriteString(" ")
			bw.WriteString(keyField.FieldName)
		}
		bw.WriteString(");\n")

		// select method
		bw.WriteString(dsr)
		bw.WriteString("\tpublic ")
		bw.WriteString(class.ClassName)
		bw.WriteString(" get")
		bw.WriteString(class.ClassName)
		bw.WriteString("ByKey(")
		for index, keyField := range class.UnionKeys {
			if index > 0 {
				bw.WriteString(", ")
			}
			bw.WriteString(keyField.TypeString)
			bw.WriteString(" ")
			bw.WriteString(keyField.FieldName)
		}
		bw.WriteString(");\n")

	} else {
		bw.WriteString("\t/*\n\t * No primary key defined in DB table!\n\t */\n")
	}
}
func writeDaoTailer(bw *bufio.Writer) {
	bw.WriteString("}\n")
}

////////////////////////////////
// Mapping files
func writeMappingHeader(bw *bufio.Writer, class *classDefine) {
	bw.WriteString(`<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
`)
	bw.WriteString(`<mapper namespace="`)
	bw.WriteString(g_packageName)
	bw.WriteString(".persistence.dao.")
	bw.WriteString(class.ClassName)
	bw.WriteString("Dao\">\n\n")
}
func writeMappingBody(bw *bufio.Writer, class *classDefine) {
	bufProperty := new(bytes.Buffer)
	bufMapping := new(bytes.Buffer)
	bufInsert := new(bytes.Buffer)
	bufInsertValue := new(bytes.Buffer)
	bufUpdate := new(bytes.Buffer)
	bufDelete := new(bytes.Buffer)
	bufSelect := new(bytes.Buffer)

	bufProperty.WriteString("\t<!--属性-->\n\t<parameterMap id=\"")
	bufProperty.WriteString(class.CamelCaseName)
	bufProperty.WriteString("ParameterMap\" type=\"")
	bufProperty.WriteString(g_packageName)
	bufProperty.WriteString(".persistence.model.")
	bufProperty.WriteString(class.ClassName)
	bufProperty.WriteString("\">\n")

	bufMapping.WriteString("\t<!--数据库字段与对象属性映射-->\n\t<resultMap id=\"")
	bufMapping.WriteString(class.CamelCaseName)
	bufMapping.WriteString("ResultMap\" type=\"")
	bufMapping.WriteString(g_packageName)
	bufMapping.WriteString(".persistence.model.")
	bufMapping.WriteString(class.ClassName)
	bufMapping.WriteString("\">\n")

	bufInsert.WriteString("\t<!--新增-->\n\t<insert id=\"insert\" parameterMap=\"")
	bufInsert.WriteString(class.CamelCaseName)
	bufInsert.WriteString("ParameterMap\"")
	if class.PrimaryKey != nil {
		bufInsert.WriteString(" keyProperty=\"")
		bufInsert.WriteString(class.PrimaryKey.FieldName)
		bufInsert.WriteString("\" useGeneratedKeys=\"true\"")
	}
	bufInsert.WriteString(">\n")
	bufInsert.WriteString("\t\tinsert into ")
	bufInsert.WriteString(class.TableName)
	bufInsert.WriteString("(")

	bufUpdate.WriteString("\t<!--更新-->\n\t<update id=\"update\" parameterMap=\"")
	bufUpdate.WriteString(class.CamelCaseName)
	bufUpdate.WriteString("ParameterMap\">\n\t\tupdate ")
	bufUpdate.WriteString(class.TableName)
	bufUpdate.WriteString(" set\n\t\t<trim suffixOverrides=\",\">\n")

	bufDelete.WriteString("\t<!--删除-->\n")

	bufSelect.WriteString("\t<!--查询-->\n")
	createSelect := false
	if class.PrimaryKey != nil {
		bufSelect.WriteString("\t<select id=\"get")
		bufSelect.WriteString(class.ClassName)
		bufSelect.WriteString("ByKey\" resultMap=\"")
		bufSelect.WriteString(class.CamelCaseName)
		bufSelect.WriteString("ResultMap\" parameterType=\"")
		switch class.PrimaryKey.Type {
		case FIELD_TYPE_INTEGER:
			bufSelect.WriteString("java.lang.Integer")
		case FIELD_TYPE_STRING:
			bufSelect.WriteString("string")
		default:
			logger.Error("Unsupport primary key type:", class.PrimaryKey.TypeString)
			os.Exit(-1)
		}
		bufSelect.WriteString("\">\n\t\tselect ")
		createSelect = true
	} else if len(class.UnionKeys) > 0 {
		bufSelect.WriteString("\t<select id=\"get")
		bufSelect.WriteString(class.ClassName)
		bufSelect.WriteString("ByKey\" resultMap=\"")
		bufSelect.WriteString(class.CamelCaseName)
		bufSelect.WriteString("ResultMap\" parameterType=\"java.util.Map\">\n\t\tselect ")
		createSelect = true
	}

	for index, fieldKey := range class.Names {
		field := class.Fields[fieldKey]
		bufProperty.WriteString("\t\t<parameter property=\"")
		bufProperty.WriteString(field.FieldName)
		bufProperty.WriteString("\"/>\n")

		bufMapping.WriteString("\t\t<result property=\"")
		bufMapping.WriteString(field.FieldName)
		bufMapping.WriteString("\" column=\"")
		bufMapping.WriteString(field.DbFieldName)
		bufMapping.WriteString("\"/>\n")
		if index > 0 {
			bufInsert.WriteString(",")
			bufInsertValue.WriteString(",")
		}
		bufInsert.WriteString("`")
		bufInsert.WriteString(field.DbFieldName)
		bufInsert.WriteString("`")
		bufInsertValue.WriteString("?")
		if createSelect {
			if index > 0 {
				bufSelect.WriteString(",")
			}
			bufSelect.WriteString("`")
			bufSelect.WriteString(field.DbFieldName)
			bufSelect.WriteString("`")
		}

		if class.PrimaryKey != field {
			bufUpdate.WriteString("\t\t\t<if test=\"")
			bufUpdate.WriteString(field.FieldName)
			bufUpdate.WriteString(" != null\">\n\t\t\t\t`")
			bufUpdate.WriteString(field.DbFieldName)
			bufUpdate.WriteString("`=#{")
			bufUpdate.WriteString(field.FieldName)
			bufUpdate.WriteString("},\n\t\t\t</if>\n")
		}

		index++
	}
	bufProperty.WriteString("\t</parameterMap>\n\n")
	bufMapping.WriteString("\t</resultMap>\n\n")
	bufInsert.WriteString(") values(")
	bufInsertValue.WriteTo(bufInsert)
	bufInsert.WriteString(")\n")

	bufUpdate.WriteString("\t\t</trim>\n")

	if class.PrimaryKey != nil {
		bufInsert.WriteString("\t</insert>\n\n")
		bufUpdate.WriteString("\t\twhere `")
		bufUpdate.WriteString(class.PrimaryKey.DbFieldName)
		bufUpdate.WriteString("`=#{")
		bufUpdate.WriteString(class.PrimaryKey.FieldName)
		bufUpdate.WriteString("}\n\t</update>\n\n")

		bufDelete.WriteString("\t<delete id=\"delete\" parameterType=\"")
		switch class.PrimaryKey.Type {
		case FIELD_TYPE_INTEGER:
			bufDelete.WriteString("java.lang.Integer")
		case FIELD_TYPE_STRING:
			bufDelete.WriteString("string")
		default:
			logger.Error("Unsupport primary key type:", class.PrimaryKey.TypeString)
			os.Exit(-1)
		}
		bufDelete.WriteString("\">\n\t\tdelete from ")
		bufDelete.WriteString(class.TableName)
		bufDelete.WriteString(" where `")
		bufDelete.WriteString(class.PrimaryKey.DbFieldName)
		bufDelete.WriteString("`=#{")
		bufDelete.WriteString(class.PrimaryKey.FieldName)
		bufDelete.WriteString("}\n\t</delete>\n\n")

		bufSelect.WriteString(" from ")
		bufSelect.WriteString(class.TableName)
		bufSelect.WriteString(" where `")
		bufSelect.WriteString(class.PrimaryKey.DbFieldName)
		bufSelect.WriteString("`=#{")
		bufSelect.WriteString(class.PrimaryKey.FieldName)
		bufSelect.WriteString("}\n\t</select>\n\n")
	} else if len(class.UnionKeys) > 0 {
		bufInsert.WriteString("\t\t<!--联合主键-->")

		bufUpdate.WriteString("\t\t<!--联合主键-->\n\t\twhere")

		bufDelete.WriteString("\t<delete id=\"delete\" parameterType=\"java.util.Map\">\n\t\t<!--联合主键-->\n\t\tdelete from ")
		bufDelete.WriteString(class.TableName)
		bufDelete.WriteString(" where ")

		bufSelect.WriteString(" from ")
		bufSelect.WriteString(class.TableName)
		bufSelect.WriteString(" where")
		for index, key := range class.UnionKeys {
			if index > 0 {
				bufUpdate.WriteString(" AND `")
			} else {
				bufUpdate.WriteString(" `")
			}
			bufUpdate.WriteString(key.DbFieldName)
			bufUpdate.WriteString("`=#{")
			bufUpdate.WriteString(key.FieldName)
			bufUpdate.WriteString("}")

			if index > 0 {
				bufDelete.WriteString(" AND `")
			} else {
				bufDelete.WriteString(" `")
			}
			bufDelete.WriteString(key.DbFieldName)
			bufDelete.WriteString("`=#{")
			bufDelete.WriteString(strconv.Itoa(index))
			bufDelete.WriteString("}")

			if index > 0 {
				bufSelect.WriteString(" AND `")
			} else {
				bufSelect.WriteString(" `")
			}
			bufSelect.WriteString(key.DbFieldName)
			bufSelect.WriteString("`=#{")
			bufSelect.WriteString(strconv.Itoa(index))
			bufSelect.WriteString("}")
		}
		bufInsert.WriteString("\n\t</insert>\n\n")
		bufUpdate.WriteString("\n\t</update>\n\n")
		bufDelete.WriteString("\n\t</delete>\n\n")
		bufSelect.WriteString("\n\t</select>\n\n")

	} else {
		bufInsert.WriteString("\t\t<!--没有主键-->\n\t</insert>\n\n")
		bufUpdate.WriteString("\t\t<!--没有主键-->\n\t</update>\n\n")
		bufDelete.WriteString("\t<!--没有主键-->\n\n")
		bufSelect.WriteString("\t<!--没有主键-->\n\n")
	}

	// Properties
	io.Copy(bw, bufProperty)
	// Mapping
	io.Copy(bw, bufMapping)
	// insert
	io.Copy(bw, bufInsert)
	// update
	io.Copy(bw, bufUpdate)
	// delete
	io.Copy(bw, bufDelete)
	// select
	io.Copy(bw, bufSelect)

}
func writeMappingTailer(bw *bufio.Writer) {
	bw.WriteString("</mapper>\n")
}

////////////////////////////////
// Test file
func writeTestHeader(bw *bufio.Writer, class *classDefine) {
	bw.WriteString(`package `)
	bw.WriteString(g_packageName)
	bw.WriteString(";\n\n")
	bw.WriteString("import ")
	bw.WriteString(g_packageName)
	bw.WriteString(".persistence.model.")
	bw.WriteString(class.ClassName)
	bw.WriteString(";\n")
	bw.WriteString("import ")
	bw.WriteString(g_packageName)
	bw.WriteString(".persistence.dao.")
	bw.WriteString(class.ClassName)
	bw.WriteString("Dao;\n")
	header:=packageName+"."+dbName+".exception"
	bw.WriteString("import "+header+".UnitTestException;\n")
	bw.WriteString("import org.apache.log4j.Logger;\n")
	bw.WriteString("import org.junit.Test;\n")
	bw.WriteString("import org.springframework.beans.factory.annotation.Autowired;\n\n")
	bw.WriteString("public class ")
	bw.WriteString(class.ClassName)
	bw.WriteString("Test extends AbstractTest {\n")
	bw.WriteString("\tprivate static final Logger LOGGER = Logger.getLogger(")
	bw.WriteString(class.ClassName)
	bw.WriteString(".class);\n")
}
func writeTestBody(bw *bufio.Writer, class *classDefine) {
	bw.WriteString("\t@Autowired\n\tprivate ")
	bw.WriteString(class.ClassName)
	bw.WriteString("Dao dao;\n")
	// setObjVal function
	bw.WriteString("\n\tprivate void setObjVal(")
	bw.WriteString(class.ClassName)
	bw.WriteString(" sObj) {\n")

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
		bw.WriteString("\t\tsObj.set")
		bw.WriteString(field.MethodName)
		bw.WriteString("(")
		bw.WriteString(field.TestValue)
		bw.WriteString(");\n")
		index++
	}
	for _, field := range class.UnionKeys {
		unionKeys = append(unionKeys, field.TestValue)
	}

	bw.WriteString("\t}\n\n")

	// Test case
	bw.WriteString("\t@Test\n\tpublic void testCase() throws UnitTestException {\n\t\t")
	bw.WriteString(class.ClassName)
	bw.WriteString(" objInsert = new ")
	bw.WriteString(class.ClassName)
	bw.WriteString("();\n\t\tsetObjVal(objInsert);\n\n")
	bw.WriteString("\t\tLOGGER.info(\"+ [")
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
			bw.WriteString("\t\tLOGGER.info(\"\tinsert OK\");\n\n")

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
			bw.WriteString("\t\tLOGGER.info(\"\tselect OK\");\n\n")
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
			bw.WriteString("\t\t\tLOGGER.info(\"\tinsert OK\");\n\n")
			bw.WriteString("\t\t\tobjSelect = dao.get")
			bw.WriteString(class.ClassName)
			bw.WriteString("ByKey(key);\n")
			bw.WriteString("\t\t\tif (objSelect == null) {\n")
			bw.WriteString("\t\t\tthrow new UnitTestException(\"")
			bw.WriteString(class.ClassName)
			bw.WriteString("Test\", \"test of select is failed\");\n")
			bw.WriteString("\t\t\t}\n")
			bw.WriteString("\t\t\tLOGGER.info(\"\tselect OK\");\n\n")
			bw.WriteString("\t\t}\n")
		}

		bw.WriteString("\t\tInteger res = dao.update(objSelect);\n")
		bw.WriteString("\t\tif (res == null || res == 0) {\n")
		bw.WriteString("\t\t\tthrow new UnitTestException(\"")
		bw.WriteString(class.ClassName)
		bw.WriteString("Test\", \"test of update is failed\");\n")
		bw.WriteString("\t\t}\n")
		bw.WriteString("\t\tLOGGER.info(\"\tupdate OK\");\n\n")

		bw.WriteString("\t\tInteger del = dao.delete(key);\n")
		bw.WriteString("\t\tif (del == null || del == 0) {\n")
		bw.WriteString("\t\t\tthrow new UnitTestException(\"")
		bw.WriteString(class.ClassName)
		bw.WriteString("Test\", \"test of delete is failed\");\n")
		bw.WriteString("\t\t}\n")
		bw.WriteString("\t\tLOGGER.info(\"\tdelete OK\");\n\n")
	} else if len(class.UnionKeys) > 0 {
		unionKeysString := strings.Join(unionKeys, ", ")
		bw.WriteString("\t\tLOGGER.info(\"\tinsert OK\");\n\n")

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
		bw.WriteString("\t\tLOGGER.info(\"\tselect OK\");\n\n")

		bw.WriteString("\t\tInteger res = dao.update(objSelect);\n")
		bw.WriteString("\t\tif (res == null || res == 0) {\n")
		bw.WriteString("\t\t\tthrow new UnitTestException(\"")
		bw.WriteString(class.ClassName)
		bw.WriteString("Test\", \"test of update is failed\");\n")
		bw.WriteString("\t\t}\n")
		bw.WriteString("\t\tLOGGER.info(\"\tupdate OK\");\n\n")

		bw.WriteString("\t\tInteger del = dao.delete(")
		bw.WriteString(unionKeysString)
		bw.WriteString(");\n")
		bw.WriteString("\t\tif (del == null || del == 0) {\n")
		bw.WriteString("\t\t\tthrow new UnitTestException(\"")
		bw.WriteString(class.ClassName)
		bw.WriteString("Test\", \"test of delete is failed\");\n")
		bw.WriteString("\t\t}\n")
		bw.WriteString("\t\tLOGGER.info(\"\tdelete OK\");\n\n")
	} else {
		bw.WriteString("\t\tdao.insert(objInsert);\n")
		bw.WriteString("\t\tLOGGER.info(\"\tinsert OK\");\n\n")

	}
	bw.WriteString("\t}\n\n")
}
func writeTestTailer(bw *bufio.Writer) {
	bw.WriteString("}\n")
}

////////////////////////////////////////////////////
// Resource files
func (res *resources) init() {

	var err error

	if createPom{
		if  res.pomFile,err=os.Create(filepath.Join(outputPath,"pom.xml"));err!=nil{
			logger.Error("Create pom file error %s" ,err.Error())
			return
		}
		res.pomWriter = bufio.NewWriter(res.pomFile)
		pomxml:=strings.Replace(POM_XML,"$(groupId)$",packageName,-1)
		pomxml = strings.Replace(pomxml,"$(artifactId)$",dbName+"-db",-1)
		pomxml = strings.Replace(pomxml,"$(name)$",dbName+"-persistence",-1)
		pomxml = strings.Replace(pomxml,"$(description)$","description for this project",-1)
		pomxml = strings.Replace(pomxml,"$(jdk)$",jdk,-1)
		pomxml = strings.Replace(pomxml,"$(version)$",pomVersion,-1)

		res.pomWriter.WriteString(pomxml)

	}



	if res.daoConfigFile, err = os.Create(filepath.Join(g_testResourcesPath, (dbName)+"-daoConfig.xml")); err != nil {
		logger.Error("Create file", filepath.Join(g_testResourcesPath, (dbName)+"-daoConfig.xml"), ", error:", err.Error())
		return
	}
	res.daoConfigWriter = bufio.NewWriter(res.daoConfigFile)
	daoConfigXml:=strings.Replace(daoConfigXML,"$(packageName)$",g_packageName,-1)
	daoConfigXml=strings.Replace(daoConfigXml,"$(properties)$",dbName+"-db.properties",-1)
	daoConfigXml=strings.Replace(daoConfigXml,"$(dbName)$",dbName,-1)
	daoConfigXml=strings.Replace(daoConfigXml,"$(driver)$","com.mchange.v2.c3p0.ComboPooledDataSource",-1)
	daoConfigXml=strings.Replace(daoConfigXml,"$(classPath)$",strings.Replace(g_packageName, ".", "/", -1)+"/persistence/sqlmap/*.xml",-1)

	res.daoConfigWriter.WriteString(daoConfigXml)

	/*
	res.daoConfigWriter.WriteString(`<?xml version="1.0" encoding="utf-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
	   xmlns:aop="http://www.springframework.org/schema/aop"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
		    http://www.springframework.org/schema/beans/spring-beans-3.0.xsd
			http://www.springframework.org/schema/context
			http://www.springframework.org/schema/context/spring-context.xsd
			http://www.springframework.org/schema/aop
			http://www.springframework.org/schema/aop/spring-aop-2.5.xsd"
       default-init-method="init"
       default-lazy-init="false"
       default-destroy-method="destroy">

	<!--开启注解扫描-->
`)
	res.daoConfigWriter.WriteString("\t<context:component-scan base-package=\"")
	res.daoConfigWriter.WriteString(g_packageName)
	res.daoConfigWriter.WriteString("\"/>\n")
	res.daoConfigWriter.WriteString(`	<!--属性加载-->
	<bean id="jdbcConfig" class="org.springframework.beans.factory.config.PropertyPlaceholderConfigurer">
		<property name="locations">
			<list>
				<value>classpath:`)
	res.daoConfigWriter.WriteString(dbName)
	res.daoConfigWriter.WriteString(`-db.properties</value>
			</list>
		</property>
	</bean>
`)
	res.daoConfigWriter.WriteString("\t<bean id=\"dataSource_R_")
	res.daoConfigWriter.WriteString(dbName)
	res.daoConfigWriter.WriteString(`" class="com.mchange.v2.c3p0.ComboPooledDataSource" destroy-method="close">
`)
	res.daoConfigWriter.WriteString("\t\t<property name=\"driverClass\" value=\"${datasource_")
	res.daoConfigWriter.WriteString(dbName)
	res.daoConfigWriter.WriteString(`_r.driverClassName}" />
`)
	res.daoConfigWriter.WriteString("\t\t<property name=\"jdbcUrl\" value=\"${datasource_")
	res.daoConfigWriter.WriteString(dbName)
	res.daoConfigWriter.WriteString(`_r.url}" />
`)
	res.daoConfigWriter.WriteString("\t\t<property name=\"user\" value=\"${datasource_")
	res.daoConfigWriter.WriteString(dbName)
	res.daoConfigWriter.WriteString(`_r.username}" />
`)
	res.daoConfigWriter.WriteString("\t\t<property name=\"password\" value=\"${datasource_")
	res.daoConfigWriter.WriteString(dbName)
	res.daoConfigWriter.WriteString(`_r.password}" />
`)
	res.daoConfigWriter.WriteString("\t\t<property name=\"initialPoolSize\" value=\"${datasource_")
	res.daoConfigWriter.WriteString(dbName)
	res.daoConfigWriter.WriteString(`_r.initialPoolSize}" />
`)
	res.daoConfigWriter.WriteString("\t\t<property name=\"maxPoolSize\" value=\"${datasource_")
	res.daoConfigWriter.WriteString(dbName)
	res.daoConfigWriter.WriteString(`_r.maxPoolSize}" />
`)
	res.daoConfigWriter.WriteString("\t\t<property name=\"minPoolSize\" value=\"${datasource_")
	res.daoConfigWriter.WriteString(dbName)
	res.daoConfigWriter.WriteString(`_r.minPoolSize}" />
`)
	res.daoConfigWriter.WriteString("\t\t<property name=\"maxIdleTime\" value=\"${datasource_")
	res.daoConfigWriter.WriteString(dbName)
	res.daoConfigWriter.WriteString(`_r.maxIdleTime}" />
`)
	res.daoConfigWriter.WriteString("\t</bean>\n")

	res.daoConfigWriter.WriteString("\t<bean id=\"dataSource_W_")
	res.daoConfigWriter.WriteString(dbName)
	res.daoConfigWriter.WriteString(`" class="com.mchange.v2.c3p0.ComboPooledDataSource" destroy-method="close">
`)
	res.daoConfigWriter.WriteString("\t\t<property name=\"driverClass\" value=\"${datasource_")
	res.daoConfigWriter.WriteString(dbName)
	res.daoConfigWriter.WriteString(`_w.driverClassName}" />
`)
	res.daoConfigWriter.WriteString("\t\t<property name=\"jdbcUrl\" value=\"${datasource_")
	res.daoConfigWriter.WriteString(dbName)
	res.daoConfigWriter.WriteString(`_w.url}" />
`)
	res.daoConfigWriter.WriteString("\t\t<property name=\"user\" value=\"${datasource_")
	res.daoConfigWriter.WriteString(dbName)
	res.daoConfigWriter.WriteString(`_w.username}" />
`)
	res.daoConfigWriter.WriteString("\t\t<property name=\"password\" value=\"${datasource_")
	res.daoConfigWriter.WriteString(dbName)
	res.daoConfigWriter.WriteString(`_w.password}" />
`)
	res.daoConfigWriter.WriteString("\t\t<property name=\"initialPoolSize\" value=\"${datasource_")
	res.daoConfigWriter.WriteString(dbName)
	res.daoConfigWriter.WriteString(`_w.initialPoolSize}" />
`)
	res.daoConfigWriter.WriteString("\t\t<property name=\"maxPoolSize\" value=\"${datasource_")
	res.daoConfigWriter.WriteString(dbName)
	res.daoConfigWriter.WriteString(`_w.maxPoolSize}" />
`)
	res.daoConfigWriter.WriteString("\t\t<property name=\"minPoolSize\" value=\"${datasource_")
	res.daoConfigWriter.WriteString(dbName)
	res.daoConfigWriter.WriteString(`_w.minPoolSize}" />
`)
	res.daoConfigWriter.WriteString("\t\t<property name=\"maxIdleTime\" value=\"${datasource_")
	res.daoConfigWriter.WriteString(dbName)
	res.daoConfigWriter.WriteString(`_w.maxIdleTime}" />
`)
	res.daoConfigWriter.WriteString("\t</bean>\n")
	header:=packageName+"."+dbName+".dataSource"
	res.daoConfigWriter.WriteString(`
	<!--自定义数据源，将所有的数据源都纳入自定数据源管理-->
	<bean id="dataSource" class="`+header+".DynamicDataSource")

	res.daoConfigWriter.WriteString(`">
		<property name="targetDataSources">
			<map key-type="java.lang.String">
				<!--写数据源-->
				<entry key="dataSource_R_`)
	res.daoConfigWriter.WriteString(dbName)
	res.daoConfigWriter.WriteString(`" value-ref="dataSource_R_`)
	res.daoConfigWriter.WriteString(dbName)
	res.daoConfigWriter.WriteString(`"/>
				<!--读数据源-->
				<entry key="dataSource_W_`)
	res.daoConfigWriter.WriteString(dbName)
	res.daoConfigWriter.WriteString(`" value-ref="dataSource_W_`)
	res.daoConfigWriter.WriteString(dbName)
	res.daoConfigWriter.WriteString(`"/>
			</map>
		</property>
	</bean>
`)

	res.daoConfigWriter.WriteString("\t<!--配置myBatis数据库连接工厂-->\n")
	res.daoConfigWriter.WriteString("\t<bean id=\"sqlSessionFactory\" class=\"org.mybatis.spring.SqlSessionFactoryBean\">\n")
	res.daoConfigWriter.WriteString("\t\t<property name=\"dataSource\" ref=\"dataSource\"/>\n")
	res.daoConfigWriter.WriteString("\t\t<property name=\"mapperLocations\" value=\"classpath:/")
	res.daoConfigWriter.WriteString(strings.Replace(g_packageName, ".", "/", -1))
	res.daoConfigWriter.WriteString("/persistence/sqlmap/*.xml")
	res.daoConfigWriter.WriteString("\"/>\n")
	res.daoConfigWriter.WriteString("\t</bean>\n")

	res.daoConfigWriter.WriteString("\t<!--采用自动扫描方式创建mapper bean-->\n")
	res.daoConfigWriter.WriteString("\t<bean class=\"org.mybatis.spring.mapper.MapperScannerConfigurer\">\n")
	res.daoConfigWriter.WriteString("\t\t<property name=\"basePackage\" value=\"")
	res.daoConfigWriter.WriteString(g_packageName)
	res.daoConfigWriter.WriteString(".persistence.dao\"/>\n")
	res.daoConfigWriter.WriteString("\t\t<property name=\"sqlSessionFactoryBeanName\" value=\"sqlSessionFactory\"/>\n")
	res.daoConfigWriter.WriteString("\t</bean>\n")


	s:=`
	<!--采用AOP注解的方式决定使用哪个数据源-->
	<bean id="dataSourceAspect" class="com.yao.yz.util.datasource.DynamicDataSourceAspect"/>
	<aop:config>
		<aop:aspect id="DynamicDataSourceAspect" ref="dataSourceAspect">
			<aop:pointcut id="dataSourcePoint" expression="execution(* `


	s=strings.Replace(s,"com.yao.yz.util.datasource",header,-1)
	res.daoConfigWriter.WriteString(s)



	res.daoConfigWriter.WriteString(g_packageName)
	res.daoConfigWriter.WriteString(`.persistence.dao.*.*(..))"/>
			<aop:before method="before" pointcut-ref="dataSourcePoint"/>
		</aop:aspect>
	</aop:config>
`)
	*/
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

////////////////////////////////////////////////////
// Write files
func writeFiles() {
	writeLog4j()
	writeConfigProperties()
	writeAbstractTest()
	writeConstants()
}

func writeLog4j() {
	var err error
	var file *os.File
	if file, err = os.Create(filepath.Join(g_testResourcesPath, "log4j.xml")); err != nil {
		logger.Error("Create file", filepath.Join(g_testResourcesPath, "log4j.xml"), ", error:", err.Error())
		return
	}
	defer file.Close()
	bw := bufio.NewWriter(file)
	bw.WriteString(`<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE log4j:configuration PUBLIC "-//APACHE//DTD LOG4J 1.2//EN" "log4j.dtd">

<log4j:configuration>
	
	<appender name="CONSOLE" class="org.apache.log4j.ConsoleAppender">
		<layout class="org.apache.log4j.PatternLayout">
			<param name="ConversionPattern" value="[%d{HH:mm:ss.SSS\} %-5p][%t]%c{1}.%M(%L) | %m%n" />
		</layout>
	</appender>

	<appender name="LOGFILE" class="org.apache.log4j.DailyRollingFileAppender">
		<param name="File" value="yz-persistence.log" />
		<param name="DatePattern" value=".yyyyMMdd-HH" />
		<param name="encoding" value="UTF-8"/>
		<layout class="org.apache.log4j.PatternLayout">
			<param name="ConversionPattern"
				value="[%d{HH:mm:ss.SSS\} %-5p][%t]%c{1}.%M(%L) | %m%n" />
		</layout>
	</appender>
	<!-- Suppress success logging from InteractiveAuthenticationSuccessEvent -->
	<logger name="org.springframework.security">
		<level value="ERROR" />
	</logger>

	<logger name="org.apache">
		<level value="ERROR" />
	</logger>

	<logger name="com.opensymphony">
		<level value="ERROR" />
	</logger>

	<logger name="org.apache.velocity">
		<level value="ERROR" />
	</logger>

	<logger name="org.springframework">
		<level value="ERROR" />
	</logger>

	<logger name="net.sf">
		<level value="ERROR" />
	</logger>

	<logger name="org.castor">
		<level value="ERROR" />
	</logger>

	<logger name="org.exolab">
		<level value="ERROR" />
	</logger>

	<logger name="com.ibatis" additivity="true">
		<level value="ERROR" />
	</logger>
	<logger name="java.sql.Connection" additivity="true">
		<level value="ERROR" />
	</logger>
	<logger name="java.sql.Statement" additivity="true">
		<level value="ERROR" />
	</logger>
	<logger name="java.sql.PreparedStatement" additivity="true">
		<level value="ERROR" />
	</logger>
	<logger name="java.sql.ResultSet" additivity="true">
		<level value="ERROR" />
	</logger>
	<logger name="`)
	bw.WriteString(g_packageName)
	bw.WriteString(`" additivity="true">
		<level value="INFO" />
	</logger>
	
	<root>
		<level value="ERROR" />
		<appender-ref ref="CONSOLE" />
	</root>
</log4j:configuration>
`)
	bw.Flush()
}

func writeConfigProperties() {
	var err error
	var file *os.File
	if file, err = os.Create(filepath.Join(g_testResourcesPath, (dbName)+"-db.properties")); err != nil {
		logger.Error("Create file", filepath.Join(g_testResourcesPath, (dbName)+"-db.properties"), ", error:", err.Error())
		return
	}
	defer file.Close()
	bw := bufio.NewWriter(file)
	bw.WriteString("datasource_")
	bw.WriteString(dbName)
	bw.WriteString("_r.driverClassName=com.mysql.jdbc.Driver\n")
	bw.WriteString("datasource_")
	bw.WriteString(dbName)
	bw.WriteString("_r.url=jdbc:mysql://")
	bw.WriteString(dbAddr)
	bw.WriteString("/")
	if len(dbNameTest) == 0 {
		bw.WriteString(dbName)
	} else {
		bw.WriteString(dbNameTest)
	}
	bw.WriteString("?useUnicode=true&amp;characterEncoding=UTF-8&amp;zeroDateTimeBehavior=convertToNull\n")
	bw.WriteString("datasource_")
	bw.WriteString(dbName)
	bw.WriteString("_r.username=")
	bw.WriteString(dbUser)
	bw.WriteString("\n")
	bw.WriteString("datasource_")
	bw.WriteString(dbName)
	bw.WriteString("_r.password=")
	bw.WriteString(dbPassword)
	bw.WriteString("\n")
	bw.WriteString("datasource_")
	bw.WriteString(dbName)
	bw.WriteString("_r.initialPoolSize=5\n")
	bw.WriteString("datasource_")
	bw.WriteString(dbName)
	bw.WriteString("_r.maxPoolSize=30\n")
	bw.WriteString("datasource_")
	bw.WriteString(dbName)
	bw.WriteString("_r.minPoolSize=10\n")
	bw.WriteString("datasource_")
	bw.WriteString(dbName)
	bw.WriteString("_r.maxIdleTime=300000\n")

	bw.WriteString("datasource_")
	bw.WriteString(dbName)
	bw.WriteString("_w.driverClassName=com.mysql.jdbc.Driver\n")
	bw.WriteString("datasource_")
	bw.WriteString(dbName)
	bw.WriteString("_w.url=jdbc:mysql://")
	bw.WriteString(dbAddr)
	bw.WriteString("/")
	if len(dbNameTest) == 0 {
		bw.WriteString(dbName)
	} else {
		bw.WriteString(dbNameTest)
	}
	bw.WriteString("?useUnicode=true&amp;characterEncoding=UTF-8&amp;zeroDateTimeBehavior=convertToNull\n")
	bw.WriteString("datasource_")
	bw.WriteString(dbName)
	bw.WriteString("_w.username=")
	bw.WriteString(dbUser)
	bw.WriteString("\n")
	bw.WriteString("datasource_")
	bw.WriteString(dbName)
	bw.WriteString("_w.password=")
	bw.WriteString(dbPassword)
	bw.WriteString("\n")
	bw.WriteString("datasource_")
	bw.WriteString(dbName)
	bw.WriteString("_w.initialPoolSize=5\n")
	bw.WriteString("datasource_")
	bw.WriteString(dbName)
	bw.WriteString("_w.maxPoolSize=30\n")
	bw.WriteString("datasource_")
	bw.WriteString(dbName)
	bw.WriteString("_w.minPoolSize=10\n")
	bw.WriteString("datasource_")
	bw.WriteString(dbName)
	bw.WriteString("_w.maxIdleTime=300000\n")
	bw.Flush()
}

func writeAbstractTest() {
	var err error
	var file *os.File
	if file, err = os.Create(filepath.Join(g_testPath, "AbstractTest.java")); err != nil {
		logger.Error("Create file", filepath.Join(g_testPath, "AbstractTest.java"), ", error:", err.Error())
		return
	}
	defer file.Close()
	bw := bufio.NewWriter(file)

	bw.WriteString("package ")
	bw.WriteString(g_packageName)
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
	if file, err = os.Create(filepath.Join(g_daoPath, "DataSourceConstants.java")); err != nil {
		logger.Error("Create file", filepath.Join(g_daoPath, "DataSourceConstants.java"), ", error:", err.Error())
		return
	}
	defer file.Close()
	bw := bufio.NewWriter(file)

	bw.WriteString(`package `)
	bw.WriteString(g_packageName)
	bw.WriteString(".persistence.dao;\n\n")

	bw.WriteString("public class DataSourceConstants {\n")

	bw.WriteString("\tpublic static final String DATASOURCE_R_")
	bw.WriteString(g_upperDbName)
	bw.WriteString(" = \"dataSource_R_")
	bw.WriteString(dbName)
	bw.WriteString("\";\n")

	bw.WriteString("\tpublic static final String DATASOURCE_W_")
	bw.WriteString(g_upperDbName)
	bw.WriteString(" = \"dataSource_W_")
	bw.WriteString(dbName)
	bw.WriteString("\";\n")

	bw.WriteString("}\n")
	bw.Flush()
}
