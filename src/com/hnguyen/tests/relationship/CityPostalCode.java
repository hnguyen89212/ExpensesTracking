package com.hnguyen.tests.relationship;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;

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
	
	@Autowired
	private CityService cityService;

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(City.class)
				.addAnnotatedClass(PostalCode.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();

			session.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}
	}

}
