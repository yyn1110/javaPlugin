package project

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
    <appender name="DEFAULT-FILE" class="org.apache.log4j.DailyRollingFileAppender">
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
        <appender-ref ref="DEFAULT-FILE"/>
    </logger>

    <root>
        <level value="INFO"/>
        <appender-ref ref="myConsole"/>
    </root>
</log4j:configuration>
`
const logger_class = `
package $(packageName)$.logger;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class YzLogger {


    public static StackTraceElement findCaller() {

        StackTraceElement[] callStack = Thread.currentThread().getStackTrace();
        if (callStack == null) {
            return null;
        }

        StackTraceElement caller = null;

        String logClassName = YzLogger.class.getName();

        boolean isEachLogClass = false;

        for (StackTraceElement stackTraceElement : callStack) {

            if (logClassName.equals(stackTraceElement.getClassName())) {
                isEachLogClass = true;
            }

            if (isEachLogClass) {
                if (!logClassName.equals(stackTraceElement.getClassName())) {
                    isEachLogClass = false;
                    caller = stackTraceElement;
                    break;
                }
            }
        }
        return caller;
    }


    private static Logger logger() {

        StackTraceElement caller = findCaller();
        if (null == caller) return LoggerFactory.getLogger(YzLogger.class);

        Logger log = LoggerFactory.getLogger(caller.getClassName() + "." + caller.getMethodName() + "() Line: " + caller.getLineNumber());

        return log;
    }

    public static void debug(String msg) {
        debug(msg, null);
    }

    public static void debug(String msg, Throwable e) {
        logger().debug(msg, e);
    }

    public static void info(String msg) {
        logger().info(msg);
    }

    public static void info(String msg, Throwable e) {
        logger().info(msg, e);
    }

    public  static void info(String format,Object... arguments){
        logger().info(format,arguments);
    }

    public static void warn(String msg) {
        logger().warn(msg);
    }

    public static void warn(String msg, Throwable e) {
        logger().warn(msg, e);
    }
    public static void warn(String msg, Object ... args) {
        logger().warn(msg, args);
    }

    public static void error(String msg) {
        logger().error(msg);
    }

    public static void error(String msg, Throwable e) {
        logger().error(msg, e);
    }
    public  static  void error(String msg, Object ...args){
        logger().error(msg,args);
    }
}
`