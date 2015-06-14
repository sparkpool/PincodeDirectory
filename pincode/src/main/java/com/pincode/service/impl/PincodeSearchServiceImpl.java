package com.pincode.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pincode.domain.Pincode;
import com.pincode.pojo.PincodePojo;
import com.pincode.service.IPincodeSearchService;

@Service
public class PincodeSearchServiceImpl implements IPincodeSearchService {

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Override
	public Pincode getPincodeByPincode(Integer pincode) {
		Query query = getSessionFactory().getCurrentSession().getNamedQuery(
				"GET.PINCODE");
		return (Pincode) query.setParameter("pincode", pincode).uniqueResult();
	}

	@Override
	@Transactional(readOnly = true)
	public PincodePojo getPincodePojoByPincode(Integer pincode) {
		Pincode pincodeObj = getPincodeByPincode(pincode);
		return getPincodePojoByPincode(pincodeObj);
	}

	private PincodePojo getPincodePojoByPincode(Pincode pincode){
		PincodePojo pincodePojo = new PincodePojo();
		pincodePojo.setPincode(pincode.getPincode());
		pincodePojo.setDistrict(pincode.getDistrict());
		pincodePojo.setCircle(pincode.getCircle());
		pincodePojo.setState(pincode.getState());
		pincodePojo.setName(pincode.getName());
		pincodePojo.setDivision(pincode.getDivision());
		return pincodePojo;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<PincodePojo> getPincodeByDistrict(String district) {
		Query query = getSessionFactory().getCurrentSession().getNamedQuery(
				"GET.DISTRICT");
		List<Pincode> pincodeList = (List<Pincode>)query.setParameter("district", district).list();
		if(pincodeList!=null && pincodeList.size() > 0){
			List<PincodePojo> pincodePojoList = new ArrayList<PincodePojo>();
			for(Pincode pincode : pincodeList){
				pincodePojoList.add(getPincodePojoByPincode(pincode));
			}
			return pincodePojoList;
		}
		return null;
	}

	@Override
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<PincodePojo> getPincodeByState(String state) {
		Query query = getSessionFactory().getCurrentSession().getNamedQuery(
				"GET.STATE");
		List<Pincode> pincodeList = (List<Pincode>)query.setParameter("state", state).list();
		if(pincodeList!=null && pincodeList.size() > 0){
			List<PincodePojo> pincodePojoList = new ArrayList<PincodePojo>();
			for(Pincode pincode : pincodeList){
				pincodePojoList.add(getPincodePojoByPincode(pincode));
			}
			return pincodePojoList;
		}
		return null;
	}

	@Override
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<PincodePojo> getPincodeByCircle(String circle) {
		Query query = getSessionFactory().getCurrentSession().getNamedQuery(
				"GET.CIRCLE");
		List<Pincode> pincodeList = (List<Pincode>)query.setParameter("circle", circle).list();
		if(pincodeList!=null && pincodeList.size() > 0){
			List<PincodePojo> pincodePojoList = new ArrayList<PincodePojo>();
			for(Pincode pincode : pincodeList){
				pincodePojoList.add(getPincodePojoByPincode(pincode));
			}
			return pincodePojoList;
		}
		return null;	
	}

}
