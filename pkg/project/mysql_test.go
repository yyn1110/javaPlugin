package project

import (
	"javaPlugin/pkg/db"
	"testing"
	"encoding/json"
)

type parseNameCase struct {
	str string
	exp []string
}

func (testcase parseNameCase) CheckResult(result []string) bool {
	if len(result) != len(testcase.exp) {
		return false
	}
	for index, str := range result {
		if str != testcase.exp[index] {
			return false
		}
	}
	return true
}

func Test_parseName(t *testing.T) {
	db.InitVar("10.6.82.199:3306", "yzadmin", "fxm", "fxm@YiZhen", "mysql")
	err := db.Init()
	if err != nil {
		t.Error(err.Error())
		return
	}
	tt, err := db.DbClient.Engine().DBMetas()
	if err != nil {
		t.Error(err.Error())
		return
	}
	for _,value:=range tt{
		b,err:=json.Marshal(value.Columns())
		if err!=nil{
			t.Error(err.Error())
		}else{
			t.Log(string(b))
		}
	}


}
