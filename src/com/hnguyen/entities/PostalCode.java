package com.hnguyen.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "postal_code")
public class PostalCode {

	@Id
	@Column(name = "postal_code")
	private String postalCode;

	/**
	 * City - PostalCode relationship is 1 - N: one city has multiple postal codes.
	 * In the table "postal_code", columm "city_id" has potentially many duplicate
	 * values (city_id). Hence, @Column here is not appropriate.
	 */
//	@Column(name = "city_id")
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
	@JoinColumn(name = "city_id")
	private City city;

	public PostalCode() {
	}

	public PostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public City getCityID() {
		return city;
	}

	public void setCityID(City city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "PostalCode [postalCode=" + postalCode + ", city=" + city.getCityName() + "]";
	}

}
