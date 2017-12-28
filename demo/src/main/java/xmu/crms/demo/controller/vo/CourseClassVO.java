package xmu.crms.demo.controller.vo;

import java.math.BigInteger;

import xmu.crms.demo.entity.ClassInfo;

/**
 * 
 * @author lingyun
 *
 */
public class CourseClassVO {
	
	private BigInteger id;
	
	private String name;
	
	private String time;
	
	private String site;
	
	private String courseName;
	
	private String courseTeacher;

	public CourseClassVO(BigInteger id, String name,String time,String site,String courseName,String courseTeacher) {
		this.id = id;
		this.name = name;
		this.time = time;
		this.site = site;
		this.courseName = courseName;
		this.courseTeacher = courseTeacher;
	}

	public CourseClassVO() {
		// TODO Auto-generated constructor stub
	}

	public CourseClassVO(ClassInfo classInfo) {
		// TODO Auto-generated constructor stub
		this.id = classInfo.getId();
		this.name = classInfo.getName();
		this.time = classInfo.getClassTime();
		this.site = classInfo.getSite();
	}

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
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
                ", time='" + time + '\'' +
                ", site='" + site + '\'' +
                ", courseName='" + courseName + '\'' +
                ", courseTeacher='" + courseTeacher + 
                '}';
    }

}

