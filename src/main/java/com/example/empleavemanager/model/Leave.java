package com.example.empleavemanager.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Leave {

	
	@Id
	String Id;
	String leaveid;
	String empid;
	//String appliedondate;
	String fromdate;
	String todate;
	String type;
	String status;
	String reason;
	String managerid;
	
	public Leave(String leaveid,String empid, String managerid, String fromdate, String todate, String type,String reason, String status) {
		this.empid = empid;
		this.leaveid=leaveid;
		//this.appliedondate = appliedondate;
		this.fromdate = fromdate;
		this.todate = todate;
		this.type = type;
		this.reason = reason;
		this.status = status;
		this.managerid=managerid;
	}

	public String getManagerid() {
		return managerid;
	}

	public void setManagerid(String managerid) {
		this.managerid = managerid;
	}

	public String getLeaveid() {
		return leaveid;
	}

	public void setLeaveid(String leaveid) {
		this.leaveid = leaveid;
	}

	public String getEmpid() {
		return empid;
	}

	public void setEmpid(String empid) {
		this.empid = empid;
	}

	

	public String getFromdate() {
		return fromdate;
	}

	public void setFromdate(String fromdate) {
		this.fromdate = fromdate;
	}

	public String getTodate() {
		return todate;
	}
 
	public void setTodate(String todate) {
		this.todate = todate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	
	public String toString() {
		return "Leave [leaveid= "+leaveid+",empid=" + empid +  ", fromdate=" + fromdate + ", todate=" + todate + ", type=" + type + ", reason=" + reason + ", status=" + status + "]";
	}
	
	
	
}
