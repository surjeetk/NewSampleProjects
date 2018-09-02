package com.test.main;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test.beans.HelloWorld;
import com.test.beans.Student;

public class MainApplication {

	//private static ApplicationContext context;
	
	//private static AbstractApplicationContext context;

	public static void main(String[] args) {
		
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		
		System.out.println("-----------Singleton demo----------------------");
		HelloWorld obj=(HelloWorld) context.getBean("helloWorld");
		
		System.out.println("Befor editing:"+obj.getMessage());
		
		obj.setMessage("altered message");
		
		HelloWorld obj1=(HelloWorld)context.getBean("helloWorld");
		
		System.out.println("Second object message:"+obj1.getMessage());
		
		System.out.println("-----------------Prototype demo----------------");
		HelloWorld new_obj=(HelloWorld) context.getBean("helloWorld1");
		
		System.out.println("Befor editing:"+new_obj.getMessage());
		
		new_obj.setMessage("altered message");
		
		HelloWorld new_obj1=(HelloWorld)context.getBean("helloWorld1");
		
		System.out.println("Second object message:"+new_obj1.getMessage());
		
		
		
		
		System.out.println("-----------------------Autowiring demo------------------");
		Student stud=(Student) context.getBean("student");
		System.out.println(stud);
		
		
		
		System.out.println("----------------Around AOP-------------------------------");
		HelloWorld proxyObj=(HelloWorld) context.getBean("helloWorldProxy");
		System.out.println(proxyObj.getMessage());
		
		context.close();
		context.registerShutdownHook();

	}

}
