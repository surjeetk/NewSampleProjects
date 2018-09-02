package com.test.beans;

import org.springframework.beans.factory.DisposableBean;

public class DestroyBean implements DisposableBean {

	@Override
	public void destroy() throws Exception {
		System.out.println("Inside destroy method of DestroyBean");
		
	}

	
}
