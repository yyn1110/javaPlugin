package db

const log4jXML  = `<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE log4j:configuration PUBLIC "-//LOGGER" "log4j.dtd">
<log4j:configuration xmlns:log4j="http://jakarta.apache.org/log4j/">
    <!-- ========================== 输出方式说明================================ -->
    <!-- org.apache.log4j.DailyRollingFileAppender(每天产生一个日志文件), -->
    <!-- 控制台 -->
    <appender name="myConsole" class="org.apache.log4j.ConsoleAppender">
        <param name="encoding" value="utf-8"/>
        <layout class="org.apache.log4j.PatternLayout">
            <param name="ConversionPattern" value="[%d{yyyy-MM-dd HH:mm:ss}] [%c] [%L] %p [%m]%n"/>
        </layout>
    </appender>
    <!-- 默认日志目录-->
    <appender name="YZ-DEFAULT-FILE" class="org.apache.log4j.DailyRollingFileAppender">
        <param name="File" value="./app/api.log"/>
        <param name="append" value="true"/>
        <param name="DatePattern" value="'info_'yyyy-MM-dd'.log'"/>
        <param name="encoding" value="UTF-8"/>
        <layout class="org.apache.log4j.PatternLayout">
            <param name="ConversionPattern" value="[%d{yyyy-MM-dd HH:mm:ss:SSS}] [%c] [%L] %p [%m]%n"/>
        </layout>
    </appender>

    	<!--logger目录-->

    	<logger name="org.springframework.security">
		<level value="ERROR" />
	</logger>

	<logger name="org.apache">
		<level value="ERROR" />
	</logger>

	<logger name="com.opensymphony">
		<level value="ERROR" />
	</logger>

	<logger name="org.apache.velocity">
		<level value="ERROR" />
	</logger>

	<logger name="org.springframework">
		<level value="ERROR" />
	</logger>
  	 <logger name="net.sf">
		<level value="ERROR" />
  	 </logger>

   	<logger name="org.castor">
		<level value="ERROR" />
	</logger>

	<logger name="org.exolab">
		<level value="ERROR" />
	</logger>

	<logger name="com.ibatis" additivity="true">
		<level value="ERROR" />
	</logger>
	<logger name="java.sql.Connection" additivity="true">
		<level value="ERROR" />
	</logger>
	<logger name="java.sql.Statement" additivity="true">
		<level value="ERROR" />
	</logger>
	<logger name="java.sql.PreparedStatement" additivity="true">
		<level value="ERROR" />
	</logger>
	<logger name="java.sql.ResultSet" additivity="true">
		<level value="ERROR" />
	</logger>

    <!-- 业务信息默认为INFO级别 -->
    <logger name="$(packageName)$" additivity="true">
        <level value="INFO"/>
        <appender-ref ref="YZ-DEFAULT-FILE"/>
    </logger>

    <root>
        <level value="info"/>
        <appender-ref ref="myConsole"/>
    </root>
</log4j:configuration>
`