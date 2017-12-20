package com.xmu.crms.entity;
/**
 * 
 * @author lingyun
 *
 */
public class School {
	
	private Integer id;
	
	private String name;
	
	private String province;
	
	private String city;

	public School(int id, String name, String province, String city) {
		
		this.id = id;
		this.name = name;
		this.province = province;
		this.city = city;
	}

	public School() {
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

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
