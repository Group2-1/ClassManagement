package com.xmu.crms.view.vo;

import java.math.BigInteger;

/**
 * @author CaoXingMei
 * @date 2017-12-5
 */

public class SchoolVO {
	private BigInteger id;
	private String name;
	private String province;
	private String city;

	public SchoolVO(){}

	public SchoolVO(String province)
	{
		super();
		this.province = province;
	}

	public SchoolVO(BigInteger id, String name) {
		this.id = id;
		this.name = name;
	}

	public SchoolVO(BigInteger id, String name, String province, String city) {
		super();
		this.id = id;
		this.name = name;
		this.province = province;
		this.city = city;
	}

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
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
