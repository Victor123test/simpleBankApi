package com.labsit.codetest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableAutoConfiguration
@EnableGlobalMethodSecurity(securedEnabled = true)
@SpringBootApplication
@EnableSwagger2
public class CodetestApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodetestApplication.class, args);
	}

}
