package com.rshade.dao;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.rshade.bean.Student;


public class StudentDaoImpl implements StudentDao{
	
	private static SessionFactory factory;
	
	private Logger logger=Logger.getLogger(StudentDaoImpl.class.getName());

	public static void setFactory(SessionFactory factory) {
		StudentDaoImpl.factory = factory;
	}



	@Override
	public int createStudent(Student student) {
		// TODO Auto-generated method stub
		Session session=factory.openSession();
		Transaction tx=null;
		try{
			tx=session.beginTransaction();
			int id=(Integer)session.save(student);
			tx.commit();
			return id;
		}
		catch(HibernateException e){
			if(tx!=null)tx.rollback();
			logger.error("Exception occured"+e.getMessage());
			System.out.println("exception occured:"+e.getMessage());
			e.printStackTrace();
		}
		finally{
			session.close();
		}
		
		return 0;
	}

}
