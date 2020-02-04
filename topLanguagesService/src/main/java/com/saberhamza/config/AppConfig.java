package com.saberhamza.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * 
 * Configuration class to enable Spring MVC.
 * 
 * @author Hamza SABER
 *
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.saberhamza")
public class AppConfig {

}
