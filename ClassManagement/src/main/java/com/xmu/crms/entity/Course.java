package com.xmu.crms.entity;
/**
 * course entity
 * @author lingyun
 *
 */
public class Course {
	
	private Integer id;
	
	private String name;
	
	private Integer numClass;
	
	private Integer numStudent;
	
	private String startTime;
	
	private String endTime;
	
	private String description;
	
	private Proportions proportions;

	public Course(int id, String name, int numClass, int numStudent, 
			String startTime, String endTime) {
		this.id = id;
		this.name = name;
		this.numClass = numClass;
		this.numStudent = numStudent;
		this.startTime = startTime;
		this.endTime = endTime;
		this.description = null;
		this.proportions = null;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getNumClass() {
		return numClass;
	}

	public void setNumClass(Integer numClass) {
		this.numClass = numClass;
	}

	public Integer getNumStudent() {
		return numStudent;
	}

	public void setNumStudent(Integer numStudent) {
		this.numStudent = numStudent;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Proportions getProportions() {
		return proportions;
	}

	public void setProportions(Proportions proportions) {
		this.proportions = proportions;
	}
	

}
