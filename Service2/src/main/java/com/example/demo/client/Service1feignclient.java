package com.example.demo.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("service1")
public interface Service1feignclient {
	
	@GetMapping("/service1/")
	public String getGreetings();

}
