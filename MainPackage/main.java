package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.ApiService.ApiService;

@SpringBootApplication
public class Project01Application implements CommandLineRunner{
	
	@Autowired
	private ApiService apiService;

	public static void main(String[] args) {
		SpringApplication.run(Project01Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		this.apiService.getSingleDataUsingExchangeMethod();
		this.apiService.getSingleDataUsingGetForEntity();
		this.apiService.getSingleDataUsingGetForObject();
		
		
	}

}
