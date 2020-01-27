package com.saberhamza;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Top100GithubReposApplication {

	public static void main(String[] args) {
		SpringApplication.run(Top100GithubReposApplication.class, args);
	}

}
