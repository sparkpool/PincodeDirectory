package com.pincode.service.impl;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pincode.domain.Pincode;
import com.pincode.exception.PincodeException;
import com.pincode.pojo.PincodePojo;
import com.pincode.service.IPincodeCrudService;
import com.pincode.service.IPincodeSearchService;

@Service
public class PincodeCrudServiceImpl implements IPincodeCrudService{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private IPincodeSearchService pincodeSearchService;
	
	@Transactional
	@Override
	public void savePincode(PincodePojo pincodePojo) {
		Pincode pincode = getPincodeSearchService().getPincodeByPincode(pincodePojo.getPincode());
		if(pincode == null){
			pincode = getPincodeFromPojo(pincodePojo);
		}
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

	@Override
	@Transactional
	public void deletePincode(Integer pincode) {
		Query query = getSessionFactory().getCurrentSession().getNamedQuery("DEL.PINCODE");
		int result = query.setParameter("pincode", pincode).executeUpdate();
		if(result == 0){
			throw new PincodeException("Pincode Doesn't Exist in our system");
		}
	}

	public IPincodeSearchService getPincodeSearchService() {
		return pincodeSearchService;
	}

}
