package com.hibernate;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class EditEmployeeServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		
		String employeeId = req.getParameter("employeeId");
			String name = req.getParameter("name");
			String age = req.getParameter("age");
			String salary = req.getParameter("salary");
			Employee emp = new Employee();
			EmployeeData empldata = new EmployeeData();
			
			try {
				emp.setEmployeeId(Integer.parseInt(employeeId));
				emp.setName(name);
				emp.setage(Integer.parseInt(age));
				emp.setSalary(Double.parseDouble(salary));
				
				empldata.editEmployee(emp);
				ArrayList employee = EmployeeData.getEmployees();
				HttpSession session = req.getSession(true);
				session.setAttribute("employee", employee);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Exception caught in EditEmployeeServlet"+e);
			}
			RequestDispatcher rd = req.getRequestDispatcher("/EmployeeList.jsp");
			rd.forward(req, res);
	}

}

