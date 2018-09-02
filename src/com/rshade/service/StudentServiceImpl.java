package com.rshade.service;

import org.springframework.mail.javamail.JavaMailSenderImpl;

import com.rshade.bean.Student;
import com.rshade.dao.StudentDao;


public class StudentServiceImpl implements StudentService {

	private StudentDao studentDao;
	
	private JavaMailSenderImpl mailSender;
	
	
	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}


	public void setMailSender(JavaMailSenderImpl mailSender) {
		this.mailSender = mailSender;
	}


	@Override
	public int createStudent(Student student) {
		// TODO Auto-generated method stub
		return studentDao.createStudent(student);
	}

}
