package com.hnguyen.serviceImplementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hnguyen.daos.PostalCodeDAO;
import com.hnguyen.entities.PostalCode;
import com.hnguyen.services.PostalCodeService;

@Service
public class PostalCodeServiceImpl implements PostalCodeService {

	@Autowired
	private PostalCodeDAO postalCodeDAO;

	@Override
	@Transactional
	public List<PostalCode> getAllPostalCodes() {
		return postalCodeDAO.getAllPostalCodes();
	}

	@Override
	@Transactional
	public List<PostalCode> getAllPostalCodesInCity(int cityID) {
		return postalCodeDAO.getAllPostalCodesInCity(cityID);
	}
	
	@Override
	@Transactional
	public PostalCode getPostalCode(String postalCode_) {
		return postalCodeDAO.getPostalCode(postalCode_);
	}

	@Override
	@Transactional
	public void deletePostalCode(String postalCode) {
		postalCodeDAO.deletePostalCode(postalCode);
	}

}
