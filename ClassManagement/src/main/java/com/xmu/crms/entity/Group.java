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
	
	private Topic topic;
	
	private String report;
	
	private SeminarGrade grade;

	public Group(int id, User leader, List<User> members, Topic topic, String report) {
		this.id = id;
		this.leader = leader;
		this.members = members;
		this.topic = topic;
		this.report = report;
		
	}

	public Group(int id, User leader, List<User> members) {
		this.id = id;
		this.leader = leader;
		this.members = members;

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

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
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

}
