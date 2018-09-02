package com.example.SpringBootInitializerDemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




import com.example.SpringBootInitializerDemo.config.PropertyMapping;

@RestController
public class HelloController {
	@Autowired
	PropertyMapping prop;

	@RequestMapping("/hello")
	public String hello(){
		System.out.println("Test dev property value:"+prop.getDev());
		Logger logger = LoggerFactory.getLogger(HelloController.class);
		logger.info("Greetings from Spring Boot!");
		
		return "Greetings from Spring Boot!";
	}
	
}
