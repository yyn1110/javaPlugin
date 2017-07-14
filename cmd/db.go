// Copyright © 2017 NAME HERE <EMAIL ADDRESS>
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package cmd

import (


	"github.com/spf13/cobra"
	"javaPlugin/pkg/db"
)

// DBCmd represents the DB command
var DBCmd = &cobra.Command{
	Use:   "db",
	Short: "create model and mapping from db ",
	Long: `从数据库中生成model和mapping`,
	Run: func(cmd *cobra.Command, args []string) {
		db.Run()
	},
}

func init() {
	RootCmd.AddCommand(DBCmd)
	db.InitConfig(DBCmd)
	// Here you will define your flags and configuration settings.

	// Cobra supports Persistent Flags which will work for this command
	// and all subcommands, e.g.:
	// DBCmd.PersistentFlags().String("foo", "", "A help for foo")

	// Cobra supports local flags which will only run when this command
	// is called directly, e.g.:
	// DBCmd.Flags().BoolP("toggle", "t", false, "Help message for toggle")

}
