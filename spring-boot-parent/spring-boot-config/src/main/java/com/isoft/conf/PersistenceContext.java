package com.isoft.conf;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
public class PersistenceContext {

	@Autowired
	private Environment env;

	@Autowired
	private DataSource dataSource;

	@Bean
	public DataSource myDataSource() {
		//spring-boot-starter-jdbc
		DriverManagerDataSource ds = new DriverManagerDataSource();
		// 配置信息
		ds.setDriverClassName(env.getProperty("database.driverClassName"));
		ds.setUrl(env.getProperty("database.url"));
		ds.setUsername(env.getProperty("database.username"));
		ds.setPassword(env.getProperty("database.password"));

		return ds;
	}

	// JPA:LocalContainerEntityManagerFactoryBean与LocalEntityManagerFactoryBean的区别
	// 容器管理型
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		
		//spring-boot-starter-data-jpa
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		
		factory.setDataSource(dataSource);
		factory.setPackagesToScan("com");
		
		//JpaVendorAdapter 
		HibernateJpaVendorAdapter vendorAdaptor=new HibernateJpaVendorAdapter();
		factory.setJpaVendorAdapter(vendorAdaptor);
		
		Properties jpaProperties=new Properties();
		jpaProperties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
		jpaProperties.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
		jpaProperties.put("hibernate.format_sql", env.getProperty("hibernate.format_sql"));
		
		factory.setJpaProperties(jpaProperties);
		
		return factory;
	}

	
	/**
	 * 设置JPA    Transaction manager
	 * @return
	 */
	@Bean
	public JpaTransactionManager transactionManager(){
		JpaTransactionManager txManager=new JpaTransactionManager();
		txManager.setEntityManagerFactory(entityManagerFactory().getObject());
		return txManager;
		
	}

}
