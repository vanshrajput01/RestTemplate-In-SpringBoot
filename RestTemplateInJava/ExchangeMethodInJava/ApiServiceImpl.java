package com.example.demo.ApiService;

import java.util.HashMap;
import java.util.Map;

import org.springframework.aop.framework.autoproxy.AbstractAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiServiceImpl implements ApiService{
	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public void getSingleDataUsingExchangeMethod() {
		
		String url = "https://api.freeapi.app/api/v1/public/randomusers/{userId}";
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<Object> requestEntity = new HttpEntity<>(headers);
		Map<String, Integer> params = new HashMap<>();
		params.put("userId", 1);
		
		ResponseEntity<String> response = restTemplate.exchange(url,HttpMethod.GET,requestEntity,String.class,params);
		System.out.println(response.getStatusCode());
		System.out.println(response.getBody());
		
		
		
	}

	@Override
	public void getListDataUsingExchangeMethod() {
		
		String url = "https://api.freeapi.app/api/v1/public/randomusers";
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<Object> requestEntity = new HttpEntity<>(headers);
		
		ResponseEntity<Object> response = restTemplate.exchange(url, HttpMethod.GET,requestEntity,Object.class);
		System.out.println("Reponse :- " + response.getBody());
		System.out.println("Status code :-" + response.getStatusCode());

		
	}

	@Override
	public void postDataUsingExchangeMethod() {
		
		String url = "";
		HttpHeaders headers = new HttpHeaders();
		
		create object that you want to save in database.
		and set data 
		pass here in Http entity object as body.
		HttpEntity<Object> requestEntity = new HttpEntity<>(user,headers);
	
		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST,requestEntity,String.class); 
		System.out.println("Response :-" + response);
		
		
	}

	@Override
	public void deleteDataUsingExchangeMethod() {
		
		String url = "https://api.freeapi.app/api/v1/kitchen-sink/http-methods/delete";
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<Object> requestEntity = new HttpEntity<>(headers);
//		Map<String,String> params = new HashMap<>();
//		params.put("addressId", "647af1707396af90865b0edd");
		
		ResponseEntity<Object> response = restTemplate.exchange(url,HttpMethod.DELETE,requestEntity,Object.class);
		
		System.out.println("Response :- " + response.getBody());		
		
	}

	@Override
	public void updateDataUsingExchangeMethod() {
		String url = "https://api.freeapi.app/api/v1/ecommerce/addresses/{addressId}";
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		
		create object of Address class that you want to save in database.
		and set data 
		pass here in Http entity object as body.
		
		HttpEntity<Object> requestEntity = new HttpEntity<>(address,headers);
		
		Map<String, String> params = new HashMap<>();
		params.put("addressId", "value");
		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.PUT,requestEntity,String.class,params);
		System.out.println("response :-" + response.getBody());
		
		
	
		
	}




	
	
	
	
	

}
