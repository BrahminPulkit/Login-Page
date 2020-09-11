package com.hibernate;

import java.util.ArrayList;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Transaction;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class EmployeeData {
	
	public static Employee getEmployee(String employeeId)throws Exception {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Employee employee = null;
		ArrayList<Employee> employees = null;
		session.beginTransaction();
		employee = (Employee)session.get(Employee.class, new Integer(employeeId));
		return employee;
	}
	
	public static ArrayList getEmployees() {
		ArrayList<Employee> employees = null;
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction =  session.beginTransaction();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Employee> query = builder.createQuery(Employee.class);
			Root<Employee> root = query.from(Employee.class);
			query.select(root);
			Query<Employee> q = session.createQuery(query);
			employees = (ArrayList<Employee>) q.getResultList();
			for (Employee employee : employees) {
				System.out.println(employee.getName());
			}
			transaction.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
		}
		return employees;
	}
	public void addEmployee(Employee emp) throws Exception{
		Employee employee = null;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			
			//Add new Employee object
			employee = new Employee();
			employee.setEmployeeId(emp.getEmployeeId());
			employee.setName(emp.getName());
			employee.setage(emp.getage());
			
			// save the employee  in data base
			session.save(employee);
			session.getTransaction().commit();
		} catch (Exception ex) {
			// TODO: handle exception
			System.out.println("Exception is "+ex);
		}
	}
	public static void deleteEmployee(String employeeId) throws Exception {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Object o = session.load(Employee.class, new Integer(employeeId));
			Employee emp =  (Employee)o;
			session.beginTransaction();
			session.delete(emp);
			session.getTransaction().commit();
			session.close();
		} catch (Exception ex) {
			// TODO: handle exception
			System.out.println("Exception is"+ex.getMessage());
		}
	}
	public void editEmployee(Employee emp) throws Exception{
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			//Add new Employee
			int employeeId = emp.getEmployeeId();
			Employee employee = (Employee)session.get(Employee.class, employeeId);
			employee.setName(emp.getName());
			employee.setage(emp.getage());
			employee.setSalary(emp.getSalary());
		} catch (Exception ex) {
			// TODO: handle exception
			System.out.println("Exception is" + ex);
		}
	}

}
