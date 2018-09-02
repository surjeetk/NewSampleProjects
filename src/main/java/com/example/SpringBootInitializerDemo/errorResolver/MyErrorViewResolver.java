package com.example.SpringBootInitializerDemo.errorResolver;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.ModelAndView;

public class MyErrorViewResolver implements ErrorViewResolver{

	@Override
	public ModelAndView resolveErrorView(HttpServletRequest request,
			HttpStatus status, Map<String, Object> model) {
		// TODO Auto-generated method stub
		
		System.out.println("------------inside resolveErrorView---------------------");
		if(status==HttpStatus.BAD_REQUEST)
		System.out.println("bad request");
			return new ModelAndView("error");
		
		
	}

	
}
