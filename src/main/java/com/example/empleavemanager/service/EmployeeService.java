package com.example.empleavemanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.empleavemanager.model.Employee;
import com.example.empleavemanager.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public Employee create(String empid,String username, String password,String name,String role,String dept, String managerid)
	{
		return employeeRepository.save(new Employee(empid ,username, password,name,role, dept, managerid));
	}
	//Retrieve operation
	public List<Employee> getAll(){
		return employeeRepository.findAll();
	}
	public List<Employee> findByManagerid(String managerid)
	{
		return employeeRepository.findByManagerid(managerid);
	}
	
	public Employee findByEmpid(String empid)
	{
		return employeeRepository.findByEmpid(empid);
	}
	public Employee findByUsername(String username, String password, String role)
	{
		try
		{
		Employee e= employeeRepository.findByUsername(username);
		if(e.getPassword().trim().equals(password) && e.getRole().equals(role) )
			return e;
		}
		catch(Exception e)
		{
			return new Employee(null,null,null,null,null,null,null);
		}
		return new Employee(null,null,null,null,null,null,null);	
	}
	
	public String deleteAllEmployee()
	{
		employeeRepository.deleteAll();
		return("all employees deleted");
	}
	
}
