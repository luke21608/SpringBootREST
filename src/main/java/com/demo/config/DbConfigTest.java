package com.demo.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@MapperScan(basePackages = "com.demo.mapper.test", sqlSessionFactoryRef = "testSqlSessionFactory")
public class DbConfigTest {

	@Autowired
	@Qualifier("testDataSource")
	private DataSource testDataSource;
	
	@Bean("testDataSource")
	@ConfigurationProperties(prefix = "spring.datasource.test")
	public DataSource testDataSource(){
		return DataSourceBuilder.create().build();
	}
	
	@Bean("testSqlSessionFactory")
	public SqlSessionFactory testSqlSessionFactory() throws Exception{
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(testDataSource);
		return bean.getObject();
	}
	
	@Bean("testSqlSessionTemplate")
	public SqlSessionTemplate testSqlSessionTemplate() throws Exception{
		return new SqlSessionTemplate(testSqlSessionFactory());
	}
}
