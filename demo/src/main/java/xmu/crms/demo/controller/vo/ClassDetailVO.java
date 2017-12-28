package xmu.crms.demo.controller.vo;

import xmu.crms.demo.entity.ClassInfo;
/**
 * 
 * @author lingyun
 *
 */
public class ClassDetailVO {
	
	private Long id;
	
	private String name;
	
	private String site;
	
	private String time;
	
    //private String roster;
    
	private Integer reportPercentage;
	
	private Integer presentationPercentage;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Integer getReportPercentage() {
		return reportPercentage;
	}

	public void setReportPercentage(Integer reportPercentage) {
		this.reportPercentage = reportPercentage;
	}

	public Integer getPresentationPercentage() {
		return presentationPercentage;
	}

	public void setPresentationPercentage(Integer presentationPercentage) {
		this.presentationPercentage = presentationPercentage;
	}

	public ClassDetailVO() {
		super();
	}

	public ClassDetailVO(ClassInfo classInfo) {
		// TODO Auto-generated constructor stub
		this.id = classInfo.getId().longValue();
		this.name = classInfo.getName();
		this.time = classInfo.getClassTime();
		this.site = classInfo.getSite();
		this.presentationPercentage = classInfo.getPresentationPercentage();
		this.reportPercentage = classInfo.getReportPercentage();
	}

	@Override
	public String toString() {
		return "ClassDetailVO [id=" + id + ", name=" + name + ", site=" + site + ", time=" + time
				+ ", reportPercentage=" + reportPercentage + ", presentationPercentage=" + presentationPercentage + "]";
	}
	
	
	
	

}
