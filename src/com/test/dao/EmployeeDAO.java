package com.test.dao;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.test.bean.Employee;

public class EmployeeDAO {
private static SessionFactory factory;

public Integer addEmployee(Employee emp){
	

	
	try{
		factory = new Configuration().configure().buildSessionFactory();
		}catch (Throwable ex) {
		System.err.println("Failed to create sessionFactory object." + ex);
		throw new ExceptionInInitializerError(ex);
		}
	Session session=factory.openSession();
	
	Transaction tx=session.beginTransaction();
	
	Integer emp_id= (Integer) session.save(emp);
	tx.commit();
	session.close();
	return emp_id;
	
	
}

public Employee getEmployee(Integer emp_id){
//	factory=new Configuration().buildSessionFactory();
	Session session=factory.openSession();
	Employee emp=(Employee) session.get(Employee.class, emp_id);
	
	session.close();
	return emp;
}
}
