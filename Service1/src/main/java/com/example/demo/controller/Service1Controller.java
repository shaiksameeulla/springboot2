package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service1.configuration.MessageBeanConfiguration;

@RestController
@RequestMapping(path = "/service1")
public class Service1Controller {
	
	private static Logger log = LoggerFactory.getLogger(Service1Controller.class);
	
	@Autowired
	private MessageBeanConfiguration config;
	
	@GetMapping
	public String getGreetings() {
		log.debug("----------Service1Controller::getgreetings----------");
		return "Hello Service1"+config.getMessage();
	}
	
	@GetMapping("/test")
	public String getTestGreetings() {
		log.debug("----------Service1Controller::Test----------");
		return "Hello Service1 Test";
	}

}
