package com.sa.springbootrestdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.sa.springbootrestdemo.dtos.MobileMapper;
import com.sa.springbootrestdemo.dtos.MobileMapperImpl;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "MobileAppAPI",version = "1.0",description = "API for mobile service"))
public class MobilePhoneAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MobilePhoneAppApplication.class, args);
	}
	
	@Bean 
	public MobileMapper getMapper() {
		return new MobileMapperImpl();
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
