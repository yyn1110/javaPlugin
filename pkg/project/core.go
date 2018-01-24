package project

import (
	"bufio"

	"fmt"
	"github.com/spf13/cobra"
	//"github.com/yyn1110/logs"
	"javaPlugin/pkg/db"
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
	g_testPath          string
	g_testExceptionPath string
	g_mainResourcesPath string
	g_testResourcesPath string
	g_upperDbName       string
	g_excludeNames      []string
)

func InitConfig(cmd *cobra.Command) {

	cmd.Flags().BoolVarP(&useRedis, "useRedis", "r", false, "create redis config ")
	cmd.Flags().StringVar(&pomVersion, "version", "0.1", "pom version")
	cmd.Flags().StringVar(&dbDriver, "dbDriver", "c3p0", "c3p0 or druid")
	cmd.Flags().StringVar(&jdk, "jdk", "1.7", "jdk version")
	cmd.Flags().StringVar(&dbNameTest, "dbNameTest", "", "The empty DB name for unit test.")
	cmd.Flags().StringVar(&packageName, "packageName", "com.java.demo", "The package name of Java classes.")
	cmd.Flags().IntVar(&maxCore, "maxCore", 1, "The max core number. (0: Number of CPU - 1)")
	cmd.Flags().StringVar(&outputPath, "outputPath", "./", "The output file path.")
	cmd.Flags().StringVar(&exclude, "exclude", "open_app_log,health_report_stats_month,drug_question_stats_month,video_stats_month", "The exclude tables name.")
	cmd.Flags().StringVar(&redisHost, "redisHost", "127.0.0.1", "redis host")
	cmd.Flags().StringVar(&redisPort, "redisPort", "6379", "redis port")
	cmd.Flags().StringVar(&redisPassWord, "redisPassWord", "", "redis password")

}

type tableDefine struct {
	Field            string
	Type             string
	DBType           string
	Null             bool
	Key              string
	Default          string
	Extra            string
	Comment          string
	CharacterSetName string
	Schema           string
	TableName        string
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

	var wg sync.WaitGroup
	go run(db.DbClient.Engine(), &wg)
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
	g_upperDbName = strings.ToUpper(db.DbClient.DBName())
	g_packageName = packageName + "." + db.DbClient.DBName()
	g_packageNamePath = strings.Replace(g_packageName, ".", string(filepath.Separator), -1)

	os.RemoveAll(filepath.Join(outputPath, "src"))

	var err error
	g_modelPath = filepath.Join(outputPath, "src", "main", "java", g_packageNamePath, "persistence", "model")
	if err = os.MkdirAll(g_modelPath, 0777); err != nil {
		logs.Logger.Error("Create folder", g_modelPath, "error:", err.Error())
		os.Exit(-1)
	}
	g_daoPath = filepath.Join(outputPath, "src", "main", "java", g_packageNamePath, "persistence", "dao")
	if err = os.MkdirAll(g_daoPath, 0777); err != nil {
		logs.Logger.Error("Create folder", g_daoPath, "error:", err.Error())
		os.Exit(-1)
	}

	g_dataSourcePath = filepath.Join(outputPath, "src", "main", "java", g_packageNamePath, "dataSource")
	if err = os.MkdirAll(g_dataSourcePath, 0777); err != nil {
		logs.Logger.Error("Create folder", g_dataSourcePath, "error:", err.Error())
		os.Exit(-1)
	}
	g_myBatisPath = filepath.Join(outputPath, "src", "main", "resources", g_packageNamePath, "persistence", "sqlmap")
	if err = os.MkdirAll(g_myBatisPath, 0777); err != nil {
		logs.Logger.Error("Create folder", g_myBatisPath, "error:", err.Error())
		os.Exit(-1)
	}

	//g_myBatisExtPath = filepath.Join(outputPath, "src", "main", "resources", g_packageNamePath, "persistence", "sqlmap", "ext")
	//if err = os.MkdirAll(g_myBatisExtPath, 0777); err != nil {
	//	logger.Error("Create folder", g_myBatisExtPath, "error:", err.Error())
	//	os.Exit(-1)
	//}
	g_testPath = filepath.Join(outputPath, "src", "test", "java", g_packageNamePath)
	if err = os.MkdirAll(g_testPath, 0777); err != nil {
		logs.Logger.Error("Create folder", g_testPath, "error:", err.Error())
		os.Exit(-1)
	}
	g_testExceptionPath = filepath.Join(outputPath, "src", "test", "java", g_packageNamePath, "exception")
	if err = os.MkdirAll(g_testExceptionPath, 0777); err != nil {
		logs.Logger.Error("Create folder", g_testExceptionPath, "error:", err.Error())
		os.Exit(-1)
	}
	g_mainResourcesPath = filepath.Join(outputPath, "src", "main", "resources")
	if err = os.MkdirAll(g_mainResourcesPath, 0777); err != nil {
		logs.Logger.Error("Create folder", g_mainResourcesPath, "error:", err.Error())
		os.Exit(-1)
	}
	g_testResourcesPath = filepath.Join(outputPath, "src", "test", "resources")
	if err = os.MkdirAll(g_testResourcesPath, 0777); err != nil {
		logs.Logger.Error("Create folder", g_testResourcesPath, "error:", err.Error())
		os.Exit(-1)
	}

	excludeStrings := strings.Split(exclude, ",")
	for _, excludeString := range excludeStrings {
		g_excludeNames = append(g_excludeNames, excludeString)
	}

}

////////////////////////////////////////////////////
// Write files
func writeFiles() {
	writeLog4j()
	writeConfigProperties()
	writeAbstractTest()
	writeConstants()
	if useRedis {
		writeRedisTest()
	}

}

func writeRedisTest() {
	var err error
	var file *os.File
	if file, err = os.Create(filepath.Join(g_testPath, "RedisTest.java")); err != nil {
		logs.Logger.Error("Create file", filepath.Join(g_testResourcesPath, "RedisTest.java"), ", error:", err.Error())
		return
	}
	defer file.Close()
	bw := bufio.NewWriter(file)
	redis_content := strings.Replace(redis_test_class, "$(package)$", g_packageName, -1)
	bw.WriteString(redis_content)
	bw.Flush()
}
func writeLog4j() {
	var err error
	var file *os.File
	if file, err = os.Create(filepath.Join(g_testResourcesPath, "log4j.xml")); err != nil {
		logs.Logger.Error("Create file", filepath.Join(g_testResourcesPath, "log4j.xml"), ", error:", err.Error())
		return
	}
	defer file.Close()
	bw := bufio.NewWriter(file)
	log4jxml := strings.Replace(log4jXML, "$(packageName)$", g_packageName, -1)
	bw.WriteString(log4jxml)
	bw.Flush()
}

func writeConfigProperties() {
	var err error
	var file *os.File
	if file, err = os.Create(filepath.Join(g_testResourcesPath, (db.DbClient.DBName())+"-db.properties")); err != nil {
		logs.Logger.Error("Create file", filepath.Join(g_testResourcesPath, (db.DbClient.DBName())+"-db.properties"), ", error:", err.Error())
		return
	}
	defer file.Close()
	bw := bufio.NewWriter(file)

	mysql_properties := strings.Replace(ProPerties_Mysql, "$(dbAddr)$", db.DbClient.DBAddr(), -1)
	mysql_properties = strings.Replace(mysql_properties, "$(dbUser)$", db.DbClient.DBUser(), -1)
	mysql_properties = strings.Replace(mysql_properties, "$(dbPassword)$", db.DbClient.DBPassword(), -1)
	mysql_properties = strings.Replace(mysql_properties, "$(dbName)$", db.DbClient.DBName(), -1)

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
	if file, err = os.Create(filepath.Join(g_testPath, "AbstractTest.java")); err != nil {
		logs.Logger.Error("Create file", filepath.Join(g_testPath, "AbstractTest.java"), ", error:", err.Error())
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
	bw.WriteString(db.DbClient.DBName())
	bw.WriteString(`-daoConfig.xml"})
public abstract class AbstractTest {

}`)
	bw.Flush()
}

func writeConstants() {
	var err error
	var file *os.File
	if file, err = os.Create(filepath.Join(g_daoPath, "DataSourceConstants.java")); err != nil {
		logs.Logger.Error("Create file", filepath.Join(g_daoPath, "DataSourceConstants.java"), ", error:", err.Error())
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
	bw.WriteString(db.DbClient.DBName())
	bw.WriteString("\";\n")

	bw.WriteString("\tpublic static final String DATASOURCE_W_")
	bw.WriteString(g_upperDbName)
	bw.WriteString(" = \"dataSource_W_")
	bw.WriteString(db.DbClient.DBName())
	bw.WriteString("\";\n")

	bw.WriteString("}\n")
	bw.Flush()
}

////////////////////////////////////////////////////
// Resource files
func (res *resources) init() {

	var err error

	if res.pomFile, err = os.Create(filepath.Join(outputPath, "pom.xml")); err != nil {
		logs.Logger.Error("Create pom file error %s", err.Error())
		return
	}
	res.pomWriter = bufio.NewWriter(res.pomFile)
	pomxml := strings.Replace(POM_XML, "$(groupId)$", packageName, -1)
	pomxml = strings.Replace(pomxml, "$(artifactId)$", db.DbClient.DBName(), -1)
	pomxml = strings.Replace(pomxml, "$(name)$", db.DbClient.DBName()+"-persistence", -1)
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

	if res.daoConfigFile, err = os.Create(filepath.Join(g_testResourcesPath, (db.DbClient.DBName())+"-daoConfig.xml")); err != nil {
		logs.Logger.Error("Create file", filepath.Join(g_testResourcesPath, (db.DbClient.DBName())+"-daoConfig.xml"), ", error:", err.Error())
		return
	}
	res.daoConfigWriter = bufio.NewWriter(res.daoConfigFile)
	daoConfigXml := strings.Replace(daoConfigXML, "$(packageName)$", g_packageName, -1)

	daoConfigXml = strings.Replace(daoConfigXml, "$(classPath)$", strings.Replace(g_packageName, ".", "/", -1)+"/persistence/sqlmap/*.xml", -1)
	daoConfigXml = strings.Replace(daoConfigXml, "$(classPathExt)$", strings.Replace(g_packageName, ".", "/", -1)+"/persistence/sqlmap/ext/*.xml", -1)

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
	daoConfigXml = strings.Replace(daoConfigXml, "$(properties)$", db.DbClient.DBName()+"-db.properties", -1)
	daoConfigXml = strings.Replace(daoConfigXml, "$(dbName)$", db.DbClient.DBName(), -1)
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
	bw.WriteString(`package ` + g_packageName + ";\n\n")
	bw.WriteString("import " + g_packageName + ".persistence.model." + class.ClassName + ";\n")
	bw.WriteString("import " + g_packageName + ".persistence.dao." + class.ClassName + "Dao;\n")
	header := packageName + "." + db.DbClient.DBName() + ".exception"
	bw.WriteString("import " + header + ".UnitTestException;\n")
	bw.WriteString("import org.slf4j.Logger;\n")
	bw.WriteString("import org.slf4j.LoggerFactory;\n")
	bw.WriteString("import org.junit.Test;\n")
	bw.WriteString("import javax.annotation.Resource;\n")
	bw.WriteString("import org.springframework.transaction.annotation.Transactional;\n\n")

	bw.WriteString("public class " + class.ClassName + "Test extends AbstractTest {\n")
	bw.WriteString("\tprivate static final Logger logger = LoggerFactory.getLogger(" + class.ClassName + ".class);\n")
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
	bw.WriteString("\t\tlogger.info(\"insert [")
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
			bw.WriteString("\t\tlogger.info(\"\tinsert OK\");\n\n")

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
			bw.WriteString("\t\tlogger.info(\"\tselect OK \"+objSelect.toString());\n\n")
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
			bw.WriteString("\t\t\tlogger.info(\"\tinsert OK\");\n\n")
			bw.WriteString("\t\t\tobjSelect = dao.get")
			bw.WriteString(class.ClassName)
			bw.WriteString("ByKey(key);\n")
			bw.WriteString("\t\t\tif (objSelect == null) {\n")
			bw.WriteString("\t\t\tthrow new UnitTestException(\"")
			bw.WriteString(class.ClassName)
			bw.WriteString("Test\", \"test of select is failed\");\n")
			bw.WriteString("\t\t\t}\n")
			bw.WriteString("\t\t\tlogger.info(\"\tselect OK \"+objSelect.toString());\n\n")
			bw.WriteString("\t\t}\n")
		}

		bw.WriteString("\t\tjava.util.List<" + class.ClassName + "> list = dao.get" + class.ClassName + "s(objSelect);\n")
		bw.WriteString("\t\t")
		bw.WriteString(`if (list !=null){
            logger.info("	selectAll OK "+list.toString());
        }else{
            throw new UnitTestException("EcuserWxUserinfoTest", "test of selectAll is failed");
        }` + "\n\n")

		bw.WriteString("\t\tInteger res = dao.update(objSelect);\n")
		bw.WriteString("\t\tif (res == null || res == 0) {\n")
		bw.WriteString("\t\t\tthrow new UnitTestException(\"")
		bw.WriteString(class.ClassName)
		bw.WriteString("Test\", \"test of update is failed\");\n")
		bw.WriteString("\t\t}\n")
		bw.WriteString("\t\tlogger.info(\"\tupdate OK\");\n\n")

		bw.WriteString("\t\tInteger del = dao.delete(key);\n")
		bw.WriteString("\t\tif (del == null || del == 0) {\n")
		bw.WriteString("\t\t\tthrow new UnitTestException(\"")
		bw.WriteString(class.ClassName)
		bw.WriteString("Test\", \"test of delete is failed\");\n")
		bw.WriteString("\t\t}\n")
		bw.WriteString("\t\tlogger.info(\"\tdelete OK\");\n\n")
	} else if len(class.UnionKeys) > 0 {
		unionKeysString := strings.Join(unionKeys, ", ")
		bw.WriteString("\t\tlogger.info(\"\tinsert OK\");\n\n")

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

		bw.WriteString("\t\tlogger.info(\"\tselect OK \"+objSelect.toString());\n\n")

		bw.WriteString("\t\tInteger res = dao.update(objSelect);\n")
		bw.WriteString("\t\tif (res == null || res == 0) {\n")
		bw.WriteString("\t\t\tthrow new UnitTestException(\"")
		bw.WriteString(class.ClassName)
		bw.WriteString("Test\", \"test of update is failed\");\n")
		bw.WriteString("\t\t}\n")
		bw.WriteString("\t\tlogger.info(\"\tupdate OK\");\n\n")

		bw.WriteString("\t\tInteger del = dao.delete(")
		bw.WriteString(unionKeysString)
		bw.WriteString(");\n")
		bw.WriteString("\t\tif (del == null || del == 0) {\n")
		bw.WriteString("\t\t\tthrow new UnitTestException(\"")
		bw.WriteString(class.ClassName)
		bw.WriteString("Test\", \"test of delete is failed\");\n")
		bw.WriteString("\t\t}\n")
		bw.WriteString("\t\tlogger.info(\"\tdelete OK\");\n\n")
	} else {
		bw.WriteString("\t\tdao.insert(objInsert);\n")
		bw.WriteString("\t\tlogger.info(\"\tinsert OK\");\n\n")

	}
	bw.WriteString("\t}\n\n")
}
func writeTestTailer(bw *bufio.Writer) {
	bw.WriteString("}\n")
}
