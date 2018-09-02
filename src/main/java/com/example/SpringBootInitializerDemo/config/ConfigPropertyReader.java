package com.example.SpringBootInitializerDemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:config/custom-properties.properties")
public class ConfigPropertyReader {

	public String outsideProperty;
	public String myProperty;
	
	@Autowired
	public ConfigPropertyReader(@Value("${com.myproperty}") String myproperty,@Value("${com.test.property}") String outsideProperty){
		System.out.println("inside constructor of ConfigPropertyReader");
		System.out.println("My property value:"+myproperty);
		this.myProperty=myproperty;
		this.outsideProperty=outsideProperty;
	}
	
}
