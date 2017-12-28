package com.xmu.crms.entity;

import java.util.List;

import com.xmu.crms.view.vo.SeminarGrade;

/**
 * group
 * @author lingyun
 *
 */
public class Group {
	
	private Integer id;
	
	private String name;
	
	private User leader;
	
	private List<User> members;
	
	private List<Topic> topics;
	
	private String report;
	
	private SeminarGrade grade;
    
	private Seminar seminar;

	public Group(Integer id, String name, User leader, List<User> members, List<Topic> topics, String report,
			SeminarGrade grade, Seminar seminar) {
		super();
		this.id = id;
		this.name = name;
		this.leader = leader;
		this.members = members;
		this.topics = topics;
		this.report = report;
		this.grade = grade;
		this.seminar = seminar;
	}
/*
	public Group(int id, User leader, List<User> members) {
		this.id = id;
		this.leader = leader;
		this.members = members;

	}
*/
	public Group() {
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

	public User getLeader() {
		return leader;
	}

	public void setLeader(User leader) {
		this.leader = leader;
	}

	public List<User> getMembers() {
		return members;
	}

	public void setMembers(List<User> members) {
		this.members = members;
	}

	public List<Topic> getTopics() {
		return topics;
	}

	public void setTopics(List<Topic> topic) {
		this.topics = topic;
	}

	public String getReport() {
		return report;
	}

	public void setReport(String report) {
		this.report = report;
	}

	public SeminarGrade getGrade() {
		return grade;
	}

	public void setGrade(SeminarGrade grade) {
		this.grade = grade;
	}
	public Seminar getSeminar() {
		return seminar;
	}
	public void setSeminar(Seminar seminar) {
		this.seminar = seminar;
	}

}
