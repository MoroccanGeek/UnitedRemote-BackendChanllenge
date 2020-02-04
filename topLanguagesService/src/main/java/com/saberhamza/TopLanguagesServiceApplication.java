package com.saberhamza;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 
 * The main class to start the application.
 * 
 * @author Hamza SABER
 *
 */
@SpringBootApplication
@EnableEurekaClient
public class TopLanguagesServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TopLanguagesServiceApplication.class, args);
	}

	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
}
