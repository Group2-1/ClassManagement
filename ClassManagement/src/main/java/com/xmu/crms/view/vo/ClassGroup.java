package com.xmu.crms.view.vo;

import java.util.List;

import com.xmu.crms.entity.Student;
/**
 * 
 * @author lingyun
 *
 */
public class ClassGroup {
	
	private Student leader;
	
	private List<Student> members;

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

}
