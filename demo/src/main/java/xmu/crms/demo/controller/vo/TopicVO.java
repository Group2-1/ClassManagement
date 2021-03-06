package xmu.crms.demo.controller.vo;

import java.math.BigInteger;
/**
 * 
 * @author lingyun
 *
 */
public class TopicVO {
	
	private BigInteger id;
	
	private String name;
	
	private String serial;
	
	private String description;
	
    private Integer groupLimit;
    
    private Integer groupMemberLimit;
    
    private Integer groupLeft;
	
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

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
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

	public TopicVO() {
		super();
	}

	@Override
	public String toString() {
		return "TopicVO [id=" + id + ", name=" + name + ", serial=" + serial + ", description=" + description
				+ ", groupLimit=" + groupLimit + ", groupMemberLimit=" + groupMemberLimit + ", groupLeft=" + groupLeft
				+ "]";
	}




}
