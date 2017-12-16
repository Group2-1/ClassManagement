package com.xmu.crms.entity;

import java.util.List;

/**
 * seminar entity
 * @author lingyun
 *
 */
public class Seminar {
	
	private Integer id;
	
	private String name;
	
	private String description;
	
	private String groupingMethod;
	
	private String startTime;
	
	private String endTime;
	
	List<Topic> topics; 

	List<Proportions> proportions;

	public Seminar(Integer id, String name, String description, String groupingMethod, String startTime, String endTime) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.groupingMethod = groupingMethod;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public Seminar() {
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getGroupingMethod() {
		return groupingMethod;
	}

	public void setGroupingMethod(String groupingMethod) {
		this.groupingMethod = groupingMethod;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public List<Topic> getTopics() {
		return topics;
	}

	public void setTopics(List<Topic> topics) {
		this.topics = topics;
	}

	public List<Proportions> getProportions() {
		return proportions;
	}

	public void setProportions(List<Proportions> proportions) {
		this.proportions = proportions;
	}

}
