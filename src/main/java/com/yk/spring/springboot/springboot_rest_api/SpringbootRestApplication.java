package com.yk.spring.springboot.springboot_rest_api;

import com.yk.spring.springboot.springboot_rest_api.configuration.DataSourceConfig;
import com.yk.spring.springboot.springboot_rest_api.service.DataSourceService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootRestApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringbootRestApplication.class, args);
	}
}
