package com.xmu.crms.view.vo;

import java.util.List;

import com.xmu.crms.entity.Class;
/**
 * 
 * @author lingyun
 *
 */
public class SeminarClasses {
	
	private Integer id;
	
	private String name;
	
	private String groupingMethod;
	
	private String startTime;
	
	private String endTime;
	
	private List<Class> classes;

	

	public SeminarClasses(Integer id, String name, String groupingMethod, String startTime, String endTime,
			List<Class> classes) {
		super();
		this.id = id;
		this.name = name;
		this.groupingMethod = groupingMethod;
		this.startTime = startTime;
		this.endTime = endTime;
		this.classes = classes;
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

	public List<Class> getClasses() {
		return classes;
	}

	public void setClasses(List<Class> classes) {
		this.classes = classes;
	}

}
