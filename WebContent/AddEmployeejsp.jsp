<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Employee Page</title>
</head>
<body>
	<form action="/HibernateApplication/AddEmployeeServlet">
	<table width="500" border="0">
	<tr>
		<td>Employee Id</td>
		<td> <input type = "text" name = "employeeId"></td>
	</tr>
	<tr>
		<td>Employee Name</td>
		<td> <input type = "text" name = "name"></td>
	</tr>
	<tr>
		<td>Employee Age</td>
		<td> <input type = "text" name = "age"></td>
	</tr>
	<tr>
		<td>Employee Salary</td>
		<td> <input type = "text" name = "salary"></td>
	</tr>
	<tr>
			<td> <input type = "submit" name ="submit" value = "submit"></td>
	</tr>
	</table>
	</form>
	
</body>
</html>