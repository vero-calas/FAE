package com.mongodb.mongodb.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@Configuration
@EnableMongoRepositories("com.mongodb.mongodb.repository")
public class mongoConfig {

}
