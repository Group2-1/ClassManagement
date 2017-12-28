package com.xmu.crms.view.vo;

public class Attendance {
    
	private Integer numPresent;
    
	private Integer numStudent;
    
	private String status;
    
	private String group;

	public Attendance(Integer numPresent, Integer numStudent, String status, String group) {
		super();
		this.numPresent = numPresent;
		this.numStudent = numStudent;
		this.status = status;
		this.group = group;
	}

	public Attendance() {
		// TODO Auto-generated constructor stub
	}

	public Integer getNumPresent() {
		return numPresent;
	}

	public void setNumPresent(Integer numPresent) {
		this.numPresent = numPresent;
	}

	public Integer getNumStudent() {
		return numStudent;
	}

	public void setNumStudent(Integer numStudent) {
		this.numStudent = numStudent;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

}
