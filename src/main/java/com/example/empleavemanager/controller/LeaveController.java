package com.example.empleavemanager.controller;


import java.util.List;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import com.example.empleavemanager.model.Leave;
import com.example.empleavemanager.service.LeaveService;

@CrossOrigin (origins="http://localhost:4200", allowedHeaders = "*")
@RestController
public class LeaveController {
	
	private static Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private LeaveService leaveService;
	
	//create a leave
	@PostMapping("/createLeave")
	public String createLeave(@RequestBody Leave leave)
	{
		String response= "/createLeave "+ new Date();
		logger.info(response);
		Leave l= leaveService.createLeave(leave);
		return l.toString();
	}
	
	//get all the leaves
	@GetMapping("/getAllLeaves")
	public List<Leave> getAllLeaves()
	{
		String response= "/getAllLeaves "+ new Date();
		logger.info(response);
		return leaveService.getAllLeaves();
	}
	
	
	// get my leaves (acc to empid)
	@GetMapping("/findLeavesByEmpid/{empid}")
	public List<Leave> findLeavesByEmpid(@PathVariable("empid") String empid)
	{
		String response= "/findLeaveByEmpid "+empid+" "+new Date();
		logger.info(response);
		return leaveService.findLeavesByEmpid(empid);
	}
	
	//get a single leave
	@GetMapping("/findLeaveByLeaveid/{leaveid}")
	public Leave findByLeaveId(@PathVariable("leaveid") String leaveid)
	{
		String response= "/findLeaveByLeaveid "+leaveid+" "+ new Date();
		logger.info(response);
		return leaveService.findByLeaveid(leaveid);
	}
	
	//get leaves according to their status
	@GetMapping("/findLeaveByStatus/{status}")
	public List<Leave> findByStatus(@PathVariable("status") String status)
	{
		String response= "/findLeaveByStatus "+status+" "+ new Date();
		logger.info(response);
		return leaveService.findByStatus(status);
	}
		
	//update leave
	@PutMapping("/updateLeave")
	public Leave updateLeave(@RequestBody Leave updatedleave)
	{
		String response= "/updateLeave "+ new Date();
		logger.info(response);
		return leaveService.updateLeave(updatedleave);
	}
	
	@GetMapping("/getAllLeavesUnderaManager/{empid}")
	public List<Leave> findLeavesByManagerid(@PathVariable("empid") String empid)
	{
		String response= "/getAllLeavesUnderaManager/"+empid+" "+ new Date();
		logger.info(response);
		return leaveService.findLeavesByManagerid(empid);
	}
	
	@RequestMapping("/acceptLeave/{leaveid}")
	public Leave acceptLeave(@PathVariable("leaveid")String leaveid)
	{
		String response= "/acceptLeave/"+leaveid+" "+ new Date();
		logger.info(response);
		return leaveService.acceptLeave(leaveid);
	}
	
	@RequestMapping("/rejectLeave/{leaveid}")
	public Leave rejectLeave(@PathVariable("leaveid")String leaveid)
	{
		String response= "/rejectLeave/"+leaveid+" "+ new Date();
		logger.info(response);
		return leaveService.rejectLeave(leaveid);
	}
	
	//delete all
	@DeleteMapping("/deleteAll")
	public String deleteAll()
	{
		String response= "/deleteAll"+ new Date();
		logger.info(response);
		String s=leaveService.deleteAll();
		return s;
	}
	
	@CrossOrigin (origins="http://localhost:4200")
	@RequestMapping("/deleteByLeaveid/{leaveid}")
	public Leave delete(@PathVariable("leaveid") String leaveid )
	{
		String response= "/deleteByLeaveid/"+leaveid+" "+ new Date();
		logger.info(response);
		return leaveService.delete(leaveid);
	}
}
	
	
	

