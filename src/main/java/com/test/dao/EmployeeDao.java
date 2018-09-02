package com.test.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.test.beans.Employee;
import com.test.mapper.EmployeeMapper;

@Component
public class EmployeeDao {

	@Autowired
	private JdbcTemplate jdbcTemplateObject;
	
	
	public List<Employee> getEmployees(){
		String sql="select * from employee";
		List<Employee> employees=jdbcTemplateObject.query(sql, new EmployeeMapper());
		return employees;
		
	}
	
}
