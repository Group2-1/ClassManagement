package com.xmu.crms.view.vo;

/**
 * 
 * @author qinlingyun
 *
 */
public class CourseClassVO {
	
	private Integer id;
	
	private String name;
	
	private Integer numStudent;
	
	private String time;
	
	private String site;
	
	private String courseName;
	
	private String courseTeacher;

	public CourseClassVO(int id, String name,Integer numStudent,String time,String site,String courseName,String courseTeacher) {
		this.id = id;
		this.name = name;
		this.numStudent = numStudent;
		this.time = time;
		this.site = site;
		this.courseName = courseName;
		this.courseTeacher = courseTeacher;
	}

	public CourseClassVO() {
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

	public String getCourseTeacher() {
		return courseTeacher;
	}

	public void setCourseTeacher(String courseTeacher) {
		this.courseTeacher = courseTeacher;
	}
	
    @Override
    public String toString() {
        return "CourseClassVO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", numStudent=" + numStudent +
                ", time='" + time + '\'' +
                ", site='" + site + '\'' +
                ", courseName='" + courseName + '\'' +
                ", courseTeacher='" + courseTeacher + 
                '}';
    }

}
