<%@page import="com.hibernate.EmployeeData"%>
<%@page import="com.hibernate.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Employee page</title>
</head>
<body>
	<% 
	String employeeId = request.getParameter("employeeId");
	Employee emp = null;
	emp = EmployeeData.getEmployee(employeeId);
	%>
	<form action="/HibernateApplication/EditEmployeeServlet">
	<table width="500" border="0">
		<tr>
			<td>Employee Id</td>
			<td><%=emp.getEmployeeId() %><input type = "hidden" name = "employeeId" value="<%=emp.getEmployeeId()%>"></td>
		</tr>
		<tr>
			<td>Employee Id</td>
			<td><input type="text" name = "name" value = <%=emp.getName() %>></td>
		</tr>
		<tr>
			<td>Employee Age</td>
			<td><input type="text" name = "age" value = <%=emp.getage()%>></td>
		</tr>
		<tr>
			<td>Employee Salary</td>
			<td><input type="text" name = "salary" value = <%=emp.getSalary()%>></td>
		</tr>
		
		<tr>
			<td><input type="submit" name = "submit" value="submit"></td>
		</tr>
	</table>
	</form>
	
</body>
</html>