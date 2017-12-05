package com.xmu.crms.view.vo;

import java.util.List;

import com.xmu.crms.entity.Class;
/**
 * 
 * @author lingyun
 *
 */
public class SeminarClasses {
	
	private Integer id;
	
	private String name;
	
	private String courseName;
	
	private String startTime;
	
	private String endTime;
	
	private List<Class> classes;/*？？？？？？？？？？？？？？？*/

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

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
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

	public List<Class> getClasses() {
		return classes;
	}

	public void setClasses(List<Class> classes) {
		this.classes = classes;
	}

}
