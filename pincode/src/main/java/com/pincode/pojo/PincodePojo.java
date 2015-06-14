package com.pincode.pojo;

import org.apache.commons.lang.StringUtils;

public class PincodePojo {

	private Integer pincode;
	private String circle;
	private String district;
	private String state;
	private String division;
	private String name;

	public boolean validate(){
		if(StringUtils.isBlank(circle) || StringUtils.isBlank(district) ||
				StringUtils.isBlank(state) || StringUtils.isBlank(division) || 
				StringUtils.isBlank(name) || pincode == null){
			return false;
		}
		return true;
	}
	
	public Integer getPincode() {
		return pincode;
	}
	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}
	public String getCircle() {
		return circle;
	}
	public void setCircle(String circle) {
		this.circle = circle;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
