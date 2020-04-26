package com.hnguyen.serviceImplementations;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hnguyen.daos.CityDAO;
import com.hnguyen.entities.City;
import com.hnguyen.services.CityService;

@Service
public class CityServiceImpl implements CityService {

	@Autowired
	private CityDAO cityDAO;

	@Override
	@Transactional
	public List<City> getAllCities() {
		return cityDAO.getAllCities();
	}

	@Override
	@Transactional
	public List<City> getCityByName(String cityName) {
		return cityDAO.getCityByName(cityName);
	}

	@Override
	@Transactional
	public City getCityByPostalCode(String postalCode) {
		return cityDAO.getCityByPostalCode(postalCode);
	}
	
	@Override
	@Transactional
	public City getCityByCityID(int cityID) {
		return cityDAO.getCityByCityID(cityID);
	}

	@Override
	@Transactional
	public void saveCity(City city) {
		cityDAO.saveCity(city);
	}

	@Override
	@Transactional
	public void deleteCity(int cityID) {
		cityDAO.deleteCity(cityID);
	}

}
