package com.bursary.bursary.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.bursary.bursary.enumerator.ADDRESS_TYPE;
import com.bursary.bursary.enumerator.PROVINCE;

@Entity
public class Address implements Serializable{
	
	private static final long serialVersionUID = 547523700768962114L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Enumerated
	private ADDRESS_TYPE address_type;
	private String street;
	private String city;
	@Enumerated
	private PROVINCE stateOrProvince;
	private String country;
	private Integer code;

	public Address() {

	}

	public Address(Long id, ADDRESS_TYPE address_type, String address, String city, PROVINCE stateOrProvince,
			String country, Integer code) {
		this.id = id;
		this.address_type = address_type;
		this.street = address;
		this.city = city;
		this.stateOrProvince = stateOrProvince;
		this.country = country;
		this.code = code;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ADDRESS_TYPE getType() {
		return address_type;
	}

	public void setType(ADDRESS_TYPE address_type) {
		this.address_type = address_type;
	}

	public String getAddress() {
		return street;
	}

	public void setAddress(String address) {
		this.street = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public PROVINCE getStateOrProvince() {
		return stateOrProvince;
	}

	public void setStateOrProvince(PROVINCE stateOrProvince) {
		this.stateOrProvince = stateOrProvince;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}
}