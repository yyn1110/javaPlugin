//数据库模型
package db

type TableSchema struct {
	ColumnName       string `xorm:"COLUMN_NAME"`
	DataType         string `xorm:"DATA_TYPE"`
	IsNullAble       string   `xorm:"IS_NULLABLE"`
	ColumnKey        string `xorm:"COLUMN_KEY"`
	ColumnDefault    string `xorm:"COLUMN_DEFAULT"`
	Extra            string `xorm:"EXTRA"`
	ColumnComment    string `xorm:"COLUMN_COMMENT"`
	CharacterSetName string `xorm:"CHARACTER_SET_NAME"`
	TableSchema      string `xorm:"TABLE_SCHEMA"`
	TableName        string `xorm:"TABLE_NAME"`
	ColumnType       string `xorm:"COLUMN_TYPE"`
}
