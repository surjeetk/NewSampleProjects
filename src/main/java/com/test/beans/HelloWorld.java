package com.test.beans;

public class HelloWorld {
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public void afterInitialization(){
		System.out.println("inside afterInitialization of HelloWorld");
	}
	
	public void preDestroy(){
		System.out.println("inside preDestroy method of HelloWorld");
	}

}
