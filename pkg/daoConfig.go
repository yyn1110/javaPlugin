package pkg


const daoConfigXML=`<?xml version="1.0" encoding="utf-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
	   xmlns:aop="http://www.springframework.org/schema/aop"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
		    http://www.springframework.org/schema/beans/spring-beans-3.0.xsd
			http://www.springframework.org/schema/context
			http://www.springframework.org/schema/context/spring-context.xsd
			http://www.springframework.org/schema/aop
			http://www.springframework.org/schema/aop/spring-aop-2.5.xsd"
       default-init-method="init"
       default-lazy-init="false"
       default-destroy-method="destroy">

	<!--开启注解扫描-->
	<context:component-scan base-package="$(packageName)$"/>
	<!--属性加载-->
	<bean id="jdbcConfig" class="org.springframework.beans.factory.config.PropertyPlaceholderConfigurer">
		<property name="locations">
			<list>
				<value>classpath:$(properties)$</value>
			</list>
		</property>
	</bean>
	<bean id="dataSource_R_$(dbName)$" class="$(driver)$"  $(init)$ destroy-method="close">

$(driverExtR)$

	</bean>
	<bean id="dataSource_W_$(dbName)$" class="$(driver)$" $(init)$ destroy-method="close">

$(driverExtW)$

	</bean>

	<!--自定义数据源，将所有的数据源都纳入自定数据源管理-->
	<bean id="dataSource" class="$(packageName)$.dataSource.DynamicDataSource">
		<property name="targetDataSources">
			<map key-type="java.lang.String">
				<!--写数据源-->
				<entry key="dataSource_R_$(dbName)$" value-ref="dataSource_R_$(dbName)$"/>
				<!--读数据源-->
				<entry key="dataSource_W_$(dbName)$" value-ref="dataSource_W_$(dbName)$"/>
			</map>
		</property>
	</bean>
	<!--配置myBatis数据库连接工厂-->
	<bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
		<property name="dataSource" ref="dataSource"/>
		<property name="mapperLocations">
		 <list>
                <value>
                    classpath*:$(classPath)$
                </value>
                <value>
                    classpath*:$(classPathExt)$
                </value>
            </list>
            </property >
	</bean>
	<!--采用自动扫描方式创建mapper bean-->

  	<bean id="statementHandlerInterceptor" class="$(packageName)$.dataSource.MybatisInterceptor"/>
    	<!--采用自动扫描方式创建mapper bean -->
    	<bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
        	<property name="basePackage" value="$(packageName)$.persistence.dao"/>
        	<property name="sqlSessionFactoryBeanName" value="sqlSessionFactory"/>
    	</bean>

	<!--采用AOP注解的方式决定使用哪个数据源-->
	<bean id="dataSourceAspect" class="$(packageName)$.dataSource.DynamicDataSourceAspect"/>
	<aop:config>
		<aop:aspect id="DynamicDataSourceAspect" ref="dataSourceAspect">
			<aop:pointcut id="dataSourcePoint" expression="execution(* $(packageName)$.persistence.dao.*.*(..))"/>
			<aop:before method="before" pointcut-ref="dataSourcePoint"/>
		</aop:aspect>
	</aop:config>

</beans>`

const c3p0_r=`<!-- 基本属性 url、user、password -->
		<property name="driverClass" value="${datasource_$(dbName)$_r.driverClassName}" />
		<property name="jdbcUrl" value="${datasource_$(dbName)$_r.url}" />
		<property name="user" value="${datasource_$(dbName)$_r.username}" />
		<property name="password" value="${datasource_$(dbName)$_r.password}" />
		<!-- 配置初始化大小、最小、最大 -->
		<property name="initialPoolSize" value="${datasource_$(dbName)$_r.initialPoolSize}" />
		<property name="maxPoolSize" value="${datasource_$(dbName)$_r.maxPoolSize}" />
		<property name="minPoolSize" value="${datasource_$(dbName)$_r.minPoolSize}" />

		 <!-- 配置获取连接等待超时的时间 -->
		<property name="maxIdleTime" value="${datasource_$(dbName)$_r.maxIdleTime}" />
		`
const c3p0_w=`<!-- 基本属性 url、user、password -->
		<property name="driverClass" value="${datasource_$(dbName)$_w.driverClassName}" />
		<property name="jdbcUrl" value="${datasource_$(dbName)$_w.url}" />
		<property name="user" value="${datasource_$(dbName)$_w.username}" />
		<property name="password" value="${datasource_$(dbName)$_w.password}" />
		<!-- 配置初始化大小、最小、最大 -->
		<property name="initialPoolSize" value="${datasource_$(dbName)$_w.initialPoolSize}" />
		<property name="maxPoolSize" value="${datasource_$(dbName)$_w.maxPoolSize}" />
		<property name="minPoolSize" value="${datasource_$(dbName)$_w.minPoolSize}" />
		<!-- 配置获取连接等待超时的时间 -->
		<property name="maxIdleTime" value="${datasource_$(dbName)$_w.maxIdleTime}" />
		`
const druid_r=`<!-- 基本属性 url、user、password -->
		<property name="driverClassName" value="${datasource_$(dbName)$_r.driverClassName}" />
		<property name="url" value="${datasource_$(dbName)$_r.url}" />
		<property name="username" value="${datasource_$(dbName)$_r.username}" />
		<property name="password" value="${datasource_$(dbName)$_r.password}" />

		 <!-- 配置初始化大小、最小、最大 -->
        	<property name="initialSize" value="${datasource_$(dbName)$_r.initialPoolSize}"/>
        	<property name="minIdle" value="${datasource_$(dbName)$_r.minPoolSize}"/>
        	<property name="maxActive" value="${datasource_$(dbName)$_r.maxPoolSize}"/>

        	<!-- 配置获取连接等待超时的时间 -->
        	<property name="maxWait" value="${datasource_$(dbName)$_r.maxWait}"/>

		<!-- 配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒 -->
		<!--
        	<property name="timeBetweenEvictionRunsMillis" value="${datasource_$(dbName)$_r.timeBetweenEvictionRunsMillis}"/>
        	-->
        	 <!-- 配置一个连接在池中最小生存的时间，单位是毫秒 -->
        	<property name="minEvictableIdleTimeMillis" value="${datasource_$(dbName)$_r.maxIdleTime}"/>

        	<property name="validationQuery" value="SELECT 'x'"/>
        	<property name="testWhileIdle" value="true"/>
        	<property name="testOnBorrow" value="true"/>
        	<property name="testOnReturn" value="false"/>

        	<!-- 打开PSCache，并且指定每个连接上PSCache的大小 -->
        	<property name="poolPreparedStatements" value="true"/>
        	<property name="maxPoolPreparedStatementPerConnectionSize"
                  value="${datasource_$(dbName)$_r.maxPoolPreparedStatementPerConnectionSize}"/>

        	<!-- 配置监控统计拦截的filters -->
        	<property name="filters" value="stat"/>`
const druid_w=`<!-- 基本属性 url、user、password -->
		<property name="driverClassName" value="${datasource_$(dbName)$_w.driverClassName}" />
		<property name="url" value="${datasource_$(dbName)$_w.url}" />
		<property name="username" value="${datasource_$(dbName)$_w.username}" />
		<property name="password" value="${datasource_$(dbName)$_w.password}" />

		<!-- 配置初始化大小、最小、最大 -->
		<property name="initialSize" value="${datasource_$(dbName)$_w.initialPoolSize}"/>
		<property name="minIdle" value="${datasource_$(dbName)$_w.minPoolSize}"/>
		<property name="maxActive" value="${datasource_$(dbName)$_w.maxPoolSize}"/>


		<!-- 配置获取连接等待超时的时间 -->
		<property name="maxWait" value="${datasource_$(dbName)$_w.maxWait}"/>
		<!-- 配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒 -->
		<property name="timeBetweenEvictionRunsMillis" value="${datasource_$(dbName)$_w.timeBetweenEvictionRunsMillis}"/>


		<property name="validationQuery" value="SELECT 'x'"/>
		<property name="testWhileIdle" value="true"/>
		<property name="testOnBorrow" value="true"/>
		<property name="testOnReturn" value="false"/>

		<!-- 打开PSCache，并且指定每个连接上PSCache的大小 -->
		<property name="poolPreparedStatements" value="true"/>
		<property name="maxPoolPreparedStatementPerConnectionSize"
			  value="${datasource_$(dbName)$_w.maxPoolPreparedStatementPerConnectionSize}"/>

		<!-- 配置监控统计拦截的filters -->
		<property name="filters" value="stat"/>`
