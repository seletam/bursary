package com.bursary.repository.entities;

import com.bursary.common.constant.ADDRESS_TYPE;
import com.bursary.common.constant.PROVINCE;
import lombok.*;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

import static org.springframework.data.cassandra.core.mapping.CassandraType.Name.TEXT;

@Builder
@Data
@UserDefinedType("address")
public class Address {
	@CassandraType(type = TEXT)
	private ADDRESS_TYPE address_type;
	private String street;
	private String city;
	private PROVINCE stateOrProvince;
	private String country;
	private Integer code;
}