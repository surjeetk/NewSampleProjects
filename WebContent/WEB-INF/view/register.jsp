<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration Form</title>
</head>
<body>
    <h1>Employee Registration Form</h1>
    <form action="register" method="post">
        <table cellpadding="3pt">
            <tr>
                <td>User Name :</td>
                <td><input type="text" name="emp_name" size="30" /></td>
            </tr>
           
 
          
                <td>Salary :</td>
                <td><input type="text" name="sal" size="30" /></td>
            </tr>
            <tr>
                <td>DOB (dd/mm/yyyy) :</td>
                <td><input type="text" name="dob" size="30" /></td>
            </tr>
          
        </table>
        <p />
        <input type="submit" value="Register" />
    </form>
</body>
</html>
