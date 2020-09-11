<%@page import="com.hibernate.Employee"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee List page</title>
</head>
<body>
	<table width="700" border="0" cellpadding="0">
		<tr align="left">
			<th>Employee Id</th>
			<th>Name</th>
			<th>Age</th>
			<th>Salary</th>
		</tr>
		<!-- iterate over result of the query -->
		<%ArrayList employee = ((ArrayList)session.getAttribute("employee")); 
		if(employee != null && employee.size() >0)
		{
			for(int i = 0; i < employee.size(); i++)
			{
				Employee emp =  (Employee)employee.get(i);
				%>
				<tr>
					<td> <%=emp.getEmployeeId()%> </td>
					<td> <%=emp.getName() %> </td>
					<td> <%=emp.getage() %> </td>
					<td> <%=emp.getSalary()%> </td>
				</tr>
			<td><A href="/HibernateApplication/deleteEmployeeServlet?employeeId=<%=emp.getEmployeeId()%>">Delete</A>
			<td><A href="/HibernateApplication/EditEmploye.jsp?employeeId=<%=emp.getEmployeeId()%>">Edit</A>
			</td>
			<% 
			}
		}%>
	</table>
	<A href="/HibernateApplication/AddEmployee.jsp">Add new Employee</A>
	
</body>
</html>