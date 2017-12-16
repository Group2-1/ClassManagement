package com.xmu.crms.view.vo;

public class SiteVO {
	
    private Double longitude;
   
    private Double latitude;
    
    private Double elevation;

	public SiteVO(Double longitude, Double latitude, Double elevation) {
		super();
		this.longitude = longitude;
		this.latitude = latitude;
		this.elevation = elevation;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getElevation() {
		return elevation;
	}

	public void setElevation(Double elevation) {
		this.elevation = elevation;
	}

	@Override
	public String toString() {
		return "SiteVO [" + 
				"longitude=" + longitude + 
				", latitude=" + latitude + 
				", elevation=" + elevation + 
				"]";
	}

}
