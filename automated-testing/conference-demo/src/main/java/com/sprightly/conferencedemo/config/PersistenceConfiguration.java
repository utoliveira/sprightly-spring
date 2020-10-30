package com.sprightly.conferencedemo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

@Configuration
public class PersistenceConfiguration {

    @Autowired
    private Environment env;

    private final Logger logger = LoggerFactory.getLogger(PersistenceConfiguration.class);

    @Bean
    public DataSource dataSource(){
        DataSourceBuilder builder = DataSourceBuilder.create();
        builder.url(env.getProperty("spring.datasource.url"));
        builder.username(env.getProperty("spring.datasource.username"));
        builder.password(env.getProperty("spring.datasource.password"));
        logger.info("Custom DataSource bean has been initialized :)");
        return builder.build();
    }
}
