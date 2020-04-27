package com.hnguyen.services;

import java.util.List;

import com.hnguyen.entities.City;

public interface CityService {

	public List<City> getAllCities();

	public List<City> getCityByName(String cityName);

	public City getCityByPostalCode(String postalCode);
	
	public City getCityByCityID(int cityID);

	public void saveCity(City city);

	public void deleteCity(int cityID);
	
	public void savePostalCode(String cityID_, String postalCode, boolean saveMode);

}
