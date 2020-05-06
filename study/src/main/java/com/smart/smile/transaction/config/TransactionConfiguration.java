package com.smart.smile.transaction.config;

import com.smart.smile.transaction.PersonService;
import com.smart.smile.transaction.impl.PersonServiceImpl;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;


@Configuration
@PropertySource(value = {"classpath:spring/jdbc.properties"})
@ComponentScan(basePackages = "com.smart.smile.transaction")
@EnableTransactionManagement
public class TransactionConfiguration {
	@Value("${jdbc.url}")
	private String url;
	@Value("${jdbc.driverClassName}")
	private String driverClassName;
	@Value("${jdbc.username}")
	private String username;
	@Value("${jdbc.password}")
	private String password;


	@Bean
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUrl(url);
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		return dataSource;
	}

	@Bean(name = "txManager")
	public PlatformTransactionManager dataSourceTransactionManager(DataSource dataSource) {
		DataSourceTransactionManager manager = new DataSourceTransactionManager();
		manager.setDataSource(dataSource);
		return manager;
	}

	@Bean
	@Transactional(noRollbackFor = {IllegalArgumentException.class, PersonServiceImpl.CustomeException.class})
	public PersonService personService() {
		return new PersonServiceImpl();
	}

	@Bean
	public TransactionTemplate transactionTemplate(){
		TransactionTemplate transactionTemplate = new TransactionTemplate();
		transactionTemplate.setTransactionManager(dataSourceTransactionManager(dataSource()));
		return transactionTemplate;
	}
}
