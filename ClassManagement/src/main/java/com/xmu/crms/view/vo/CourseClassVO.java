package com.xmu.crms.view.vo;

public class CourseClassVO {
	
    private Integer id;

    private String name;

    private Integer lessonsPerWeek;

    public CourseClassVO(Integer id, String name, Integer lessonsPerWeek) {
        this.id = id;
        this.name = name;
        this.lessonsPerWeek = lessonsPerWeek;

    }

    @Override
    public String toString() {
        return "CourseClassVO {" +

                "id=" + id +

                ", name='" + name + '\'' +

                ", lessonsPerWeek=" + lessonsPerWeek +

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

    public Integer getLessonsPerWeek() {
        return lessonsPerWeek;
    }

    public void setLessonsPerWeek(Integer lessonsPerWeek) {
        this.lessonsPerWeek = lessonsPerWeek;
    }

}

