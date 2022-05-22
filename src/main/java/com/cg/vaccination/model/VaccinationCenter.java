package com.cg.vaccination.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class VaccinationCenter {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int code;
	private String centerName;
	private String address;
	private String city;
	private String state;
	private String pinCode;
	
	public VaccinationCenter() {
		super();
		
	}

	public VaccinationCenter(int code, String centerName, String address, String city, String state, String pinCode) {
		super();
		this.code = code;
		this.centerName = centerName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.pinCode = pinCode;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getCenterName() {
		return centerName;
	}

	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	@Override
	public String toString() {
		return "VaccinationCenter [code=" + code + ", centerName=" + centerName + ", address=" + address + ", city="
				+ city + ", state=" + state + ", pinCode=" + pinCode + "]";
	}
	
	

}
