package com.FarmersFriend.ProductService.config;// AsyncConfig.java
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Configuration
public class ExecutorConfig {

    @Bean
    public ExecutorService taskExecutor() {
        // Create a thread pool with 5 threads
        return Executors.newFixedThreadPool(5);
    }
}
