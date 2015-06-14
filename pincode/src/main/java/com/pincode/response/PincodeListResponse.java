package com.pincode.response;

import java.util.List;

import com.pincode.pojo.PincodePojo;

public class PincodeListResponse extends GenericResponse{

	private List<PincodePojo> pincodes ;

	public List<PincodePojo> getPincodes() {
		return pincodes;
	}

	public void setPincodes(List<PincodePojo> pincodes) {
		this.pincodes = pincodes;
	}
	
}
