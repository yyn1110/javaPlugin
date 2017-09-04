package project

import (
	"errors"
	"fmt"
	"strings"
)

const (
	FIELD_TYPE_STRING = iota
	FIELD_TYPE_INTEGER
	FIELD_TYPE_BIT
	FIELD_TYPE_FLOAT
	FIELD_TYPE_TIMESTAMP
	FIELD_TYPE_DOUBLE
	FIELD_TYPE_LONG
	FIELD_TYPE_ENUM
	FIELD_TYPE_SET
	FIELD_TYPE_POINT
	FIELD_TYPE_BID_DECIMAL
)

type MysqlTypeMapping struct {
	JavaType  string
	FiledType int
	JDBCType  string
	TestValue string
}

func newMapping(javaType string, filedType int, jdbcType string, testValue string) *MysqlTypeMapping {
	m := new(MysqlTypeMapping)
	m.JavaType = javaType
	m.FiledType = filedType
	m.JDBCType = jdbcType
	m.TestValue = testValue
	return m
}

func getMysqlMapping(mysqlFiled string, valueLen int) (*MysqlTypeMapping, error) {

	switch strings.ToLower(mysqlFiled) {
	case "tinyint", "smallint", "mediumint", "int":
		m := newMapping("java.lang.Integer", FIELD_TYPE_INTEGER, "INTEGER", fmt.Sprintf("new java.lang.Integer(%d)", 1))
		return m, nil
	case "bigint":
		m := newMapping("java.lang.Long", FIELD_TYPE_LONG, "BIGINT", fmt.Sprintf("new java.lang.Long(%d)", 1))
		return m, nil
	case "bit":
		if valueLen == 1 {
			m := newMapping("java.lang.Boolean", FIELD_TYPE_BIT, "BIT", "new java.lang.Boolean(true)")
			return m, nil
		} else {
			m := newMapping("byte []", FIELD_TYPE_BIT, "BIT", "new byte []{'1'}")
			return m, nil
		}
	case "blob":
		m := newMapping("byte []", FIELD_TYPE_BIT, "BLOB", "new byte []{'1'}")
		return m, nil
	case "tinyblob":
		m := newMapping("byte []", FIELD_TYPE_BIT, "BLOB", "new byte []{'1'}")
		return m, nil
	case "mediumblob":
		m := newMapping("byte []", FIELD_TYPE_BIT, "BLOB", "new byte []{'1'}")
		return m, nil
	case "longblob":
		m := newMapping("byte []", FIELD_TYPE_BIT, "BLOB", "new byte []{'1'}")
		return m, nil
	case "double":
		m := newMapping("java.lang.Double", FIELD_TYPE_DOUBLE, "DOUBLE", fmt.Sprintf("new java.lang.Double(%d.0)", 1))
		return m, nil
	case "float":
		m := newMapping("java.lang.Float", FIELD_TYPE_FLOAT, "FLOAT", fmt.Sprintf("new java.lang.Float(%d.0f)", 1))
		return m, nil
	case "decimal":
		m := newMapping("java.math.BigDecimal", FIELD_TYPE_BID_DECIMAL, "DECIMAL", fmt.Sprintf("new java.math.BigDecimal(%d.0)", 1))
		return m, nil
	case "char":
		m := newMapping("String", FIELD_TYPE_STRING, "CHAR", getText(valueLen))
		return m, nil
	case "varchar":
		m := newMapping("String", FIELD_TYPE_STRING, "VARCHAR", getText(valueLen))
		return m, nil
	case "tinytext":
		m := newMapping("String", FIELD_TYPE_STRING, "VARCHAR", getText(valueLen))
		return m, nil
	case "text":
		m := newMapping("String", FIELD_TYPE_STRING, "VARCHAR", getText(valueLen))
		return m, nil
	case "mediumtext":
		m := newMapping("String", FIELD_TYPE_STRING, "VARCHAR", getText(valueLen))
		return m, nil
	case "longtext":
		m := newMapping("String", FIELD_TYPE_STRING, "VARCHAR", getText(valueLen))
		return m, nil
	case "date":
		m := newMapping("java.util.Date", FIELD_TYPE_TIMESTAMP, "DATE", "new java.util.Date()")
		return m, nil
	case "year":
		m := newMapping("java.util.Date", FIELD_TYPE_TIMESTAMP, "", "null")
		return m, nil
	case "timestamp":
		m := newMapping("java.sql.Timestamp", FIELD_TYPE_TIMESTAMP, "TIMESTAMP", "new java.sql.Timestamp(1504493543)")
		return m, nil
	case "datetime":
		m := newMapping("java.sql.Timestamp", FIELD_TYPE_TIMESTAMP, "TIMESTAMP", "new java.sql.Timestamp(1504493543)")
		return m, nil
	case "time":
		m := newMapping("java.sql.Time", FIELD_TYPE_TIMESTAMP, "TIME", "new java.sql.Time(1504493543)")
		return m, nil
	case "enum":
		m := newMapping("String", FIELD_TYPE_ENUM, "CHAR", getText(valueLen))
		return m, nil
	case "binary":
		m := newMapping("byte []", FIELD_TYPE_BIT, "BINARY", "new byte []{'1'}")
		return m, nil
	case "varbinary":
		m := newMapping("byte []", FIELD_TYPE_BIT, "VARBINARY", "new byte []{'1'}")
		return m, nil
	case "point":
		m := newMapping("String", FIELD_TYPE_POINT, "", getText(valueLen))
		return m, nil
	case "set":
		m := newMapping("String", FIELD_TYPE_SET, "", getText(valueLen))
		return m, nil
	}

	return nil, errors.New(fmt.Sprintf("unsupport mysql type mysqlFiled = %s ", mysqlFiled))

}
func getText(textLen int) string {
	t := ""
	if textLen > 255 {
		textLen = 255
	}
	for a := 0; a < textLen; a++ {
		t = t + "A"
	}
	return fmt.Sprintf("\"%s\"", t)
}
