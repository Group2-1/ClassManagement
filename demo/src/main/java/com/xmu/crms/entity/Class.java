package com.xmu.crms.entity;

/**
 * class entity
 * @author lingyun
 * 
 */
public class Class {
	
	private Integer id;
	
	private String name;
	
	private Integer numStudent;
	
	private String time;
	
	private String site;
	
	private Integer calling;
	
	private String roster;	
	
	private Proportions proportions;
	
	public Class(int id, String name, Integer numStudent, String time, String site, Integer calling, String roster, Proportions proportions) {
		this.id = id;
		this.name = name;
		this.numStudent = numStudent;
		this.time = time;
		this.site = site;
		this.calling = calling;
		this.roster = roster;
		this.proportions = proportions;
	}

	public Class() {
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

	public Integer getNumStudent() {
		return numStudent;
	}

	public void setNumStudent(Integer numStudent) {
		this.numStudent = numStudent;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public Integer getCalling() {
		return calling;
	}

	public void setCalling(Integer calling) {
		this.calling = calling;
	}

	public String getRoster() {
		return roster;
	}

	public void setRoster(String roster) {
		this.roster = roster;
	}

	public Proportions getProportions() {
		return proportions;
	}

	public void setProportions(Proportions proportions) {
		this.proportions = proportions;
	}

}
