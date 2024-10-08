package com.kaykesilva.hrpayroll.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

// padrão de projeto singleton
@Configuration
public class AppConfig {

    @Bean
    RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
