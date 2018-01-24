package project

import (
	"bufio"
	"bytes"
	"crypto/md5"

	"fmt"
	"io"
	"javaPlugin/pkg/logs"
	"os"
	"path/filepath"
	"strconv"
	"strings"
	"sync"

	_ "github.com/go-sql-driver/mysql"
	"github.com/go-xorm/xorm"
	"javaPlugin/pkg/db"
	"time"
	"unicode"
)

func wait(wg *sync.WaitGroup, ch chan<- bool) {
	wg.Wait()
	ch <- true
}

func run(dbConn *xorm.Engine, wg *sync.WaitGroup) {

	logs.Logger.Info("Begin Enter")
	wg.Add(1)
	defer wg.Done()

	// Get tables name
	tableList := make([]string, 0)
	//var rows *sql.Rows
	if err := dbConn.SQL("SHOW tables;").Find(&tableList); err != nil {
		logs.Logger.Error("SHOW tables err:", err.Error())
		return
	}
	//defer rows.Close()

	g_resources = &resources{}
	g_resources.init()
	defer g_resources.close()

	writeFiles()

	for _, tableName := range tableList {

		if tableNameFilter(tableName) {
			parseTable(dbConn, tableName, wg)
		}
	}
	time.Sleep(time.Second)
	logs.Logger.Info("End")
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

func parseTable(dbConn *xorm.Engine, tableName string, wg *sync.WaitGroup) {
	//var err error
	// Get tables name
	wg.Add(1)
	defer wg.Done()
	//var rows *sql.Rows
	list := make([]*db.TableSchema, 0)
	sql := fmt.Sprintf("select COLUMN_NAME,DATA_TYPE,IS_NULLABLE,COLUMN_KEY,COLUMN_DEFAULT,EXTRA,COLUMN_COMMENT,CHARACTER_SET_NAME,TABLE_SCHEMA,TABLE_NAME,COLUMN_TYPE from INFORMATION_SCHEMA.Columns where table_name= '%s' and TABLE_SCHEMA='%s'", tableName, db.DbClient.DBName())
	if err := dbConn.SQL(sql).Find(&list); err != nil {
		return
	}
	//defer rows.Close()
	//td:=new(tableDefine)
	var class classDefine
	var tableNameFields []string
	class.Fields = make(map[string]*tableDefineString)
	class.TableName = tableName
	tableNameFields, class.HasPrefix = parseName(tableName, "")
	class.ClassName = toClassName(tableNameFields)
	if len(class.ClassName) == 0 {
		logs.Logger.Info("tableName:", tableName)
		logs.Logger.Info("tableNameFields: %+v", tableNameFields)
	}
	class.CamelCaseName = toFieldName(tableNameFields)
	//index := 0

	for _, value := range list {
		tds := new(tableDefineString)
		tds.DbFieldName = value.ColumnName // string(td.Field)
		allType := value.ColumnType        // string(td.DBType)
		fieldLen := ""

		beginIndex := strings.Index(allType, "(")

		if beginIndex >= 0 {
			endIndex := strings.Index(allType, ")")
			if endIndex >= 0 {
				fieldLen = allType[beginIndex+1 : endIndex]
			}
		}

		fl := fieldLen
		if len(fl) > 0 {
			i, err := strconv.Atoi(fl)
			if err != nil {
				tds.FieldLen = 0
			} else {
				tds.FieldLen = i
			}

		} else {
			tds.FieldLen = 0
		}

		fieldWords, _ := parseName(tds.DbFieldName, "")
		tds.FieldName = toFieldName(fieldWords)
		tds.MethodName = toClassName(fieldWords)
		keyName := strings.ToLower(tds.FieldName)
		class.Names = append(class.Names, keyName)
		tds.DbTypeString = value.DataType // string(td.Type)

		m, err := getMysqlMapping(tds.DbTypeString, tds.FieldLen)
		if err == nil {
			tds.Type = m.FiledType
			tds.TypeString = m.JavaType
			tds.JDBCType = m.JDBCType
			tds.TestValue = m.TestValue
			logs.Logger.Info("tableName = %s ClassName = %s FiledName = %s Db Type= %s", tableName, class.ClassName, tds.DbFieldName, tds.DbTypeString)

		} else {
			logs.Logger.Error(err.Error())
			continue
		}

		tds.Null = value.IsNullAble                   // string(td.Null)
		tds.Key = value.ColumnKey                     // string(td.Key)
		tds.Default = value.ColumnDefault             // string(td.Default)
		tds.Extra = value.DataType                    //string(td.Type)
		tds.DBType = value.ColumnType                 // string(td.DBType)
		tds.Comment = value.ColumnComment             // string(td.Comment)
		tds.CharacterSetName = value.CharacterSetName // string(td.CharacterSetName)
		if tds.Extra == "auto_increment" {
			tds.AutoIncrement = true
		}
		class.Fields[keyName] = tds

		switch tds.Key {
		case "PRI":
			class.PrimaryKey = tds
		case "MUL":
			class.UnionKeys = append(class.UnionKeys, tds)
		case "UNI":
			class.UnionKeys = append(class.UnionKeys, tds)
		}
	}
	if class.PrimaryKey == nil {
		if len(class.UnionKeys) == 1 {

			type ShowCreate struct {
				Table       string `xorm:"Table"`
				CreateTable string `xorm:"Create Table"`
			}
			sc := new(ShowCreate)

			// Fix mysql show fields bug.
			// Get unique key by create table
			//var rowsCreateTable *sql.Rows

			has, err := dbConn.SQL("SHOW create table " + tableName).Get(sc)
			if !has {
				logs.Logger.Error("no this table info ")
				return
			}
			if err != nil {
				logs.Logger.Error(err.Error())
				return
			}
			//defer rowsCreateTable.Close()
			//if rowsCreateTable.Next() {
			//var t1, t2 string
			//t1 := sc.Table
			t2 := sc.CreateTable
			//if err = rowsCreateTable.Scan(&t1, &t2); err != nil {
			//	logs.Logger.Error("Error parse create table")
			//	return
			//}
			logs.Logger.Info("=====%+v", sc)
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

			if len(class.UnionKeys) == 1 {
				class.PrimaryKey = class.UnionKeys[0]
				class.UnionKeys = nil
				logs.Logger.Info("tableName = %s ClassName = %s PrimaryKey = %s DB key: Not Primary Key", tableName, class.ClassName, class.PrimaryKey.DbFieldName)
				//fmt.Printf("table %s (class %s) only one key %s\n", class.TableName, class.ClassName, class.PrimaryKey.DbFieldName)
			} else {

				for index, key := range class.UnionKeys {
					if index > 0 {
						fmt.Print(",")
					}
					fmt.Print(key.DbFieldName)
				}
				logs.Logger.Info("|odd key: Union Key")
			}
		} else if len(class.UnionKeys) > 1 {

			for index, key := range class.UnionKeys {
				if index > 0 {
					fmt.Print(", ")
				}
				fmt.Print(key.DbFieldName)
			}
			logs.Logger.Info("|odd key: Multi Key")
		}
		if class.PrimaryKey == nil && len(class.UnionKeys) == 0 {
			logs.Logger.Info("tableName = %s  ClassName %s||odd key: No Key %v", tableName, class.ClassName, class.Fields)
		}
	}
	if class.PrimaryKey != nil {
		if class.PrimaryKey.Type != FIELD_TYPE_INTEGER {
			logs.Logger.Info("tableName = %s ClassName = %s PrimaryKey = %s DB key: Key type is %s", tableName, class.ClassName, class.PrimaryKey.FieldName, class.PrimaryKey.TypeString)
		} else if !class.PrimaryKey.AutoIncrement {
			logs.Logger.Info("tableName = %s ClassName = %s PrimaryKey = %s DB key: Key type is %s", tableName, class.ClassName, class.PrimaryKey.FieldName, class.PrimaryKey.TypeString)
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

/*
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
*/
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
		logs.Logger.Error(filepath.Join(g_modelPath, class.ClassName+".java"), ", error:", err.Error())
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
func composeTestException() {
	var err error
	var file *os.File
	if file, err = os.Create(filepath.Join(g_testExceptionPath, "UnitTestException.java")); err != nil {
		logs.Logger.Error("Create file", filepath.Join(g_dataSourcePath+"UnitTestException.java"), ", error:", err.Error())
		return
	}

	defer file.Close()
	bw := bufio.NewWriter(file)

	header := packageName + "." + db.DbClient.DBName() + ".exception"
	bw.WriteString("package " + header + ";")
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
	header := packageName + "." + db.DbClient.DBName()
	var err error
	var file *os.File
	var dynamicFile *os.File
	var dynamicAspectFile *os.File
	var dynamicAspectHolderFile *os.File
	var interceptorFile *os.File

	if useRedis {
		var redisFile *os.File
		if redisFile, err = os.Create(filepath.Join(g_dataSourcePath, "RedisUtils.java")); err != nil {
			logs.Logger.Error("Create file", filepath.Join(g_dataSourcePath+"RedisUtils.java"), ", error:", err.Error())
			return
		}

		defer redisFile.Close()
		bw := bufio.NewWriter(redisFile)
		text := strings.Replace(redis_class, "$(package)$", header, -1)
		bw.WriteString(text)
		bw.Flush()
	}

	//=====
	if file, err = os.Create(filepath.Join(g_dataSourcePath, "DataSource.java")); err != nil {
		logs.Logger.Error("Create file", filepath.Join(g_dataSourcePath+"DataSource.java"), ", error:", err.Error())
		return
	}

	defer file.Close()
	bw := bufio.NewWriter(file)
	text := strings.Replace(dataSourceJava, "$(package)$", header, -1)
	bw.WriteString(text)
	bw.Flush()
	//=====
	if dynamicFile, err = os.Create(filepath.Join(g_dataSourcePath, "DynamicDataSource.java")); err != nil {
		logs.Logger.Error("Create file", filepath.Join(g_dataSourcePath+"DynamicDataSource.java"), ", error:", err.Error())
		return
	}

	defer dynamicFile.Close()
	dybw := bufio.NewWriter(dynamicFile)
	text1 := strings.Replace(dynamicDataSource, "$(package)$", header, -1)
	dybw.WriteString(text1)
	dybw.Flush()
	//=====
	if dynamicAspectFile, err = os.Create(filepath.Join(g_dataSourcePath, "DynamicDataSourceAspect.java")); err != nil {
		logs.Logger.Error("Create file", filepath.Join(g_dataSourcePath+"DynamicDataSourceAspect.java"), ", error:", err.Error())
		return
	}

	defer dynamicAspectFile.Close()
	dyAsbw := bufio.NewWriter(dynamicAspectFile)
	text2 := strings.Replace(dynamicDataSourceAspect, "$(package)$", header, -1)
	dyAsbw.WriteString(text2)
	dyAsbw.Flush()

	if dynamicAspectHolderFile, err = os.Create(filepath.Join(g_dataSourcePath, "DynamicDataSourceHolder.java")); err != nil {
		logs.Logger.Error("Create file", filepath.Join(g_dataSourcePath+"DynamicDataSourceHolder.java"), ", error:", err.Error())
		return
	}

	defer dynamicAspectHolderFile.Close()
	holder := bufio.NewWriter(dynamicAspectHolderFile)
	text3 := strings.Replace(dynamicDataSourceHolder, "$(package)$", header, -1)
	holder.WriteString(text3)
	holder.Flush()

	if interceptorFile, err = os.Create(filepath.Join(g_dataSourcePath, "MybatisInterceptor.java")); err != nil {
		logs.Logger.Error("Create file", filepath.Join(g_dataSourcePath+"MybatisInterceptor.java"), ", error:", err.Error())
		return
	}

	defer interceptorFile.Close()

	interceptor := bufio.NewWriter(interceptorFile)
	text4 := strings.Replace(interceptorJava, "$(package)$", header, -1)
	interceptor.WriteString(text4)
	interceptor.Flush()

}
func composeDaoFiles(class *classDefine) {
	var err error
	var file *os.File
	if file, err = os.Create(filepath.Join(g_daoPath, class.ClassName+"Dao.java")); err != nil {
		logs.Logger.Error("Create file", filepath.Join(g_daoPath, class.ClassName+"Dao.java"), ", error:", err.Error())
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
		logs.Logger.Error("Create file", filepath.Join(g_myBatisPath, class.CamelCaseName+"SqlMap.xml"), ", error:", err.Error())
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
		logs.Logger.Error("Create file", filepath.Join(g_testPath, class.ClassName+"Test.java"), ", error:", err.Error())
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
	case "private":
		result = "mPrivate"
	case "public":
		result = "mPublic"
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
	logs.Logger.Info("%+v", class.Fields)
	for _, fieldName := range class.Names {

		field := class.Fields[fieldName]
		logs.Logger.Info(class.ClassName + "::" + fieldName + "::" + field.TypeString + "::" + field.FieldName)
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
		bw.WriteString(field.DBType)
		bw.WriteString("\tCharacter: " + field.CharacterSetName)
		bw.WriteString("\tComment: " + field.Comment)
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
	header := packageName + "." + db.DbClient.DBName() + ".dataSource"
	bw.WriteString(`package `)
	bw.WriteString(g_packageName)
	bw.WriteString(".persistence.dao;\n\n")
	bw.WriteString("import " + header + ".DataSource;\n")
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
	bw.WriteString(dsw)
	bw.WriteString("\tpublic java.util.List<" + class.ClassName + "> get" + class.ClassName + "s (")
	bw.WriteString(class.ClassName)
	bw.WriteString(" s")
	bw.WriteString(class.ClassName)
	bw.WriteString(");\n")
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
	bufSelectFields := new(bytes.Buffer)

	bufProperty := new(bytes.Buffer)
	bufMapping := new(bytes.Buffer)
	bufInsert := new(bytes.Buffer)
	bufInsertValue := new(bytes.Buffer)
	bufUpdate := new(bytes.Buffer)
	bufDelete := new(bytes.Buffer)
	bufSelect := new(bytes.Buffer)
	bufSelectAll := new(bytes.Buffer)

	tableSelectFileds := fmt.Sprintf("%sTableFields", class.CamelCaseName)

	bufSelectFields.WriteString("\t<!--table select 字段-->\n\t<sql id=\"")
	bufSelectFields.WriteString(tableSelectFileds)
	bufSelectFields.WriteString("\">")

	bufProperty.WriteString("\n\t<!--属性-->\n\t<parameterMap id=\"")
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
		case FIELD_TYPE_LONG:
			bufSelect.WriteString("java.lang.Long")
		default:
			logs.Logger.Error("Unsupport primary key type:", class.PrimaryKey.TypeString)
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
	bufSelectAll.WriteString("\t<!--根据条件查询-->\n")
	bufSelectAll.WriteString("\t" + `<select id="get` + class.ClassName + `s" resultMap="` + class.CamelCaseName + `ResultMap" parameterMap="` + class.CamelCaseName + `ParameterMap">` + "\n")
	bufSelectAll.WriteString("\t\t" + `select <include refid="` + class.CamelCaseName + `TableFields"/> from ` + class.TableName + " where 1=1 \n")
	bufSelectAll.WriteString("\t\t<choose>\n")
	for index, fieldKey := range class.Names {
		field := class.Fields[fieldKey]

		bufSelectAll.WriteString("\t\t\t<when test=\"" + field.FieldName + " != null\">\n")
		bufSelectAll.WriteString("\t\t\t\tAND  `" + field.DbFieldName + "`=#{" + field.FieldName + ",jdbcType=" + field.JDBCType + "}\n")
		bufSelectAll.WriteString("\t\t\t</when>\n")

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
			bufSelectFields.WriteString(",")
		}
		bufSelectFields.WriteString("\n\t\t`" + field.DbFieldName + "`")
		bufInsert.WriteString("`")
		bufInsert.WriteString(field.DbFieldName)
		bufInsert.WriteString("`")
		bufInsertValue.WriteString("?")
		//if createSelect {
		//	if index > 0 {
		//		bufSelect.WriteString(",")
		//	}
		//	bufSelect.WriteString("`")
		//	bufSelect.WriteString(field.DbFieldName)
		//	bufSelect.WriteString("`")
		//}

		if class.PrimaryKey != field {
			bufUpdate.WriteString("\t\t\t<if test=\"")
			bufUpdate.WriteString(field.FieldName)
			bufUpdate.WriteString(" != null\">\n\t\t\t\t`")
			bufUpdate.WriteString(field.DbFieldName)
			bufUpdate.WriteString("`=#{")
			bufUpdate.WriteString(field.FieldName)
			if len(field.JDBCType) > 0 {
				bufUpdate.WriteString(",jdbcType=" + field.JDBCType)
			}
			bufUpdate.WriteString("},\n\t\t\t</if>\n")
		}

		index++
	}
	bufSelectAll.WriteString("\t\t</choose>\n\t</select>\n")
	bufSelectFields.WriteString("\n\t</sql>")

	bufProperty.WriteString("\t</parameterMap>\n\n")
	bufMapping.WriteString("\t</resultMap>\n\n")

	bufInsert.WriteString(") values(")
	bufInsertValue.WriteTo(bufInsert)
	bufInsert.WriteString(")\n")

	if createSelect {
		bufSelect.WriteString("<include refid=\"")
		bufSelect.WriteString(tableSelectFileds)
		bufSelect.WriteString("\"/>")
	}

	bufUpdate.WriteString("\t\t</trim>\n")

	if class.PrimaryKey != nil {
		bufInsert.WriteString("\t</insert>\n\n")
		bufUpdate.WriteString("\t\twhere `")
		bufUpdate.WriteString(class.PrimaryKey.DbFieldName)
		bufUpdate.WriteString("`=#{")
		bufUpdate.WriteString(class.PrimaryKey.FieldName)
		if len(class.PrimaryKey.JDBCType) > 0 {
			bufUpdate.WriteString(",jdbcType=" + class.PrimaryKey.JDBCType)
		}

		bufUpdate.WriteString("}\n\t</update>\n\n")

		bufDelete.WriteString("\t<delete id=\"delete\" parameterType=\"")
		switch class.PrimaryKey.Type {
		case FIELD_TYPE_INTEGER:
			bufDelete.WriteString("java.lang.Integer")
		case FIELD_TYPE_STRING:
			bufDelete.WriteString("string")
		case FIELD_TYPE_LONG:
			bufDelete.WriteString("java.lang.Long")
		default:
			logs.Logger.Error("Unsupport primary key type:", class.PrimaryKey.TypeString)
			os.Exit(-1)
		}
		bufDelete.WriteString("\">\n\t\tdelete from ")
		bufDelete.WriteString(class.TableName)
		bufDelete.WriteString(" where `")
		bufDelete.WriteString(class.PrimaryKey.DbFieldName)
		bufDelete.WriteString("`=#{")
		bufDelete.WriteString(class.PrimaryKey.FieldName)
		if len(class.PrimaryKey.JDBCType) > 0 {
			bufDelete.WriteString(",jdbcType=" + class.PrimaryKey.JDBCType)
		}
		bufDelete.WriteString("}\n\t</delete>\n\n")

		bufSelect.WriteString(" from ")
		bufSelect.WriteString(class.TableName)
		bufSelect.WriteString(" where `")
		bufSelect.WriteString(class.PrimaryKey.DbFieldName)
		bufSelect.WriteString("`=#{")
		bufSelect.WriteString(class.PrimaryKey.FieldName)
		if len(class.PrimaryKey.JDBCType) > 0 {
			bufSelect.WriteString(",jdbcType=" + class.PrimaryKey.JDBCType)
		}
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

	//all fileds
	io.Copy(bw, bufSelectFields)
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
	io.Copy(bw, bufSelectAll)

}
func writeMappingTailer(bw *bufio.Writer) {
	bw.WriteString("</mapper>\n")
}
