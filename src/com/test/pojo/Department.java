package com.test.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Department {
	@Id
	private int dprt_id;
	private String name;
	
	
	public int getDprt_id() {
		return dprt_id;
	}

	public void setDprt_id(int dprt_id) {
		this.dprt_id = dprt_id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}
