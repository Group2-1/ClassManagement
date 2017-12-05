package com.xmu.crms.entity;
/**
 * 
 * @author lingyun
 *
 */
public class Proportions {

	private int threepercent;

	private int fourpercent;

	private int fivepercent;

	private int reportpercent;

	private int presentpercent;

	public Proportions(int threepercent, int fourpercent, int fivepercent, int reportpercent, int presentpercent) {
		this.threepercent = threepercent;
		this.fourpercent = fourpercent;
		this.fivepercent = fivepercent;
		this.reportpercent = reportpercent;
		this.presentpercent = presentpercent;
	}

	public int getThreepercent() {

		return threepercent;

	}

	public void setThreepercent(int threepercent) {

		this.threepercent = threepercent;

	}

	public int getFourpercent() {

		return fourpercent;

	}

	public void setFourpercent(int fourpercent) {

		this.fourpercent = fourpercent;

	}

	public int getFivepercent() {

		return fivepercent;

	}

	public void setFivepercent(int fivepercent) {

		this.fivepercent = fivepercent;

	}

	public int getReportpercent() {

		return reportpercent;

	}

	public void setReportpercent(int reportpercent) {

		this.reportpercent = reportpercent;

	}

	public int getPresentpercent() {

		return presentpercent;

	}

	public void setPresentpercent(int presentpercent) {

		this.presentpercent = presentpercent;

	}

}
