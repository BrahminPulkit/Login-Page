package com.hibernate;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "EMPLOYEE")
public class Employee implements Serializable 
{
	private static final long serialVersionUID = 1L;
@Id
	@Column(name = "Employee_ID")
	private int employeeId;
	
	@Column(name = "Name")
	private String name;
	
	@Column(name = "AGE")
	private int age;
	
	@Column(name = "SALARY")
	private double salary;
	
	public int getEmployeeId() {
		return employeeId;
	}
	public String getName() {
		return name;
	}
	public int getage() {
		return age;
	}
	public double getSalary() {
		return salary;
	}
	public void setEmployeeId(int employeeId) {
		 this.employeeId = employeeId;
	}
	public void setName(String name) {
		 this.name = name;
	}
	public void setage(int age) {
		this.age = age;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
}

