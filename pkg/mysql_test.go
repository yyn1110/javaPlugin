package pkg

import "testing"

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
	testcases := []parseNameCase{
		parseNameCase{"test_table", []string{"test", "table"}},
		parseNameCase{"testTable", []string{"test", "table"}},
	}

	for _, testcase := range testcases {
		result := parseName(testcase.str)
		if !testcase.CheckResult(result) {
			t.Errorf("Test %s\nExp: %v\nGot: %v\n", testcase.str, testcase.exp, result)
		}
	}
}
