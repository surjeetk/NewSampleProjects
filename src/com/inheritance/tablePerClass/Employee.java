package com.inheritance.tablePerClass;

import javax.persistence.Entity;

@Entity
public class Employee extends Person{

	private int empId;

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}
	
	
}
