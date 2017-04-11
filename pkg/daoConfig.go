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
	<bean id="dataSource_R_$(dbName)$" class="$(driver)$" destroy-method="close">
		<property name="driverClass" value="${datasource_$(dbName)$_r.driverClassName}" />
		<property name="jdbcUrl" value="${datasource_$(dbName)$_r.url}" />
		<property name="user" value="${datasource_$(dbName)$_r.username}" />
		<property name="password" value="${datasource_$(dbName)$_r.password}" />
		<property name="initialPoolSize" value="${datasource_$(dbName)$_r.initialPoolSize}" />
		<property name="maxPoolSize" value="${datasource_$(dbName)$_r.maxPoolSize}" />
		<property name="minPoolSize" value="${datasource_$(dbName)$_r.minPoolSize}" />
		<property name="maxIdleTime" value="${datasource_$(dbName)$_r.maxIdleTime}" />
	</bean>
	<bean id="dataSource_W_$(dbName)$" class="$(driver)$" destroy-method="close">
		<property name="driverClass" value="${datasource_$(dbName)$_w.driverClassName}" />
		<property name="jdbcUrl" value="${datasource_$(dbName)$_w.url}" />
		<property name="user" value="${datasource_$(dbName)$_w.username}" />
		<property name="password" value="${datasource_$(dbName)$_w.password}" />
		<property name="initialPoolSize" value="${datasource_$(dbName)$_w.initialPoolSize}" />
		<property name="maxPoolSize" value="${datasource_$(dbName)$_w.maxPoolSize}" />
		<property name="minPoolSize" value="${datasource_$(dbName)$_w.minPoolSize}" />
		<property name="maxIdleTime" value="${datasource_$(dbName)$_w.maxIdleTime}" />
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
		<property name="mapperLocations" value="classpath:$(classPath)$"/>
	</bean>
	<!--采用自动扫描方式创建mapper bean-->
	<!--
	<bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
		<property name="basePackage" value="$(packageName)$.persistence.dao"/>
		<property name="sqlSessionFactoryBeanName" value="sqlSessionFactory"/>
	</bean>
-->
  	<bean id="statementHandlerInterceptor" class="$(packageName)$.dataSource.MybatisInterceptor"/>
    	<!--采用自动扫描方式创建mapper bean -->
    	<bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
        	<property name="basePackage" value="com.yao.yz.admin.yzadmin.persistence.dao"/>
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
