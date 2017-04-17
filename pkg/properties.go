package pkg

const ProPerties_Mysql  =
	`#r-datasource
datasource_$(dbName)$_r.driverClassName=com.mysql.jdbc.Driver
datasource_$(dbName)$_r.url=jdbc:mysql://$(dbAddr)$/$(dbName)$?useUnicode=true&amp;characterEncoding=UTF8MB4&amp;zeroDateTimeBehavior=convertToNull&amp;autoReconnectForPools=true&amp;userSSL=false
datasource_$(dbName)$_r.username=$(dbUser)$
datasource_$(dbName)$_r.password=$(dbPassword)$
datasource_$(dbName)$_r.initialPoolSize=5
datasource_$(dbName)$_r.maxPoolSize=50
datasource_$(dbName)$_r.minPoolSize=5
##最大空闲时间,300000秒内未使用则连接被丢弃。若为0则永不丢弃
datasource_$(dbName)$_r.maxIdleTime=300000
datasource_$(dbName)$_r.maxWait=60000
datasource_$(dbName)$_r.timeBetweenEvictionRunsMillis=60000
datasource_$(dbName)$_r.maxPoolPreparedStatementPerConnectionSize=20
#w-datasource
datasource_$(dbName)$_w.driverClassName=com.mysql.jdbc.Driver
datasource_$(dbName)$_w.url=jdbc:mysql://$(dbAddr)$/$(dbName)$?useUnicode=true&amp;characterEncoding=UTF-8&amp;zeroDateTimeBehavior=convertToNull&amp;autoReconnectForPools=true&amp;userSSL=false
datasource_$(dbName)$_w.username=$(dbUser)$
datasource_$(dbName)$_w.password=$(dbPassword)$
datasource_$(dbName)$_w.initialPoolSize=5
datasource_$(dbName)$_w.maxPoolSize=50
datasource_$(dbName)$_w.minPoolSize=5
##最大空闲时间,300000秒内未使用则连接被丢弃。若为0则永不丢弃
datasource_$(dbName)$_w.maxIdleTime=300000
datasource_$(dbName)$_w.maxWait=60000
datasource_$(dbName)$_w.timeBetweenEvictionRunsMillis=60000
datasource_$(dbName)$_w.maxPoolPreparedStatementPerConnectionSize=20


`