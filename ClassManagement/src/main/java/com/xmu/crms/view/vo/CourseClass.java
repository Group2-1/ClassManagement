package com.xmu.crms.view.vo;

import com.xmu.crms.entity.Teacher;
/**
 * 
 * @author lingyun
 *
 */
public class CourseClass {
	
	private Integer id;
	
	private String name;
	
	private Integer numStudent;
	
	private String time;
	
	private String site;
	
	private String courseName;
	
	private Teacher courseTeacher;

	public CourseClass(int id, String name) {
		this.id = id;
		this.name = name;
		this.numStudent = null;
		this.time = null;
		this.site = null;
		this.courseName = name;
		this.courseTeacher = null;
	}
	public CourseClass(int id, String name,Integer numStudent,String time,String site,String courseName,Teacher courseTeacher) {
		this.id = id;
		this.name = name;
		this.numStudent = numStudent;
		this.time = time;
		this.site = site;
		this.courseName = courseName;
		this.courseTeacher = courseTeacher;
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

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
	public Integer getNumStudent() {
		return numStudent;
	}

	public void setNumStudent(Integer numStudent) {
		this.numStudent = numStudent;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Teacher getCourseTeacher() {
		return courseTeacher;
	}

	public void setCourseTeacher(Teacher courseTeacher) {
		this.courseTeacher = courseTeacher;
	}

}
