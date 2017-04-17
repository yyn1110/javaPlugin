package pkg

const POM_XML  =`<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<groupId>$(groupId)$</groupId>
	<version>$(version)$</version>
	<packaging>jar</packaging>
	<artifactId>$(artifactId)$</artifactId>
	<name>$(name)$</name>
	<description>$(description)$</description>
	<!-- 构建信息 -->
	<build>
		<defaultGoal>install</defaultGoal>
		<plugins>
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-eclipse-plugin</artifactId>
				<version>2.9</version>
				<configuration>
					<downloadSources>true</downloadSources>
				</configuration>
			</plugin>
			<plugin>
				<artifactId>maven-compiler-plugin</artifactId>
				<version>2.5.1</version>
				<configuration>
					<source>$(jdk)$</source>
					<target>$(jdk)$</target>
					<encoding>UTF-8</encoding>
				</configuration>
			</plugin>
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<version>2.5</version>
				<artifactId>maven-resources-plugin</artifactId>
				<configuration>
					<encoding>UTF-8</encoding>
				</configuration>
			</plugin>
		</plugins>
		<resources>
			<resource>
				<directory>src/main/resources</directory>
				<filtering>true</filtering>
			</resource>
		</resources>
		<testResources>
			<testResource>
				<directory>src/test/resources</directory>
				<filtering>true</filtering>
			</testResource>
		</testResources>
	</build>
	<!-- 版本控制 -->
	<properties>
		<spring_version>4.0.2.RELEASE</spring_version>
		<mysql-connector-java_version>5.1.38</mysql-connector-java_version>
		<junit_version>4.12</junit_version>
		<aspectjweaver_version>1.6.12</aspectjweaver_version>
		<c3p0_version>0.9.1.2</c3p0_version>
		<druid_version>1.0.29</druid_version>
		<mybatis_version>3.3.0</mybatis_version>
		<mybatis_spring_version>1.2.2</mybatis_spring_version>
	</properties>

	<!-- jar依赖 -->
	<dependencies>
		<!-- spring读写分离依赖jar包 -->
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-jdbc</artifactId>
			<version>${spring_version}</version>
		</dependency>

		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-context</artifactId>
			<version>${spring_version}</version>
		</dependency>
		<!-- mybatis整合spring依赖jar包 -->
		<dependency>
			<groupId>org.mybatis</groupId>
			<artifactId>mybatis-spring</artifactId>
			<version>${mybatis_spring_version}</version>
		</dependency>
		<dependency>
			<groupId>org.mybatis</groupId>
			<artifactId>mybatis</artifactId>
			<version>${mybatis_version}</version>
		</dependency>

		<!-- spring单元测试依赖jar包 -->
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-test</artifactId>
			<version>${spring_version}</version>
		</dependency>


		<!-- mysql数据库驱动包 -->
		<dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
			<version>${mysql-connector-java_version}</version>
		</dependency>

		<dependency>
			<groupId>c3p0</groupId>
			<artifactId>c3p0</artifactId>
			<version>${c3p0_version}</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/com.alibaba/druid -->
		<dependency>
		    <groupId>com.alibaba</groupId>
		    <artifactId>druid</artifactId>
		    <version>${druid_version}</version>
		</dependency>

		<!-- 单元测试依赖jar包 -->
		<dependency>
			<groupId>junit</groupId>
			<artifactId>junit</artifactId>
			<version>${junit_version}</version>
		</dependency>

		<!-- 自定义注解依赖jar包 -->
		<dependency>
			<groupId>org.aspectj</groupId>
			<artifactId>aspectjweaver</artifactId>
			<version>${aspectjweaver_version}</version>
		</dependency>

		<dependency>
            		<groupId>org.slf4j</groupId>
            		<artifactId>slf4j-log4j12</artifactId>
            		<version>1.7.20</version>
        	</dependency>
	</dependencies>
	<distributionManagement>
		<repository>
			<id>xxx-releases</id>
			<url>http://maven.xxxx.com/nexus/content/repositories/releases</url>
		</repository>
		<snapshotRepository>
			<id>xxx-snapshots</id>
			<url>http://maven.xxx.com/nexus/content/repositories/snapshots</url>
		</snapshotRepository>
	</distributionManagement>
</project>`
