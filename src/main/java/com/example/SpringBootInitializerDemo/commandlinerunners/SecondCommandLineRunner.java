package com.example.SpringBootInitializerDemo.commandlinerunners;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class SecondCommandLineRunner implements CommandLineRunner{

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Inside run method of second command line runner");
		
	}

	
}
