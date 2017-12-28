package com.xmu.crms.entity;
/**
 * 
 * @author lingyun
 *
 */
public class Proportions {

	private int A;

	private int B;

	private int C;

	private int report;

	private int presentation;

	public Proportions(int threepercent, int fourpercent, int fivepercent, int reportpercent, int presentpercent) {
		this.A = threepercent;
		this.B = fourpercent;
		this.C = fivepercent;
		this.report = reportpercent;
		this.presentation = presentpercent;
	}

	public Proportions() {
		// TODO Auto-generated constructor stub
	}

	public int getA() {
		return A;
	}

	public void setA(int a) {
		A = a;
	}

	public int getB() {
		return B;
	}

	public void setB(int b) {
		B = b;
	}

	public int getC() {
		return C;
	}

	public void setC(int c) {
		C = c;
	}

	public int getReport() {
		return report;
	}

	public void setReport(int report) {
		this.report = report;
	}

	public int getPresentation() {
		return presentation;
	}

	public void setPresentation(int presentation) {
		this.presentation = presentation;
	}



}
