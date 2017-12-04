package com.xmu.crms.entity;
/**
 * topic entity
 * @author lingyun
 *
 */
public class Topic {
	
	private Integer id;
	private String serial;	
	private String name;	
	private String description;	
	private Integer groupLimit;	
	private Integer groupMemberLimit;	
	private Integer groupLeft;

	public Topic(Integer id, String serial, String name, String description, Integer groupLimit, Integer groupMemberLimit, Integer groupLeft) {
		this.id = id;
		this.serial = serial;
		this.name = name;
		this.description = description;
		this.groupLimit = groupLimit;
		this.groupMemberLimit = groupMemberLimit;
		this.groupLeft = groupLeft;
		
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getGroupLimit() {
		return groupLimit;
	}

	public void setGroupLimit(Integer groupLimit) {
		this.groupLimit = groupLimit;
	}

	public Integer getGroupMemberLimit() {
		return groupMemberLimit;
	}

	public void setGroupMemberLimit(Integer groupMemberLimit) {
		this.groupMemberLimit = groupMemberLimit;
	}

	public Integer getGroupLeft() {
		return groupLeft;
	}

	public void setGroupLeft(Integer groupLeft) {
		this.groupLeft = groupLeft;
	}

}
