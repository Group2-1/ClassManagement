package com.xmu.crms.view.vo;

import java.util.List;

import com.xmu.crms.entity.Class;
import com.xmu.crms.entity.Course;
import com.xmu.crms.entity.School;
import com.xmu.crms.entity.Topic;
import com.xmu.crms.entity.User;

public class MyData {
	
    public User user;

    public School school;

    public List<Course> courses;
    
    public List<Class> classes;
    
    private List<Topic> topics;

	public MyData(User user, School school, List<Course> courses, List<Class> classes, List<Topic> topics) {
		this.user = user;
		this.school = school;
		this.courses = courses;
		this.classes = classes;
		this.topics = topics;
	}
    

}