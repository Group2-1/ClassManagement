package com.xmu.crms.entity;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class Data {

    public User user;

    public School school;

    public List<Course> courses;
    
    public List<Class> classes;
    
    private List<Topic> topics;

}