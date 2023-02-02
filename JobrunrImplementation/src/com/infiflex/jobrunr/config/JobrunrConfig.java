package com.infiflex.jobrunr.config;

import javax.sql.DataSource;

import org.jobrunr.configuration.JobRunr;
import org.jobrunr.configuration.JobRunrConfiguration.JobRunrConfigurationResult;
import org.jobrunr.scheduling.JobRequestScheduler;
import org.jobrunr.scheduling.JobScheduler;
import org.jobrunr.storage.InMemoryStorageProvider;
import org.jobrunr.storage.sql.common.SqlStorageProviderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
@Configuration
public class JobrunrConfig {
	@Autowired
	DriverManagerDataSource dataSource;
//	 @Bean
//	    public JobRunrConfigurationResult initJobRunr(ApplicationContext applicationContext) {
//	        return JobRunr.configure()
//	                .useJobActivator(applicationContext::getBean)
//	                .useStorageProvider(new InMemoryStorageProvider())
//	                .useBackgroundJobServer()
//	                .useJmxExtensions()
//	                .useDashboard()
//	                .initialize();
//	        
//	    }
	 
	 @Bean
	    public JobRunrConfigurationResult initJobRunr(ApplicationContext applicationContext) {
	        return JobRunr.configure()
	                .useJobActivator(applicationContext::getBean)
	                .useStorageProvider(SqlStorageProviderFactory
	                          .using((DataSource)dataSource))
	                .useBackgroundJobServer()
	                .useJmxExtensions()
	                .useDashboard()
	                .initialize();
	    }
	    
	    @Bean
	    public JobScheduler initJobScheduler(JobRunrConfigurationResult jobRunrConfigurationResult) {
	        return jobRunrConfigurationResult.getJobScheduler();
	    }

	    @Bean
	    public JobRequestScheduler initJobRequestScheduler(JobRunrConfigurationResult jobRunrConfigurationResult) {
	        return jobRunrConfigurationResult.getJobRequestScheduler();
	    }
}
