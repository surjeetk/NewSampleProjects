package com.example.SpringBootInitializerDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.example.SpringBootInitializerDemo.config.ConfigPropertyReader;
import com.example.SpringBootInitializerDemo.config.PropertyMapping;

//@SpringBootApplication(exclude = {ErrorMvcAutoConfiguration.class})
@SpringBootApplication
@RestController
//@PropertySource("File:J:/Technology_learning_for_interview/spring_boot_properties/application.properties")
public class SpringBootInitializerDemoApplication implements ApplicationRunner{
	
	@Autowired
	ConfigPropertyReader propReader;
	
	@Autowired
	PropertyMapping propMapping;
		
	@RequestMapping("/sayHello")
	public String sayHello(){
		return "Hello Again!";
	}
	

	public static void main(String[] args) {
		SpringApplication app= new SpringApplication(SpringBootInitializerDemoApplication.class); 
	app.run(args);
	//WebApplicationType.REACTIVE
	
	//to exit with exit code
	/*System.exit(SpringApplication.exit(app.run(args), exitCodegenerator()));*/
	
/*	SpringApplication app1=new SpringApplicationBuilder()
	.sources(SpringBootInitializerDemoApplication.class)
	.run(args);*/
	
		//run(SpringBootInitializerDemoApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("Inside run method of Application Runner......");
		System.out.println("Custom Property inside:"+propReader.myProperty);
		System.out.println("Custom Property outside:"+propReader.outsideProperty);
		System.out.println("Property Mapping property:"+propMapping.property);
		System.out.println("Profile specific property:"+propMapping.dev);
	}
	
	@Autowired
	public void argsBean(ApplicationArguments args){
		System.out.println("Non option args passed:"+args.getNonOptionArgs());
		System.out.println("Option names:"+args.getOptionNames());
	}
	
	public static ExitCodeGenerator exitCodegenerator(){
		return () -> 42;
	}
	
/*	@Bean
	public InternalResourceViewResolver viewResolver(){
		System.out.println("------------inside viewResolver--------------");
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/webapp/jsp/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}*/
	
	 @Bean
	    public ViewResolver jspViewResolver() {
	        InternalResourceViewResolver bean = new InternalResourceViewResolver();
	        bean.setPrefix("/WEB-INF/jsp/");
	        bean.setSuffix(".jsp");
	        return bean;
	    }
	 
	 //to disable web security
	 @Bean
	 public WebSecurityConfigurerAdapter webSecurityAdapter(){
		 return new WebSecurityConfigurerAdapter(){
			 
		 };
	 }
	 
}
