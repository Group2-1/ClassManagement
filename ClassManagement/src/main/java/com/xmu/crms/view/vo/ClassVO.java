package com.xmu.crms.view.vo;

public class ClassVO {
	
    private Integer id;

    private String name;

    private String teacher;

    private String site;

    private CourseClassVO course;

    public ClassVO(Integer id, String name, String teacher, String site, CourseClassVO course) {

        this.id = id;

        this.name = name;

        this.teacher = teacher;

        this.site = site;

        this.course = course;

    }

    @Override
    public String toString() {

        return "ClassVO{" +

                "id=" + id +

                ", name='" + name + '\'' +

                ", teacher'" + teacher + '\''+

                ", site='" + site + '\'' +

                ", course=" + course +

                '}';

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



	public String getTeacher() {
		return teacher;
	}



	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}



	public String getSite() {
		return site;
	}



	public void setSite(String site) {
		this.site = site;
	}



	public CourseClassVO getCourse() {
		return course;
	}



	public void setCourse(CourseClassVO course) {
		this.course = course;
	}
    
    
}
