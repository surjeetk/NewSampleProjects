package com.test.test;

import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.test.pojo.Address;
import com.test.pojo.Country;
import com.test.pojo.Department;
import com.test.pojo.Student;
import com.test.pojo.Student.Gender;

public class TestApplication {

	private static SessionFactory factory;
	
	static{
		try {
			factory = new AnnotationConfiguration().configure().addAnnotatedClass(Address.class).addAnnotatedClass(Student.class).addAnnotatedClass(Department.class).buildSessionFactory();
					//.addPackage("com.test.pojo").buildSessionFactory(); // add
																		// package
																		// if
																		// used.
			 

		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static void main(String[] args) {
		
		
		TestApplication test =new TestApplication();
		
		Address addr = new Address();
		Country country= new Country();
		country.setIso2("100");
		country.setName("India");
		
		
		addr.setCity("Badlapur");
		addr.setPincode("421503");
		addr.setRoad("Katrap");
		addr.setNationality(country);
		
		test.addAddr(addr);
		
		//addr.setCity("Ambernath");
		
		System.out.println("addr id :"+addr.getAddr_id());
		
		Department dprt1= new Department();
		dprt1.setDprt_id(100);
		dprt1.setName("COMPUTER");
		
		Student student=test.addStudent("Umesh1", "1037",addr,country,dprt1);
		student.setDprt(dprt1);
		//boolean result=test.removeStudent(student);
		//System.out.println("Removed student :"+result);
		
		
		//test.addAddress("Ulhasnagar", "4214545dfdfdfdf", "Khemani", student);
		
		//test.addAddress("Badlapur", "4215dfdf656dddd", "katrap", null);
		
		factory.close();
	
	}

	/*public boolean addAddress(String city, String pincode, String road,
			Student student) */
	
	public int addAddr(Address addr)
	{

		Session session = factory.openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			/*Address add = new Address();
			add.setCity(city);
			add.setPincode(pincode);
			add.setRoad(road);
			add.setStudent(student);*/
			session.saveOrUpdate(addr);
	
			addr.setCity("Updated city");
			addr.setCity("updated city again");
			
			tx.commit();
			//addr.setCity("Updated city2");
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return addr.getAddr_id();
	}
	
	public boolean removeStudent(Student student){
		Session session = factory.openSession();
		Transaction tx = null;
		//Student student=new Student();
		try {
			tx = session.beginTransaction();
			Student stud = new Student(student.getRollno());
			stud.setAddr(student.getAddr());
			
			session.delete(stud);
			tx.commit();
		}
		 catch (HibernateException e) {
				if (tx != null)
					tx.rollback();
				e.printStackTrace();
				return false;
			} finally {
				session.close();
			}
			return true;
	}
	
	public Student addStudent(String name, String rollno, Address addr, Country country, Department dprt){
		Session session = factory.openSession();
		Transaction tx = null;
		Student student=new Student();
		try {
			tx = session.beginTransaction();
			
			student.setName(name);
			student.setRollno(rollno);
			student.setAddr(addr);
			student.setGender(Gender.MALE);
			student.setTime(new Date());
			session.saveOrUpdate(student);
			
			student.setBornIn(country);
			student.setDprt(dprt);
			tx.commit();
		}
		 catch (HibernateException e) {
				if (tx != null)
					tx.rollback();
				e.printStackTrace();
			} finally {
				session.close();
			}
			return student;
	}
}
