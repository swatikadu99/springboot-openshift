package com.example.empleavemanager.controller;

import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import com.example.empleavemanager.model.Employee;
import com.example.empleavemanager.service.EmployeeService;

@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RestController
public class EmployeeController {
	
	
	private static Logger logger = LoggerFactory.getLogger(EmployeeController.class); 
	
	@Autowired
	private EmployeeService employeeService;
	@PostMapping("/createEmp")
	public String create(@RequestParam String empid,@RequestParam String username,@RequestParam String password,@RequestParam String name, @RequestParam String role,@RequestParam String dept, @RequestParam String managerid) {
		Employee p = employeeService.create(empid,username,password,name,role, dept, managerid);
		return p.toString();
	}
	
	
	@GetMapping("/getAll")
	public List<Employee> getAll(){
		String response= "/getAll - &gt"+ new Date();
		logger.info(response);
		return employeeService.getAll();
	}
	
	@GetMapping("/findByManagerid/{managerid}")
	public List<Employee> findByManagerid(@PathVariable("managerid") String managerid)
	{
		String response= "/findByManagerid/"+managerid+" "+ new Date();
		logger.info(response);
		return employeeService.findByManagerid(managerid); 
	}
	@GetMapping("/findByEmpid/{empid}")
	public Employee findByEmpid(@PathVariable("empid") String empid)
	{
		String response= "/findByEmpid/"+empid+" "+ new Date();
		logger.info(response);
		return employeeService.findByEmpid(empid); 
	}
	@RequestMapping("login/{username}/{password}/{role}")
	public Employee findByUsername(@PathVariable("username") String username,@PathVariable("password") String password,@PathVariable("role") String role)
	{
		String response= "/login/ "+ new Date();
		logger.info(response);
		return employeeService.findByUsername(username, password, role);
	}
	@DeleteMapping("/deleteAllEmployee")
	public String deleteAll()
	{
		String response= "/deleteAllEmployee "+ new Date();
		logger.info(response);
		String s=employeeService.deleteAllEmployee();
		return s;
	}
}
