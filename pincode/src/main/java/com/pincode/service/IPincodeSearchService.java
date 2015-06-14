package com.pincode.service;

import java.util.List;

import com.pincode.domain.Pincode;
import com.pincode.pojo.PincodePojo;

public interface IPincodeSearchService {

	public Pincode getPincodeByPincode(Integer pincode);
	public List<PincodePojo> getPincodeByDistrict(String district);
	public List<PincodePojo> getPincodeByState(String state);
	public List<PincodePojo> getPincodeByCircle(String circle);
	public PincodePojo getPincodePojoByPincode(Integer pincode);
}
