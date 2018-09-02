package com.rshade.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rshade.bean.Student;
import com.rshade.service.StudentService;




@RestController
@CrossOrigin
@RequestMapping(value="/service/student")
public class StudentServiceController {
	
	@Autowired
	private StudentService studentservice;

	private Logger logger=Logger.getLogger(StudentServiceController.class.getName());
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public Student getStudents(){
		System.out.println("inside getstudents");
		Student stud= new Student();
		stud.setFirstname("surjeet");
		stud.setLastname("Karmakar");
		stud.setId(100);
		logger.debug("Stud :"+stud.getId());
		return stud;
	}
	
	@RequestMapping(value="/addstudent",method=RequestMethod.POST)
	public String createStudent(@RequestBody Student student){
		int id=studentservice.createStudent(student);
		if(id!=0){
			return "Student is added with ID:"+id;
		}
		return "Sorry! student has not been added";
	}
}
