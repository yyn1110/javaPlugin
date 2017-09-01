package logs

import (
	"github.com/spf13/cobra"
	"github.com/yyn1110/logs"
	"path/filepath"
)

var Logger *logs.BeeLogger

var logPath string
var logName string

func InitLogConfig(cmd *cobra.Command) {
	cmd.Flags().StringVar(&logPath, "logPath", "./", "log file path")
	cmd.Flags().StringVar(&logName, "logName", "javaPlugin.log", "log file name")

}
func LogRun() {

	log := logs.NewLogger(10000)
	log.EnableFuncCallDepth(true)
	s := `{"filename":"` + filepath.Join(logPath, "wexin.log") + `","perm": "0666"}`
	log.SetLogger("file", s)
	log.SetLogger("console", "")
	Logger = log
}
