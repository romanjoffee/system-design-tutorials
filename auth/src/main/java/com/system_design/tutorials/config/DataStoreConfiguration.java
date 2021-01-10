package com.system_design.tutorials.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan("com.system_design.tutorials.domain")
@EnableJpaRepositories("com.system_design.tutorials.repository")
public class DataStoreConfiguration {
}
