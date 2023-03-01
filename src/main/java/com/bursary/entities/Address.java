package com.bursary.entities;

import com.bursary.entities.objects.ADDRESS_TYPE;
import com.bursary.entities.objects.PROVINCE;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

import static org.springframework.data.cassandra.core.mapping.CassandraType.Name.TEXT;

@Builder
@Data
@UserDefinedType("address")
public class Address {

	@Id
	@Setter(AccessLevel.NONE)
	@PrimaryKey
	@GeneratedValue(strategy = GenerationType.UUID)
	private Long id;
	@CassandraType(type = TEXT)
	private ADDRESS_TYPE address_type;
	private String street;
	private String city;
	private PROVINCE stateOrProvince;
	private String country;
	private Integer code;
}