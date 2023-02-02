package com.infiflex.jobrunr.config;



import javax.sql.DataSource;

import org.jobrunr.storage.sql.common.DatabaseCreator;
import org.jobrunr.storage.sql.common.SqlStorageProviderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
//@Configuration
public class DataStoreConfig {
//	@Bean
    public DataSource getDataSource() {
		
      return new DriverManagerDataSource("jdbc:mysql://localhost:3306/","infiflex","suryainfiflex");
    }
	
}
