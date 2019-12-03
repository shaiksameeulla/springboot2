
package com.example.demo.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.client.Service1feignclient;



@RestController
@RequestMapping(path = "/service2")
public class Service2Controller {
	static int i;
	
	private static Logger log = LoggerFactory.getLogger(Service2Controller.class);
	@Autowired
	private Service1feignclient service1feignclient;
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping
	public String getGreetings() {
		log.debug("Feign clients");
		
		return "Hello Service2"+"responsefrom service1["+service1feignclient.getGreetings()+"]";
	}
	
	
	@GetMapping("/rest")
	public String getRestGreetings() {
		log.debug("Resttemplate clients");
		return "Hello Service2 Rest"+"responsefrom service1["+restTemplate.getForEntity("http://localhost:8081/service1", String.class).getBody()+"]";
	}
	
	@GetMapping("/test")
	public String getTestGreetings() {
		log.debug("Test clients");
		return "Hello Service2 Test";
	}
	
	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}

}
