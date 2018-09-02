package com.example.SpringBootInitializerDemo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;

@Component
@ManagedResource
@ConfigurationProperties("com.test")
public class PropertyMapping {
	public String property;
	
	public String dev;
	
	

	public String getDev() {
		return dev;
	}

	//this is to set the value from Jconsole
	@ManagedAttribute
	public void setDev(String dev) {
		this.dev = dev;
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	

}
