package com.xmu.crms.view.vo;
/**
 * courseClass
 * @author lingyun
 *
 */
public class CourseDetail {
	
	private Integer id;
	
	private String name;
	
	private String description;
	
	private String teacherName;
	
	private String teacherEmail;

	public CourseDetail(Integer id, String name, String description, String teacherName, String teacherEmail) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.teacherName = teacherName;
		this.teacherEmail = teacherEmail;
	}

	public CourseDetail() {
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

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getTeacherEmail() {
		return teacherEmail;
	}

	public void setTeacherEmail(String teacherEmail) {
		this.teacherEmail = teacherEmail;
	}

	@Override
	public String toString() {
		return "CourseDetail [id=" + id + 
				", name=" + name + 
				", description=" + description + 
				", teacherName="+ teacherName + 
				", teacherEmail=" + teacherEmail + 
				"]";
	}
	
}
