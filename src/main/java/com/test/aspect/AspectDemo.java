package com.test.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AspectDemo {
	
	@Pointcut("execution(* com.test.beans.HelloWorld.*(..))")
	private void helloWorld1(){}
	
	@Before("helloWorld1()")
	private void beforeAspect(){
		System.out.println("Inside before aspect");
	}
	
	
	
}
