package com.example.empleavemanager.service;

import java.io.Console;
import java.util.Iterator;
import java.util.List;
import java.util.logging.ConsoleHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.empleavemanager.model.Employee;
import com.example.empleavemanager.model.Leave;
import com.example.empleavemanager.repository.LeaveRepository;

@Service
public class LeaveService {
	
	@Autowired
	private LeaveRepository leaveRepository;
	@Autowired
	private EmployeeService employeeService;
	private List<Leave> l;
	private List<Leave> leaves;
	
	
	//create
	public Leave createLeave(Leave leave)
	{
		return leaveRepository.save(leave);
	}

	//retrieve all
	public List<Leave> getAllLeaves()
	{
		return leaveRepository.findAll();
	}
	
	//retrieve acc to empid
	public List<Leave> findLeavesByEmpid(String empid)
	{
		
		return leaveRepository.findLeavesByEmpid(empid);
	}
	
	//retrieve acc to leaveid
		public Leave findByLeaveid(String leaveid)
		{
			Leave l;
			try
			{
			 l=leaveRepository.findByLeaveid(leaveid);
			}
			catch(Exception e)
			{
				 l=new Leave(null,null,null,null,null,null, null, null);
				return l;
			}
			return l;
		}
	
		
		public List<Leave> findByStatus(String status)
		{
			return leaveRepository.findByStatus(status);
		}
		
	//retrieve leaves of emp under a certain manager
/*	public List<Leave> findLeavesByManagerid(String empid)
	{
		l = null;
		String managerid=empid;
		List <Employee> emp= employeeService.findByManagerid(managerid);
		Iterator<Employee> iterator = emp.iterator();
	      while(iterator.hasNext()) {
	    	  try {
	    	  Employee e=iterator.next();
	    	  empid=e.getEmpid();
	    	  leaves=leaveRepository.findLeavesByEmpid(empid);
	          l.addAll(leaves);
	      }
	    	  catch(NullPointerException e) {
	    		  continue;
	    	  }
	      }
		return l ;
	}
		*/
		
		public List<Leave> findLeavesByManagerid(String empid)
		{
			
			return leaveRepository.findByManagerid(empid);
		}
		
		public Leave acceptLeave(String leaveid)
		{
			Leave l=leaveRepository.findByLeaveid(leaveid);
			l.setStatus("Accepted");
			return leaveRepository.save(l); 
		}
		
		public Leave rejectLeave(String leaveid)
		{
			Leave l=leaveRepository.findByLeaveid(leaveid);
			l.setStatus("Rejected");
			return leaveRepository.save(l); 
		}
		
	//delete all
		public String deleteAll( )
		{
			leaveRepository.deleteAll();
			return("all leaves deleted");
		}
		
	//delete by id
		public Leave delete(String leaveid)
		{
			leaveRepository.deleteByLeaveid(leaveid);
			Leave l=new Leave(null,null,null,null,null,null, null, null);
			return l;
		}
		
		/*public Leave updateLeave(String leaveid,String fromdate, String todate, String type, String reason, String status) {
			Leave p = leaveRepository.findByLeaveid(leaveid);
			if(fromdate!=null)
				p.setFromdate(fromdate);
			if(todate!=null)
				p.setTodate(todate);
			if(reason!=null)
				p.setReason(reason);
			if(type!=null)
				p.setType(type);
			if(status!=null)
				p.setStatus(status);
			return leaveRepository.save(p);
			}
		*/
		

	//update leave
	public Leave updateLeave(Leave updatedleave) {
		Leave p = leaveRepository.findByLeaveid(updatedleave.getLeaveid());
		//p.setAppliedondate(updatedleave.getAppliedondate());
		p.setFromdate(updatedleave.getFromdate());
		p.setTodate(updatedleave.getTodate());
		p.setReason(updatedleave.getReason());
		p.setType(updatedleave.getType());
		return leaveRepository.save(p);
		}
}
