package com.xmu.crms.view.vo;

public class SeminarGrade {
	
	private Integer reportGrade;
	
	private Integer grade;

	private PresentationGrade[] presentationGrade;
	
	public SeminarGrade(Integer reportGrade, Integer grade, PresentationGrade[] presentationGrade) {
		this.reportGrade = reportGrade;
		this.grade = grade;
		this.setPresentationGrade(presentationGrade);
	}	
	
	public class PresentationGrade{
		
		private	Integer topicId;
		
		private	Integer grade;
		
		private PresentationGrade(Integer topicId, Integer grade) {
			
			this.topicId = topicId;
			this.grade = grade;
		}

		public Integer getTopicId() {
			return topicId;
		}

		public void setTopicId(Integer topicId) {
			this.topicId = topicId;
		}

		public Integer getGrade() {
			return grade;
		}

		public void setGrade(Integer grade) {
			this.grade = grade;
		}		
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

	public PresentationGrade[] getPresentationGrade() {
		return presentationGrade;
	}

	public void setPresentationGrade(PresentationGrade[] presentationGrade) {
		this.presentationGrade = presentationGrade;
	}	
	
}
