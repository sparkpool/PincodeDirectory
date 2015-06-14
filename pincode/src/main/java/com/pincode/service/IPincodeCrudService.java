package com.pincode.service;

import com.pincode.pojo.PincodePojo;

public interface IPincodeCrudService {

	public void savePincode(PincodePojo pincodePojo);
	public void deletePincode(Integer pincode);
}
