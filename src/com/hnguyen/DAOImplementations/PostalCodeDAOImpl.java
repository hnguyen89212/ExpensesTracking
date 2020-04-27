package com.hnguyen.DAOImplementations;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hnguyen.daos.PostalCodeDAO;
import com.hnguyen.entities.City;
import com.hnguyen.entities.PostalCode;

@Repository
public class PostalCodeDAOImpl implements PostalCodeDAO {

	@Autowired
	private SessionFactory factory;

	@Override
	public List<PostalCode> getAllPostalCodes() {
		Session session = factory.getCurrentSession();

		Query<PostalCode> query = session.createQuery("FROM PostalCode AS pc", PostalCode.class);

		List<PostalCode> postalCodes = query.getResultList();

		return (postalCodes.isEmpty()) ? null : postalCodes;
	}

	@Override
	public List<PostalCode> getAllPostalCodesInCity(int cityID) {
		Session session = factory.getCurrentSession();

		Query<PostalCode> query = session.createQuery(
				"SELECT pc " + "FROM PostalCode pc INNER JOIN pc.city " + "WHERE pc.city.cityID = :cityID", PostalCode.class);

		query.setParameter("cityID", cityID);

		List<PostalCode> postalCodes = query.getResultList();

		return (postalCodes.isEmpty()) ? null : postalCodes;
	}

	@Override
	public PostalCode getPostalCode(String postalCode_) {
		Session session = factory.getCurrentSession();

		Query<PostalCode> query = session.createQuery("FROM PostalCode pc WHERE pc.postalCode = :postalCode_",
				PostalCode.class);

		query.setParameter("postalCode_", postalCode_);

		List<PostalCode> pcs = query.getResultList();

		return (pcs.isEmpty()) ? null : pcs.get(0);
	}

	@Override
	public void deletePostalCode(String postalCode) {
		Session session = factory.getCurrentSession();

		Query query = session.createQuery("DELETE FROM PostalCode WHERE postalCode = :postalCode");

		query.setParameter("postalCode", postalCode);

		query.executeUpdate();
	}

}
