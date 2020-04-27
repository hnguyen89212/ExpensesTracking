package com.hnguyen.services;

import java.util.List;

import com.hnguyen.entities.PostalCode;

public interface PostalCodeService {

	public List<PostalCode> getAllPostalCodes();

	public List<PostalCode> getAllPostalCodesInCity(int cityID);

	public PostalCode getPostalCode(String postalCode_);

	public void deletePostalCode(String postalCode);

}
