package com.hnguyen.daos;

import java.util.List;

import com.hnguyen.entities.PostalCode;

public interface PostalCodeDAO {
  
	public List<PostalCode> getAllPostalCodes();
	
	public List<PostalCode> getAllPostalCodesInCity(int cityID);
	
	// The primary key of a postal code is string.
	public PostalCode getPostalCode(String postalCode_);
	
	// Because the primary key of postal_code is a string.
	public void deletePostalCode(String postalCode);

}