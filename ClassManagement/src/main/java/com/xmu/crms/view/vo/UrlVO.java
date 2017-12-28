package com.xmu.crms.view.vo;

public class UrlVO {

    private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public UrlVO(String url) {
		super();
		this.url = url;
	}

	public UrlVO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "UrlVO [url=" + url + "]";
	}
    
}
