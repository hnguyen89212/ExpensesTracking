package com.hnguyen.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "store")
public class Store {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "store_id")
	private int storeID;
	
	@Column(name = "store_name")
	private String storeName;
	
	@Column(name = "address")
	private String storeAddress;
	
	@Column(name = "postal_code")
	private String storePostalCode;
	
	
	public Store() {}
	
	public Store(String storeName, String storeAddress, String storePostalCode) {
		this.storeName = storeName;
		this.storeAddress = storeAddress;
		this.storePostalCode = storePostalCode;
	}

	public int getStoreID() {
		return storeID;
	}

//	public void setStoreID(int storeID) {
//		this.storeID = storeID;
//	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getStoreAddress() {
		return storeAddress;
	}

	public void setStoreAddress(String storeAddress) {
		this.storeAddress = storeAddress;
	}

	public String getStorePostalCode() {
		return storePostalCode;
	}

	public void setStorePostalCode(String storePostalCode) {
		this.storePostalCode = storePostalCode;
	}

}
