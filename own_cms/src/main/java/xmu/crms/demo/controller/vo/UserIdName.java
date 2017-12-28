package xmu.crms.demo.controller.vo;

import java.math.BigInteger;

import xmu.crms.demo.entity.User;
/**
 * 
 * @author lingyun
 *
 */
public class UserIdName {
	
	private BigInteger id;
	
	private String name;

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

	public UserIdName() {
		super();
	}

	public UserIdName(User user) {
		// TODO Auto-generated constructor stub
		this.id = user.getId();
		this.name = user.getName();
	}

	@Override
	public String toString() {
		return "UserIdName [id=" + id + ", name=" + name + "]";
	}
	

}
