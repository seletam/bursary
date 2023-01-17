package com.bursary.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import com.bursary.entities.objects.ADDRESS_TYPE;
import com.bursary.entities.objects.PROVINCE;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
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
}