package com.test.config;

import javax.sql.DataSource;

import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.test.aspect.AspectDemo;
import com.test.aspect.HijackAroundMethod;
import com.test.beans.Employee;
import com.test.beans.HelloWorld;
import com.test.dao.EmployeeDao;
import com.test.events.CStartEventHandler;
import com.test.events.CustomEventHandler;
import com.test.events.CustomEventPublisher;
import com.test.service.EmployeeService;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass=true)
@ComponentScan(basePackages="com.test")
public class JavaBasedConfig {
	
	static int count;

	@Bean
	public HelloWorld helloWorld(){
		System.out.println("inside helloWorld");
		return new HelloWorld();
	}
	

	@Bean
	@Scope("prototype")
	public HelloWorld helloWorld1(){
		count++;
		System.out.println("inside helloWorld1 "+count+" time");
		return new HelloWorld();
	}
	
	@Bean
	public CStartEventHandler cStartEventHandler(){
		return new CStartEventHandler();
	}
	
	@Bean
	public CustomEventHandler customEventHandler(){
		return new CustomEventHandler();
	}
	
	@Bean
	public CustomEventPublisher customEventPublisher(){
		return new CustomEventPublisher();
	}
	
	@Bean
	public AspectDemo aspectDemo(){
		return new AspectDemo();
	}
	
	@Bean
	public DataSource dataSource(){
		DriverManagerDataSource datasource=new DriverManagerDataSource();
		datasource.setDriverClassName("com.mysql.jdbc.Driver");
		datasource.setUsername("root");
		datasource.setPassword("surjeet");
		datasource.setUrl("jdbc:mysql://localhost:3306/test");
		return datasource;
	}

	@Bean
	public JdbcTemplate jdbcTemplate(){
		JdbcTemplate jdbctemplate=new JdbcTemplate();
		jdbctemplate.setDataSource(dataSource());
		return jdbctemplate;
	}
	
	@Bean
	public Employee employee(){
		return new Employee();
	}
	
	@Bean
	public EmployeeDao employeeDao(){
		return new EmployeeDao();
	}
	
	@Bean
	public EmployeeService employeeService(){
		return new EmployeeService();
	}
	
/*	@Bean
	public JavaBasedConfigMain configMain(){
		return new JavaBasedConfigMain(employeeDao());
	}*/
	
	/*@Bean
	public JavaBasedConfigMain configMain(){
		return new JavaBasedConfigMain();
	}*/
	
	@Bean
	public HijackAroundMethod hijackAroundMethodBean(){
		return new HijackAroundMethod();
	}
	
	/**
	 * @return
	 */
	@Bean
	public ProxyFactoryBean helloWorldProxy(){
		ProxyFactoryBean helloWorldProxy=new ProxyFactoryBean();
		helloWorldProxy.setTarget(helloWorld());
		helloWorldProxy.setInterceptorNames("hijackAroundMethodBean");
		
		return helloWorldProxy;
	}
	
}