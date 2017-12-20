package com.xmu.crms.entity;

import java.util.Date;

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
	
	private Date startTime;
	
	private Date endTime;
	
	private String description;
	
	private Proportions proportions;

	public Course(Integer id, String name, Integer numClass, Integer numStudent, Date startTime, Date endTime,
			String description, Proportions proportions) {
		super();
		this.id = id;
		this.name = name;
		this.numClass = numClass;
		this.numStudent = numStudent;
		this.startTime = startTime;
		this.endTime = endTime;
		this.description = description;
		this.proportions = proportions;
	}

	public Course() {
		// TODO Auto-generated constructor stub
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

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
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
