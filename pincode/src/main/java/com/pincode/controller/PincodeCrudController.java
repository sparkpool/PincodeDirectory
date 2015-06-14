package com.pincode.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pincode.pojo.PincodePojo;
import com.pincode.response.GenericResponse;
import com.pincode.service.IPincodeCrudService;
import com.pincode.util.JacksonUtil;

@Controller
@RequestMapping("/pincode")
public class PincodeCrudController {

	private static final Logger logger = Logger.getLogger(PincodeCrudController.class);
	
	@Autowired
	private IPincodeCrudService pincodeCrudService;

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseBody
	public String createNewPincode(PincodePojo pincodePojo){
		GenericResponse response = new GenericResponse();
		try{
			if(!pincodePojo.validate()){
				response.setError(true);
				response.setMessage("Enter All Mandatory Params");
			}else{
				
			}
		}catch(Exception e){
			logger.error("Exception occured : " + e.getMessage());
			response.setError(true);
			response.setMessage(e.getMessage());
		}
		return JacksonUtil.getResponseAsString(response);
	}
	
	public IPincodeCrudService getPincodeCrudService() {
		return pincodeCrudService;
	}
}
