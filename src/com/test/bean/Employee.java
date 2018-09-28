package com.test.bean;

import java.util.Date;

public class Employee {
private int emp_id;
private String emp_name;
private int sal;
private int age;
private Date dob;

public Employee(){}
public Employee(String emp_name,int sal,Date dob){
	this.emp_name=emp_name;
	this.sal=sal;
	this.dob=dob;
}

public int getEmp_id() {
	return emp_id;
}
public void setEmp_id(int emp_id) {
	this.emp_id = emp_id;
}
public String getEmp_name() {
	return emp_name;
}
public void setEmp_name(String emp_name) {
	this.emp_name = emp_name;
}
public int getSal() {
	return sal;
}
public void setSal(int sal) {
	this.sal = sal;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public Date getDob() {
	return dob;
}
public void setDob(Date dob) {
	this.dob = dob;
}



}
