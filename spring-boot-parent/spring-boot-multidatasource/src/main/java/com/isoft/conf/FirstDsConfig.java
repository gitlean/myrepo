package com.isoft.conf;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * Created by hdwang on 2017-06-16. 第一个数据源配置 If you are using Spring Data, you
 * need to configure @EnableJpaRepositories
 */

//basePackages = "com.hdwang.dao.datajpa.firstDs",

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "firstEntityManagerFactory", transactionManagerRef = "firstTransactionManager")
public class FirstDsConfig {

	@Autowired
	private Environment env;

	/**
	 * 数据源对象
	 * 
	 * @return
	 */

	@Bean
	@Primary
	public DataSource firstDataSource() {
		// spring-boot-starter-jdbc
		DriverManagerDataSource ds = new DriverManagerDataSource();
		// 配置信息
		ds.setDriverClassName(env.getProperty("first.datasource.driverClassName"));
		ds.setUrl(env.getProperty("first.datasource.url"));
		ds.setUsername(env.getProperty("first.datasource.username"));
		ds.setPassword(env.getProperty("first.datasource.password"));
		return ds;

	}

	/**
	 * 实体管理对象
	 * @return
	 */
	@Bean
	@Primary
	public LocalContainerEntityManagerFactoryBean firstEntityManagerFactory() {

		// spring-boot-starter-data-jpa
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();

		factory.setDataSource(firstDataSource());
		factory.setPackagesToScan("com");  //设置实体类所在位置
		factory.setPersistenceUnitName("firstDs");
		
		// JpaVendorAdapter
		HibernateJpaVendorAdapter vendorAdaptor = new HibernateJpaVendorAdapter();
		factory.setJpaVendorAdapter(vendorAdaptor);

		Properties jpaProperties = new Properties();
		jpaProperties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
		jpaProperties.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
		jpaProperties.put("hibernate.format_sql", env.getProperty("hibernate.format_sql"));

		factory.setJpaProperties(jpaProperties);

		return factory;
	}

	/////////////////////////////////////////////////////////

	/**
	 * 事务管理对象
	 * 
	 * @return
	 */
	@Bean(name = "firstTransactionManager")
	@Primary
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(emf);
		return transactionManager;
	}

	// 默认
	@Bean
	@Primary
	public JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(firstDataSource());
	}

	@Bean
	@Primary
	public TransactionTemplate transactionTemplate(PlatformTransactionManager platformTransactionManager) {
		return new TransactionTemplate(platformTransactionManager);
	}
}
