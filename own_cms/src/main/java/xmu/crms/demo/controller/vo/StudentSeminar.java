package xmu.crms.demo.controller.vo;

import java.util.Date;

/**
 * 
 * @author lingyun
 *
 */
public class StudentSeminar {
	private Long id;
	private String name;
	private String groupingMethod;
	private String courseName;
	private Date startTime;
	private Date endTime;
	private Integer classCalling;
	private Boolean isLeader;
	private Boolean areTopicSeleted;

	public StudentSeminar() {
		// TODO Auto-generated constructor stub
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
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
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public Integer getClassCalling() {
		return classCalling;
	}
	public void setClassCalling(Integer classCalling) {
		this.classCalling = classCalling;
	}
	public Boolean getIsLeader() {
		return isLeader;
	}
	public void setIsLeader(Boolean isLeader) {
		this.isLeader = isLeader;
	}
	public Boolean getAreTopicSeleted() {
		return areTopicSeleted;
	}
	public void setAreTopicSeleted(Boolean areTopicSeleted) {
		this.areTopicSeleted = areTopicSeleted;
	}
	@Override
	public String toString() {
		return "StudentSeminar [id=" + id + ", name=" + name + ", groupingMethod=" + groupingMethod + ", courseName="
				+ courseName + ", startTime=" + startTime + ", endTime=" + endTime + ", classCalling=" + classCalling
				+ ", isLeader=" + isLeader + ", areTopicSeleted=" + areTopicSeleted + "]";
	}
	
	

}
