package com.pincode.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pincode.pojo.PincodePojo;
import com.pincode.response.PincodeListResponse;
import com.pincode.response.PincodeResponse;
import com.pincode.service.IPincodeSearchService;
import com.pincode.util.JacksonUtil;

@Controller
@RequestMapping("/search")
public class PincodeSearchController {

	private static final Logger logger = Logger
			.getLogger(PincodeSearchController.class);

	@Autowired
	private IPincodeSearchService pincodeSearchService;

	public IPincodeSearchService getPincodeSearchService() {
		return pincodeSearchService;
	}

	@RequestMapping(value = "/pincode/{pincode}", method = RequestMethod.GET)
	@ResponseBody
	public String getPincodeByPincode(@PathVariable("pincode") Integer pincode) {
		PincodeResponse pincodeResponse = new PincodeResponse();
		try {
			PincodePojo pincodePojo = getPincodeSearchService()
					.getPincodePojoByPincode(pincode);
			pincodeResponse.setPincodePojo(pincodePojo);
		} catch (Exception e) {
			logger.error("Exception occured : " + e.getMessage());
			pincodeResponse.setMessage(e.getMessage());
			pincodeResponse.setError(true);
		}
		return JacksonUtil.getResponseAsString(pincodeResponse);
	}

	@RequestMapping(value = "/district/{district}", method = RequestMethod.GET)
	@ResponseBody
	public String getPincodesByDistrict(
			@PathVariable("district") String district) {
		PincodeListResponse pincodeResponse = new PincodeListResponse();
		try {
			List<PincodePojo> pincodePojoList = getPincodeSearchService()
					.getPincodeByDistrict(district);
			pincodeResponse.setPincodes(pincodePojoList);
		} catch (Exception e) {
			logger.error("Exception occured : " + e.getMessage());
			pincodeResponse.setMessage(e.getMessage());
			pincodeResponse.setError(true);
		}
		return JacksonUtil.getResponseAsString(pincodeResponse);
	}

	@RequestMapping(value = "/circle/{circle}", method = RequestMethod.GET)
	@ResponseBody
	public String getPincodesByCircle(@PathVariable("circle") String circle) {
		PincodeListResponse pincodeResponse = new PincodeListResponse();
		try {
			List<PincodePojo> pincodePojoList = getPincodeSearchService()
					.getPincodeByCircle(circle);
			pincodeResponse.setPincodes(pincodePojoList);
		} catch (Exception e) {
			logger.error("Exception occured : " + e.getMessage());
			pincodeResponse.setMessage(e.getMessage());
			pincodeResponse.setError(true);
		}
		return JacksonUtil.getResponseAsString(pincodeResponse);
	}

	@RequestMapping(value = "/state/{state}", method = RequestMethod.GET)
	@ResponseBody
	public String getPincodesByState(@PathVariable("state") String state) {
		PincodeListResponse pincodeResponse = new PincodeListResponse();
		try {
			List<PincodePojo> pincodePojoList = getPincodeSearchService()
					.getPincodeByState(state);
			pincodeResponse.setPincodes(pincodePojoList);
		} catch (Exception e) {
			logger.error("Exception occured : " + e.getMessage());
			pincodeResponse.setMessage(e.getMessage());
			pincodeResponse.setError(true);
		}
		return JacksonUtil.getResponseAsString(pincodeResponse);
	}
}
