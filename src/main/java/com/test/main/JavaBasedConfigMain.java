package com.test.main;

import java.util.List;

import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.test.beans.Employee;
import com.test.beans.HelloWorld;
import com.test.config.JavaBasedConfig;
import com.test.events.CustomEventPublisher;
import com.test.service.EmployeeService;


public class JavaBasedConfigMain{

	private static EmployeeService employeeService;
	
	static AnnotationConfigApplicationContext context=null;
	
	
	public static void main(String[] args) {
		
		context= new AnnotationConfigApplicationContext(JavaBasedConfig.class);
		context.start();
		
		employeeService=context.getBean(EmployeeService.class);
		
		
		System.out.println("-----------Singleton demo----------------------");
		HelloWorld obj=(HelloWorld) context.getBean("helloWorld");
		
		System.out.println("Before editing:"+obj.getMessage());
		
		obj.setMessage("altered message");
		
		HelloWorld obj1=(HelloWorld)context.getBean("helloWorld");
		
		System.out.println("Second object message:"+obj1.getMessage());
		
		System.out.println("-----------------Prototype demo----------------");
		HelloWorld new_obj=(HelloWorld) context.getBean("helloWorld1");
		
		System.out.println("Befor editing:"+new_obj.getMessage());
		
		new_obj.setMessage("altered message");
		
		HelloWorld new_obj1=(HelloWorld)context.getBean("helloWorld1");
		
		System.out.println("Second object message:"+new_obj1.getMessage());
		
		System.out.println("------------------Custom event handling demo---------------------");
		CustomEventPublisher cvp=(CustomEventPublisher) context.getBean("customEventPublisher");
		cvp.publish();
		
		
		System.out.println("-----------------Jdbc Template Demo------------------");
		List<Employee> employees=employeeService.getEmployees();
		System.out.println(employees);
		
		
		
		System.out.println("----------------Around AOP-------------------------------");
		HelloWorld proxyObj=(HelloWorld)context.getBean("helloWorldProxy");
		System.out.println(proxyObj.getMessage());
		
		
		
		
		context.close();
	}
	
	

}
