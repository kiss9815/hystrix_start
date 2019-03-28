package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableCircuitBreaker
@EnableDiscoveryClient
@ComponentScan(basePackages = "com.example.demo")
public class HytrixStartApplication {
	
	
	public static void main(String[] args) {
		SpringApplication.run(HytrixStartApplication.class, args);
		
		System.out.println("hello ");
		
		
		
		
	}

}
