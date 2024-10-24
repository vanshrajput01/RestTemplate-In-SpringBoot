package com.example.demo.ApiService;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import ch.qos.logback.core.model.INamedModel;

@Service
public class ApiServiceImpl implements ApiService{
	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public void getSingleRecordUsingForEntityMethod() {
		
		String url =  "https://api.freeapi.app/api/v1/public/randomusers/{userId}";
		
		// here no need to create HttpEntity.
		Map<String, Integer> params = new HashMap<>();
		params.put("userId", 10);
		
		ResponseEntity<String> response = restTemplate.getForEntity(url, String.class,params);
		System.out.println(response.getBody());
		
	}

	@Override
	public void getListOfRecordUsingForEntityMthod() {
		
		String url = "https://api.freeapi.app/api/v1/public/randomusers";
		
		ResponseEntity<Object> response = restTemplate.getForEntity(url, Object.class);
		System.out.println(response.getBody());
		
	}

	@Override
	public void postDataUsingForEntityMethod() {
		
		String url = "";
		
		// create object of address class and set value and pass into postForEntity method.
		ResponseEntity<String> response = restTemplate.postForEntity(url,address ,String.class);
		
//		System.out.println("Response :- "+response.getBody());
		
	}

	@Override
	public void updateData() {
		
		String url = "https://api.freeapi.app/api/v1/ecommerce/addresses/{addressId}";
		
		Map<String, String> params = new HashMap<>();
		params.put("addressId", "647af1707396af90865b0edd");
		// create object of address class and set value and pass object in put
		
		ResponseEntity<String> response = restTemplate.put(url,address,params);
		
		System.out.println(response.getBody());
		
	}

	@Override
	public void deleteData() {
		
		String url = "https://api.freeapi.app/api/v1/kitchen-sink/http-methods/delete";
		
		 restTemplate.delete(url,String.class);
	}
	

	



	
	
	
	
	

}
