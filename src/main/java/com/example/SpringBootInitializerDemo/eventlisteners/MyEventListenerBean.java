package com.example.SpringBootInitializerDemo.eventlisteners;


import org.springframework.boot.context.event.SpringApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class MyEventListenerBean implements ApplicationListener<SpringApplicationEvent>{

	/*@Autowired
	ApplicationContextAware appCtxtAwr;
		*/
	
	public void doSomethingOnEvent(SpringApplicationEvent e){
		System.out.println("Event occurred:"+e.toString());
	}

	@Override
	public void onApplicationEvent(SpringApplicationEvent e) {
		System.out.println("Event occurred:"+e.toString());
		
	}
	
	

}
