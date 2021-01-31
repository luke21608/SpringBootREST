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
@MapperScan(basePackages = "com.demo.mapper.demo", sqlSessionFactoryRef = "demoSqlSessionFactory")
public class DbConfigDemo {

	@Autowired
	@Qualifier("demoDataSource")
	private DataSource demoDataSource;
	
	@Bean("demoDataSource")
	@ConfigurationProperties(prefix = "spring.datasource.demo")
	public DataSource demoDataSource(){
		return DataSourceBuilder.create().build();
	}
	
	@Bean("demoSqlSessionFactory")
	public SqlSessionFactory demoSqlSessionFactory() throws Exception{
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(demoDataSource);
		return bean.getObject();
	}
	
	@Bean("demoSqlSessionTemplate")
	public SqlSessionTemplate demoSqlSessionTemplate() throws Exception{
		return new SqlSessionTemplate(demoSqlSessionFactory());
	}
}
