//数据库配置
package db

import (
	"fmt"
	_ "github.com/go-sql-driver/mysql"
	"github.com/go-xorm/xorm"
	"github.com/spf13/cobra"
)

//数据库连接host
var dbHost string

//数据库库名称
var dbName string

//连接数据库的userName
var dbUserName string

//连接数据库的密码
var dbPassWord string
var driverName string

//是否打印sql日志
var verbose bool
var DbClient *MySqlClient

func InitDBConfig(cmd *cobra.Command) {

	cmd.Flags().StringVar(&driverName, "driverName", "mysql", "driver Name")
	cmd.Flags().StringVar(&dbHost, "dbAddr", "10.6.82.199:3306", "database host")
	cmd.Flags().StringVar(&dbName, "dbName", "yzadmin", "database name")
	cmd.Flags().StringVar(&dbUserName, "dbUser", "fxm", "database connection name")
	cmd.Flags().StringVar(&dbPassWord, "dbPassword", "fxm@YiZhen", "database connection password")
	cmd.Flags().BoolVarP(&verbose, "verbose", "v", true, "print sql log")

}
func InitVar(dbhost, dbname, username, password string) {
	dbHost = dbhost
	dbName = dbname
	dbUserName = username
	dbPassWord = password

}

func Init() error {

	config := new(MysqlConfigEntity)
	config.MysqlHost = dbHost
	config.MysqlDB = dbName
	config.MysqlPassWord = dbPassWord
	config.MysqlUser = dbUserName
	config.SqlLog = verbose
	client, err := NewMySql(config)
	if err != nil {
		return err
	}
	err = client.Engine().Ping()
	if err != nil {
		return err
	} else {
		fmt.Println("db ok")

	}
	DbClient = client

	return nil
}

type MySqlClient struct {
	engine *xorm.Engine
}
type MysqlConfigEntity struct {
	MysqlHost     string
	MysqlDB       string
	MysqlUser     string
	MysqlPassWord string
	SqlLog        bool
}

func (this *MysqlConfigEntity) toDataSource() string {
	sqlDataSource := this.MysqlUser + ":" + this.MysqlPassWord + "@tcp(" + this.MysqlHost + ")/" + this.MysqlDB + "?charset=utf8"
	return sqlDataSource
}

//new sql conn
func NewMySql(conf *MysqlConfigEntity) (*MySqlClient, error) {
	dataSourceName := conf.toDataSource()
	db, err := xorm.NewEngine(driverName, dataSourceName)

	if err != nil {
		return nil, err
	}
	db.ShowSQL(conf.SqlLog)
	db.SetMaxOpenConns(5)
	db.SetMaxIdleConns(5)

	return &MySqlClient{engine: db}, nil

}
func (client *MySqlClient) Engine() *xorm.Engine {

	return client.engine
}
func (client *MySqlClient) DBName() string {
	return dbName
}
func (client *MySqlClient) DBAddr() string {
	return dbHost
}
func (client *MySqlClient) DBUser() string {
	return dbUserName
}
func (client *MySqlClient) DBPassword() string {
	return dbPassWord
}
