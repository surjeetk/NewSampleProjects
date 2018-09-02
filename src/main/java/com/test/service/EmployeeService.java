package com.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.test.beans.Employee;
import com.test.dao.EmployeeDao;

public class EmployeeService {
	
	@Autowired
	private EmployeeDao employeeDao;
	
	public List<Employee> getEmployees(){
		return employeeDao.getEmployees();
	}

}
