package com.xmu.crms.entity;

import java.util.List;

import com.xmu.crms.view.vo.SeminarGrade;

/**
 * group
 * @author lingyun
 *
 */
public class Group {
	
	private String id;
	
	private String name;
	
	private Student leader;
	
	private List<Student> members;
	
	private List<Topic> topics;
	
	private String report;
	
	private SeminarGrade grade;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Student getLeader() {
		return leader;
	}

	public void setLeader(Student leader) {
		this.leader = leader;
	}

	public List<Student> getMembers() {
		return members;
	}

	public void setMembers(List<Student> members) {
		this.members = members;
	}

	public List<Topic> getTopics() {
		return topics;
	}

	public void setTopics(List<Topic> topics) {
		this.topics = topics;
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
