package com.example.empleavemanager.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.empleavemanager.model.Employee;

@CrossOrigin(origins = "http://localhost:4200")
@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String> {
	public Employee findByName(String Name);
	public Employee findByEmpid(String empid);
	public Employee findByUsername(String username);
	public List<Employee> findByManagerid(String managerid);
}
