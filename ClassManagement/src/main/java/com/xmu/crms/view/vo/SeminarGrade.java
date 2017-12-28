package com.xmu.crms.view.vo;

import java.util.List;

public class SeminarGrade {
	
	private Integer reportGrade;
	
	private Integer grade;

	private List<PresentationGrade> presentationGrade;
	
	public SeminarGrade(Integer reportGrade, Integer grade, List<PresentationGrade> presentationGrade) {
		this.reportGrade = reportGrade;
		this.grade = grade;
		this.presentationGrade = presentationGrade;
	}	
	
	public SeminarGrade() {
		// TODO Auto-generated constructor stub
	}

	public Integer getReportGrade() {
		return reportGrade;
	}

	public void setReportGrade(Integer reportGrade) {
		this.reportGrade = reportGrade;
	}

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public List<PresentationGrade> getPresentationGrade() {
		return presentationGrade;
	}

	public void setPresentationGrade(List<PresentationGrade> presentationGrade) {
		this.presentationGrade = presentationGrade;
	}	
	
}
