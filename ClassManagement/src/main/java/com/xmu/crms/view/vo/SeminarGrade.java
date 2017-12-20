package com.xmu.crms.view.vo;

import java.util.List;

public class SeminarGrade {
	
	private Integer reportGrade;
	
	private Integer grade;

	private List<PresentationGradeVO> presentationGrade;
	
	public SeminarGrade(Integer reportGrade, Integer grade, List<PresentationGradeVO> presentationGrade) {
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

	public List<PresentationGradeVO> getPresentationGrade() {
		return presentationGrade;
	}

	public void setPresentationGrade(List<PresentationGradeVO> presentationGrade) {
		this.presentationGrade = presentationGrade;
	}	
	
}
