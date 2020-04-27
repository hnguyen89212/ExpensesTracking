package com.hnguyen.daos;

import java.util.List;

import com.hnguyen.entities.City;

public interface CityDAO {

	public List<City> getAllCities();

	public List<City> getCityByName(String cityName);

	public City getCityByPostalCode(String postalCode);
	
	// Since the cityID attribute in City class has type of integer.
	public City getCityByCityID(int cityID);

	public void saveCity(City city);

	public void deleteCity(int cityID);
	
	// City - PostalCode is 1 - N relationship and City is kind of owner.
	// So, adding new postal code should be handled by City.
	public void savePostalCode(String cityID_, String postalCode, boolean saveMode);

}
