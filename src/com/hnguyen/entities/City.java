package com.hnguyen.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "city")
public class City {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "city_id")
	private int cityID;

	@Column(name = "city_name")
	private String cityName;

	/**
	 * City - PostalCode relationship is 1 - N: one city has multiple postal codes.
	 * So there should be a list of postal codes as an attribute in City class.
	 */
	@OneToMany(mappedBy = "city", cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH })
	private List<PostalCode> postalCodes;

	public List<PostalCode> getPostalCodes() {
		return postalCodes;
	}

	public void setPostalCodes(List<PostalCode> postalCodes) {
		this.postalCodes = postalCodes;
	}

	public void add(PostalCode postalCode) {
		if (postalCodes == null) {
			postalCodes = new ArrayList<>();
		}

		postalCodes.add(postalCode);
		postalCode.setCity(this);
	}

	public City() {
	}

	public City(String cityName) {
		this.cityName = cityName;
	}

	public int getCityID() {
		return cityID;
	}

	/**
	 * Typically, we will not invoke this method directly to change ID of a city. It
	 * is intuitive to think of eliminating this method. However, it is still
	 * crucial in the way that the Hibernate uses it to set the value/path cityID in
	 * JSP.
	 * 
	 * @param cityID
	 */
	public void setCityID(int cityID) {
		this.cityID = cityID;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	@Override
	public String toString() {
		return "City [cityID=" + cityID + ", cityName=" + cityName + "]";
	}

}
