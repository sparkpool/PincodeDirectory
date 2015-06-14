package com.pincode.service.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pincode.domain.Pincode;
import com.pincode.exception.PincodeException;
import com.pincode.pojo.PincodePojo;
import com.pincode.service.IPincodeCrudService;

@Service
public class PincodeCrudServiceImpl implements IPincodeCrudService{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	@Override
	public void savePincode(PincodePojo pincodePojo) {
		Pincode pincode = getPincodeFromPojo(pincodePojo);
		Long id = (Long)getSessionFactory().getCurrentSession().save(pincode);
		if(id == null){
			throw new PincodeException("Something Wrong in saving Data, please try again after some time");
		}
	}

	private Pincode getPincodeFromPojo(PincodePojo pincodePojo){
		Pincode pincode = new Pincode();
		pincode.setCircle(pincodePojo.getCircle());
		pincode.setDistrict(pincodePojo.getDistrict());
		pincode.setDivision(pincodePojo.getDivision());
		pincode.setName(pincodePojo.getName());
		pincode.setPincode(pincodePojo.getPincode());
		pincode.setState(pincodePojo.getState());
		return pincode;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
}
