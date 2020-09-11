package com.hibernate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class EmployeeListServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		ArrayList employee = EmployeeData.getEmployees();
		HttpSession session = req.getSession(true);
		session.setAttribute("employee", employee);
		List empList = (List)session.getAttribute("employee");
		
		if (empList != null && empList.size() >0) {
			for (int i = 0; i < empList.size(); i++) {
				Employee emp = (Employee)empList.get(i);
				System.out.println(emp.getEmployeeId());
				System.out.println(emp.getName());
				System.out.println(emp.getage());
				System.out.println(emp.getSalary());
			}
		}
		RequestDispatcher rd = req.getRequestDispatcher("/EmployeeList.jsp");
		rd.forward(req, res);
	}
}
