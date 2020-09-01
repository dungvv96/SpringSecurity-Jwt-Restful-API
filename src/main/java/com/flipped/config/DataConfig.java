/**
 * 
 */
package com.flipped.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.dialect.Oracle10gDialect;
import org.springframework.batch.core.configuration.annotation.BatchConfigurer;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.explore.JobExplorer;
import org.springframework.batch.core.explore.support.JobExplorerFactoryBean;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author zz6unp
 *
 */
@Configuration
@EnableJpaRepositories("com.flipped.repository")
@EnableTransactionManagement
@EnableBatchProcessing
@PropertySource("classpath:environment-develop.properties")
public class DataConfig implements BatchConfigurer {

	@Autowired
	private Environment env;
	
	@Override
	public JobRepository getJobRepository() throws Exception {
		JobRepositoryFactoryBean factory = new JobRepositoryFactoryBean();
		factory.setDataSource(getDataSource());
		factory.setTransactionManager(getTransactionManager());
		factory.setIsolationLevelForCreate("ISOLATION_DEFAULT");
		factory.setValidateTransactionState(false);
		factory.afterPropertiesSet();
		return factory.getObject();
	}

	@Override
	public PlatformTransactionManager getTransactionManager() throws Exception {
		JpaTransactionManager bean = new JpaTransactionManager();
		bean.setEntityManagerFactory(getEntityManagerFactory().getObject());
		return bean;
	}

	@Override
	public JobLauncher getJobLauncher() throws Exception {
		SimpleJobLauncher jobLauncher = new SimpleJobLauncher();
		jobLauncher.setJobRepository(getJobRepository());
		jobLauncher.setTaskExecutor(new SimpleAsyncTaskExecutor());
		jobLauncher.afterPropertiesSet();
		return jobLauncher;
	}

	@Override
	public JobExplorer getJobExplorer() throws Exception {
		JobExplorerFactoryBean bean = new JobExplorerFactoryBean();
		bean.setDataSource(getDataSource());
		bean.afterPropertiesSet();
		return bean.getObject();
	}
	
	@Bean
	public DataSource getDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(env.getRequiredProperty("datasource.jdbc.driver"));
		dataSource.setUsername(env.getRequiredProperty("datasource.jdbc.username"));
		dataSource.setPassword(env.getRequiredProperty("datasource.jdbc.password"));
		dataSource.setUrl(env.getRequiredProperty("datasource.jdbc.url"));
		dataSource.setMaxActive(env.getRequiredProperty("datasource.maxActive", Integer.class));
		dataSource.setMinIdle(env.getRequiredProperty("datasource.maxIdle", Integer.class));
		dataSource.setTimeBetweenEvictionRunsMillis(env.getRequiredProperty("datasource.timeBetweenEvictionRunsMillis", Long.class));
		dataSource.setTestWhileIdle(env.getRequiredProperty("datasource.testWhileIdle", Boolean.class));
		dataSource.setValidationQuery(env.getRequiredProperty("datasource.validationQuery"));
		dataSource.setNumTestsPerEvictionRun(env.getRequiredProperty("datasource.numTestsPerEvictionRun", Integer.class));
		return dataSource;
	}
	
	@Bean
	public DataSourceInitializer getDataSourceInitializer() {
		final ResourceDatabasePopulator popular = new ResourceDatabasePopulator();
		popular.setContinueOnError(true);
		
		final DataSourceInitializer initializer = new DataSourceInitializer();
		initializer.setDataSource(getDataSource());
		initializer.setDatabasePopulator(popular);
		
		return initializer;
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean getEntityManagerFactory() {
		LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
		entityManager.setDataSource(getDataSource());
		entityManager.setPackagesToScan("com.flipped.entity");
		
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setDatabase(Database.ORACLE);
		entityManager.setJpaVendorAdapter(vendorAdapter);
		
		Properties properties = new Properties();
		properties.put("hibernate.dialect", Oracle10gDialect.class.getCanonicalName());
		properties.put("hibernate.show_sql", env.getRequiredProperty("hibernate.show_sql", Boolean.class));
		properties.put("hibernate.format_sql", env.getRequiredProperty("hibernate.format_sql", Boolean.class));
		properties.put("hibernate.connection.useUnicode", "true");
		properties.put("hibernate.connection.characterEncoding", "utf8");
		
		//hibernate search
		properties.put("hibernate.search.lucene_version", env.getRequiredProperty("hibernate.search.lucene_version"));
		//properties.put("hibernate.search.analyzer", env.getRequiredProperty("hibernate.search.analyzer"));
		properties.put("hibernate.search.default.directory_provider", env.getRequiredProperty("hibernate.search.default.directory_provider"));
		properties.put("hibernate.search.default.indexBase", env.getRequiredProperty("hibernate.search.default.indexBase"));
		properties.put("hibernate.search.default.exclusive_index_use", env.getRequiredProperty("hibernate.search.default.exclusive_index_use"));
		
		entityManager.setJpaProperties(properties);
		
		return entityManager;
	}

}
