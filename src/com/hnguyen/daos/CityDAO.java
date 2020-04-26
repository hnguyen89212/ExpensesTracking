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

}
