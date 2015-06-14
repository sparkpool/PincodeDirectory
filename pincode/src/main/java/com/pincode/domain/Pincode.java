package com.pincode.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="PINCODE_DB",
uniqueConstraints = {
		@UniqueConstraint(columnNames = "PINCODE")
})
public class Pincode implements Serializable{

	private static final long serialVersionUID = 3237389300674046174L;

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name ="PINCODE", nullable = false)
	private Integer pincode;
	
	@Column(name = "CIRCLE", nullable = false)
	private String circle;
	
	@Column(name="DISTRICT", nullable = false)
	private String district;
	
	@Column(name="STATE", nullable = false)
	private String state;
	
	@Column(name="DIVISION", nullable = false)
	private String division;
	
	@Column(name="NAME", nullable = false)
	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
