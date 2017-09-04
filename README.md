# create mapper from mysql database use  golang
## 使用golang开发的生成java mapper文件 dto文件以及配置文件的程序
#### 基于spring 以及mybatis

## 捐助
 <img src="https://github.com/yyn1110/javaPlugin/blob/master/weixin.jpg" width = "200" height = "200" alt="微信支付" align=center />
 <img src="https://github.com/yyn1110/javaPlugin/blob/master/alipay.jpg" width = "200" height = "200" alt="支付宝" align=center />

## 如何使用
```
一键生成项目和mapping

Usage:
  javaPlugin [flags]

Flags:
      --dbAddr string          The MySQL connect link. (default "10.6.80.97:3306")
      --dbDriver string        c3p0 or druid (default "c3p0")
      --dbName string          The DB name. (default "yzadmin")
      --dbNameTest string      The empty DB name for unit test.
      --dbPassword string      The MySQL password. (default "dev123")
      --dbUser string          The MySQL user name. (default "root")
      --exclude string         The exclude tables name. (default "open_app_log,health_report_stats_month,drug_question_stats_month,video_stats_month")
      --jdk string             jdk version (default "1.7")
      --logName string         log file name (default "javaPlugin.log")
      --logPath string         log file path (default "./")
      --maxCore int            The max core number. (0: Number of CPU - 1) (default 1)
      --outputPath string      The output file path. (default "./")
      --packageName string     The package name of Java classes. (default "com.java.demo")
      --redisHost string       redis host (default "127.0.0.1")
      --redisPassWord string   redis password
      --redisPort string       redis port (default "6379")
  -r, --useRedis               create redis config
      --version string         pom version (default "0.1")
```

## 授权(LICENSE)
[plugin is licensed under the Apache Licence, Version 2.0](http://www.apache.org/licenses/LICENSE-2.0.html)