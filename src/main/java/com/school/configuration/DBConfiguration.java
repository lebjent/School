package com.school.configuration;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration//해당 어노테이션을 설정해주므로 서버실행시 자동으로 Configuration을 읽게 한다
@PropertySource("classpath:/application.properties")//mysql서버경로를 가져오기 위하여 프로퍼티스를 읽는다.
public class DBConfiguration {
	
	//BeanFactory인터페이스를 상속받은 인터페이스이며 Bean의 정보를 가져올 수 있다.
    @Autowired
    private ApplicationContext applicationContext;
	
	@Bean
	@ConfigurationProperties(prefix = "spring.datasource.hikari")//HikariCP를 이용하기 위한 어노테이션
	public HikariConfig hikariConfig() {
		return new HikariConfig();
	}
	
	@Bean
	public DataSource dataSource() throws Exception{
		//HikariConfig와 DataSource를 연결
		DataSource dataSource = new HikariDataSource(hikariConfig());
		System.out.println(dataSource.toString());
		return dataSource;
	}
	
	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception{
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		//DataSource와 SessionFactory의 연동
		sqlSessionFactoryBean.setDataSource(dataSource);
		//Mapper연동의 경로를 설정
		sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:/mapper/**/*-Mapper.xml"));
		//Mybatis 연동
		sqlSessionFactoryBean.setConfiguration(mybatisConfig());
		//TypeAlias 연동
		sqlSessionFactoryBean.setTypeAliasesPackage("com.school.dto");
		
		return sqlSessionFactoryBean.getObject();
	}
	
	@Bean
	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}
	
	@Bean
	@ConfigurationProperties(prefix = "mybatis.configuration")
	public org.apache.ibatis.session.Configuration mybatisConfig(){
		return new org.apache.ibatis.session.Configuration();
	}
	
}
