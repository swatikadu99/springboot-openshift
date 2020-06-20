package com.example.empleavemanager.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.empleavemanager.model.Leave;

@Repository()
public interface LeaveRepository extends MongoRepository<Leave, String> {
	public List<Leave> findLeavesByEmpid(String empid);
	public Leave findByLeaveid(String leaveid);
	public List<Leave> findByStatus( String status);
	public void deleteByLeaveid(String leaveid);
	public List<Leave>findByManagerid(String managerid);
	//public List<Leave> findLeavesByManagerid(String empid)
}

