package com.hibernate;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DeleteEmployeeServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		String employeeId = req.getParameter("employeeId");
		System.out.println("Employee Id to be deleted"+employeeId);
		try {
			EmployeeData.deleteEmployee(employeeId);
				ArrayList employees = EmployeeData.getEmployees();
				HttpSession session = req.getSession(true);
				session.setAttribute("employees", employees);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception caught in DeleteEmployeeServlet"+e);
		}
		RequestDispatcher rd = req.getRequestDispatcher("/EmployeeList.jsp");
		rd.forward(req, res);
	}
}
