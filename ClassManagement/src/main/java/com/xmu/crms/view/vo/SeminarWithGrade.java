package com.xmu.crms.view.vo;

import java.util.Date;

import com.xmu.crms.entity.Seminar;

public class SeminarWithGrade {
	
    private Integer id;
    
    private String name;
    
    private String description;
    
    private String groupingMethod;
    
    private Date startTime;
    
    private Date endTime;
    
    private Integer grade;

	public SeminarWithGrade(Integer id, String name, String description, String groupingMethod, Date startTime,
			Date endTime, Integer grade) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.groupingMethod = groupingMethod;
		this.startTime = startTime;
		this.endTime = endTime;
		this.grade = grade;
	}

	public SeminarWithGrade(Seminar seminar1, int i) {
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getGroupingMethod() {
		return groupingMethod;
	}

	public void setGroupingMethod(String groupingMethod) {
		this.groupingMethod = groupingMethod;
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

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "SeminarWithGrade [id=" + id + ", name=" + name + ", description=" + description + ", groupingMethod="
				+ groupingMethod + ", startTime=" + startTime + ", endTime=" + endTime + ", grade=" + grade + "]";
	}

}
