package com.isoft.conf;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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

//basePackages = "com.isoft.repository",
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.isoft.repository",entityManagerFactoryRef = "secondEntityManagerFactory", transactionManagerRef = "secondTransactionManager")
public class SecondDsConfig { // basePackages = ""     //设置Repository所在位置 
	                          // 如果采用传统jpa方式，@EnableJpaRepositories无需配置，配置了也无影响

	@Autowired
	private Environment env;

	@Bean
	public DataSource secondDataSource() {
		// spring-boot-starter-jdbc
		DriverManagerDataSource ds = new DriverManagerDataSource();
		// 配置信息
		ds.setDriverClassName(env.getProperty("second.datasource.driverClassName"));
		ds.setUrl(env.getProperty("second.datasource.url"));
		ds.setUsername(env.getProperty("second.datasource.username"));
		ds.setPassword(env.getProperty("second.datasource.password"));

		return ds;
	}

	//@Bean创建的bean对象的名称默认为方法名，也可以指定
	@Bean
	public LocalContainerEntityManagerFactoryBean secondEntityManagerFactory() {

		// spring-boot-starter-data-jpa
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();

		factory.setDataSource(secondDataSource());
		factory.setPackagesToScan("com");   //设置实体类所在位置
		factory.setPersistenceUnitName("secondDs");
		
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

	/**
	 * 事物管理对象
	 * 
	 * @param secondEntityManagerFactory
	 *            实体管理工厂对象（按照名称注入）
	 * @Bean方法参数表示，接收一个bean对象，默认按照type类型接收注入的对象，若要修改为byName方式，可以使用@Qualifier注解注入准确的对象
	 * @return 平台事物管理器
	 */
	@Bean(name = "secondTransactionManager")
	public PlatformTransactionManager transactionManager(
			@Qualifier("secondEntityManagerFactory") LocalContainerEntityManagerFactoryBean secondEntityManagerFactory) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(secondEntityManagerFactory.getObject());
		return transactionManager;
	}

	@Bean(name = "secondJdbcTemplate")
	public JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(secondDataSource());
	}

	@Bean(name = "secondTransactionTemplate")
	public TransactionTemplate transactionTemplate(
			@Qualifier("secondTransactionManager") PlatformTransactionManager transactionManager) {
		return new TransactionTemplate(transactionManager);
	}
}