package com.test.events;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

public class CustomEventPublisher implements ApplicationEventPublisherAware{
	
	private ApplicationEventPublisher eventPublisher;

	@Override
	public void setApplicationEventPublisher(
			ApplicationEventPublisher applicationEventPublisher) {
		this.eventPublisher=applicationEventPublisher;
	}
	
	public void publish(){
		CustomEvent ce=new CustomEvent(this);
		eventPublisher.publishEvent(ce);
	}

}
