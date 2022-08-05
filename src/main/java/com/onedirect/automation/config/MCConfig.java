package com.onedirect.automation.config;

import javax.sql.DataSource;

import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "MCEntityManagerFactory",transactionManagerRef = "MCTransactionManager", basePackages = {
		"com.onedirect.automation.MC.repository"})
public class MCConfig {
	
	@Bean(name = "MCDataSource")
	@ConfigurationProperties(prefix = "spring.mc.datasource")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}

	
	@Bean(name = "MCEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("MCDataSource") DataSource dataSource) {
		return builder.dataSource(dataSource)
				.packages("com.onedirect.automation.MC.model").persistenceUnit("MCModel").build();
	}

	
	@Bean(name = "MCTransactionManager")
	public PlatformTransactionManager transactionManager(
			@Qualifier("MCEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}
}
