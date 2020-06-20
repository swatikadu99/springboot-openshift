package com.example.empleavemanager.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Employee {

	@Id
	String id;
	String empid;
	String username;
	String password;
	String name;
	String dept;
	String role;
	String managerid;
	

	
	public Employee(String empid, String username, String password, String name,String role, String dept, String managerid)
	{
		this.empid=empid;
		this.username=username;
		this.password=password;
		this.name=name;
		this.dept=dept;
		this.role=role;
		this.managerid=managerid;
	}
	

public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getManagerid() {
		return managerid;
	}

	public void setManagerid(String managerid) {
		this.managerid = managerid;
	}
	
	public String toString() {
		return "Employee  Name:"+name+" Dept:"+dept+" Manager:"+managerid+ "role "+role;
	}


	public String getEmpid() {
		return empid;
	}


	public void setEmpid(String empid) {
		this.empid = empid;
	}
}
