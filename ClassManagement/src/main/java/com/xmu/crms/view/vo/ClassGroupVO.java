package com.xmu.crms.view.vo;

import java.util.List;

import com.xmu.crms.entity.User;
/**
 * 
 * @author lingyun
 *
 */
public class ClassGroupVO {
	
	private Integer id;
	
	private User leader;
	
	private List<User> members;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
	
    @Override
    public String toString() {
        return "ClassGroupVO{" +
                "id=" + id +
                ", leader=" + leader +
                ", members=" + members +
                '}';
    }

}
