package com.xmu.crms.view.vo;

import java.util.Date;

/**
 * 
 * @author lingyun
 *
 */
public class StudentSeminar {

	private Integer id;
	
	private String name;
	
	private String groupingMethod;
	
	private String courseName;
	
	private Date startTime;
	
	private Date endTime;	
	
	private Integer classCalling;
	
	private Boolean isLeader;
	
	private Boolean areTopicsSelected;

	public StudentSeminar(Integer id, String name, String groupingMethod, String courseName, Date startTime,
			Date endTime, Integer classCalling, Boolean isLeader, Boolean areTopicsSelected) {
		super();
		this.id = id;
		this.name = name;
		this.groupingMethod = groupingMethod;
		this.courseName = courseName;
		this.startTime = startTime;
		this.endTime = endTime;
		this.classCalling = classCalling;
		this.isLeader = isLeader;
		this.areTopicsSelected = areTopicsSelected;
	}

	public StudentSeminar() {
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

	public String getGroupingMethod() {
		return groupingMethod;
	}

	public void setGroupingMethod(String groupingMethod) {
		this.groupingMethod = groupingMethod;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
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

	public Integer getClassCalling() {
		return classCalling;
	}

	public void setClassCalling(Integer classCalling) {
		this.classCalling = classCalling;
	}

	public Boolean getIsLeader() {
		return isLeader;
	}

	public void setIsLeader(Boolean isLeader) {
		this.isLeader = isLeader;
	}

	public Boolean getAreTopicsSelected() {
		return areTopicsSelected;
	}

	public void setAreTopicsSelected(Boolean areTopicsSelected) {
		this.areTopicsSelected = areTopicsSelected;
	}

	@Override
	public String toString() {
		return "StudentSeminar [id=" + id + 
				", name=" + name + 
				", groupingMethod=" + groupingMethod + 
				", courseName=" + courseName + 
				", startTime=" + startTime + 
				", endTime=" + endTime + 
				", classCalling=" + classCalling + 
				", isLeader=" + isLeader + 
				", areTopicsSelected=" + areTopicsSelected + 
				"]";
	}
	
}
