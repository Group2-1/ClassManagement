package com.xmu.crms.view.vo;

public class Status {
	
	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Status(String status) {
		this.status = status;
	}

	public Status() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Status [status=" + status + "]";
	}
	

}
