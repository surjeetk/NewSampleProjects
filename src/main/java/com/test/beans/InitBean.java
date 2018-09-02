package com.test.beans;

import org.springframework.beans.factory.InitializingBean;

public class InitBean implements InitializingBean{

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Inside afterPropertySet method of initBean");
		
	}
	
}
