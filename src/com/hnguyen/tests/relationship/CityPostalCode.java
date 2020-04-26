package com.hnguyen.tests.relationship;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//import com.hnguyen.DAOImplementations.CityDAOImpl;
import com.hnguyen.entities.City;
import com.hnguyen.entities.PostalCode;
import com.hnguyen.serviceImplementations.CityServiceImpl;
import com.hnguyen.services.CityService;

/**
 * 
 * @author hainguyen
 * @date April 25 2020
 * @description Tests relationship between City and PostalCode.
 *
 */
public class CityPostalCode {

//	public static void main(String[] args) {
//		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(City.class)
//				.addAnnotatedClass(PostalCode.class).buildSessionFactory();
//
//		Session session = factory.getCurrentSession();
//
//		try {
//			session.beginTransaction();
//
//			// Creates 1 city.
//			City london = new City("London");
//			session.save(london);
//
//			// Creates 3 postal codes in the city.
//			PostalCode pc1 = new PostalCode("N5X0E1");
//			pc1.setCityID(london);
//			PostalCode pc2 = new PostalCode("N5Y4G3");
//			pc2.setCityID(london);
//			PostalCode pc3 = new PostalCode("M2R2W3");
//			pc3.setCityID(london);
//			session.save(pc1);
//			session.save(pc2);
//			session.save(pc3);
//
//			// Prints data
//			System.out.println(pc1.toString());
//			System.out.println(pc2.toString());
//			System.out.println(pc3.toString());
//
//			CityService cityService = new CityServiceImpl();
//
//			List<City> allCities = cityService.getAllCities();
//			System.out.println(allCities.size());
//
//			// Deletes a postal code, verifies that the city is around.
////			session.delete(pc1);
//
//			// Deletes the city, checks that the other 2 postal codes are gone?
//
//			session.getTransaction().commit();
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		} finally {
//			session.close();
//			factory.close();
//		}
//	}

}
