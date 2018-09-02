package com.test.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Student {

	private String name;
	
	@Autowired
	@Qualifier("addr2")
	private Address addr;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddr() {
		return addr;
	}

	public void setAddr(Address addr) {
		this.addr = addr;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", addr=" + addr + "]";
	}
	
	@PostConstruct
	public void postConstruct(){
		System.out.println("this is post construct method of student");
	}
	
	@PreDestroy
	public void preDestroy(){
		System.out.println("this is pre destroy method of student");
	}
}
