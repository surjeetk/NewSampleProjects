package com.test.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.bean.Employee;
import com.test.dao.EmployeeDAO;

/**
 * Servlet implementation class EmployeeController
 */
@WebServlet("/register")
public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String emp_name=request.getParameter("emp_name");
		int sal=Integer.parseInt(request.getParameter("sal"));
	//	String dobString=
		Date dob=null;
		try {
			 dob= new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("dob"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			//e.printStackTrace();
		}
		
		Employee emp =new Employee(emp_name,sal,dob);
		EmployeeDAO empdao=new EmployeeDAO();
		Integer emp_id=empdao.addEmployee(emp);
		
	if(emp_id !=null){
		System.out.println("emp_id:"+emp_id);
		Employee emp1=empdao.getEmployee(emp_id);
		
	//	emp.setEmp_id(emp_id);
		request.setAttribute("Emp", emp1);
		RequestDispatcher rd=request.getRequestDispatcher("WEB-INF/view/success.jsp");
		rd.forward(request, response);
	}
	
	if(emp_id ==null){
	RequestDispatcher rd=request.getRequestDispatcher("WEB-INF/view/failure.jsp");
	rd.forward(request, response);
	}
	
			
		}
		
		
	}


