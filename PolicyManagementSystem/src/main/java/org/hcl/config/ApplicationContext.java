
package org.hcl.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:database.properties")
public class ApplicationContext {
	@Autowired
	Environment environmentproperty;

	@Bean
	public DataSource getDatasource() {
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setDriverClassName(environmentproperty.getProperty("jdbc.driverClassName"));
		datasource.setUrl(environmentproperty.getProperty("jdbc.url"));
		datasource.setUsername(environmentproperty.getProperty("jdbc.username"));
		datasource.setPassword(environmentproperty.getProperty("jdbc.password"));
		return datasource;
	}

	public Properties getproperty() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.dialect", environmentproperty.getProperty("hibernate.dialect"));
		properties.setProperty("hibernate.show_sql", environmentproperty.getProperty("hibernate.show_sql"));
		properties.setProperty("hibernate.format_sql", environmentproperty.getProperty("hibernate.format_sql"));
		properties.setProperty("hibernate.hbm2ddl.auto", environmentproperty.getProperty("hibernate.hbm2ddl.auto"));
		return properties;
	}

	@Bean
	public LocalSessionFactoryBean getFactoryBean() {
		LocalSessionFactoryBean factorybean = new LocalSessionFactoryBean();
		factorybean.setDataSource(getDatasource());
		factorybean.setHibernateProperties(getproperty());
		factorybean.setPackagesToScan("org.hcl.model");
		return factorybean;
	}

	@Bean
	public HibernateTransactionManager getTransactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(getFactoryBean().getObject());
		return transactionManager;
	}

}
