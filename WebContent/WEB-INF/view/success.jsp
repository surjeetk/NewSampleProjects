<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.test.bean.Employee"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Employee added successfully</h1>

<%
Employee emp=(Employee)request.getAttribute("Emp");
if(emp!=null){
out.println("Employee name:"+emp.getEmp_name()+"</br>");
out.println("Employee age:"+emp.getAge()+"</br>");
out.println("Employee dob:"+emp.getDob()+"</br>");
out.println("Employee ID:"+emp.getEmp_id()+"</br>");
}
%>

</body>
</html>