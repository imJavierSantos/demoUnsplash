package com.unsplash.demo.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.client.RestTemplate;


@EnableAutoConfiguration
@Configuration
public class DemoConfigurator {

    @Bean
    public RestTemplate executorService() {
        return new RestTemplate();
    }

}
