package com.hnguyen.DAOImplementations;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hnguyen.daos.CityDAO;
import com.hnguyen.entities.City;

@Repository
public class CityDAOImpl implements CityDAO {

	@Autowired
	private SessionFactory factory;

	@Override
	public List<City> getAllCities() {
		Session session = factory.getCurrentSession();

		Query<City> query = session.createQuery("FROM City AS c", City.class);

		List<City> cities = query.getResultList();

		return (cities.isEmpty()) ? null : cities;
	}

	@Override
	public List<City> getCityByName(String cityName) {
		Session session = factory.getCurrentSession();

		Query<City> query = session.createQuery("FROM City AS c WHERE c.cityName = :cityName", City.class);

		query.setParameter("cityName", cityName);

		List<City> cities = query.getResultList();

		return (cities.isEmpty()) ? null : cities;
	}

	@Override
	public City getCityByPostalCode(String postalCode) {
		Session session = factory.getCurrentSession();

		Query<City> query = session.createQuery(
				"SELECT c " + "FROM City c INNER JOIN c.postalCodes p " + "WHERE p.postalCode = :postalCode", City.class);

		query.setParameter("postalCode", postalCode);

		List<City> cities = query.getResultList();

		return (cities.isEmpty()) ? null : cities.get(0);
	}

	@Override
	public City getCityByCityID(int cityID) {
		Session session = factory.getCurrentSession();

		Query<City> query = session.createQuery("FROM City AS c WHERE c.cityID = :cityID", City.class);

		query.setParameter("cityID", cityID);

		List<City> cities = query.getResultList();

		return (cities.isEmpty()) ? null : cities.get(0);
	}

	@Override
	public void saveCity(City city) {
		Session session = factory.getCurrentSession();

		session.saveOrUpdate(city);
	}

	@Override
	public void deleteCity(int cityID) {
		Session session = factory.getCurrentSession();

		// For DELETE, the query should not be typed Query<City> query = ...
		Query query = session.createQuery("DELETE FROM City WHERE cityID = :cityID");

		query.setParameter("cityID", cityID);

		query.executeUpdate();
	}

}
