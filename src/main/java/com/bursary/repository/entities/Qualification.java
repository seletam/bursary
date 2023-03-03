package com.bursary.repository.entities;

import com.bursary.common.constant.QUALIFICATION_STATUS;
import com.bursary.common.constant.SCHOOL_TYPE;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Table
public class Qualification {

	@Id
	@PrimaryKey
	@Setter(AccessLevel.NONE)
	@PrimaryKeyColumn(name = "id", type = PrimaryKeyType.PARTITIONED)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	@CassandraType(type = CassandraType.Name.INT)
	private SCHOOL_TYPE schoolType;
	private String institution;
	@CassandraType(type = CassandraType.Name.INT)
	private QUALIFICATION_STATUS qualificationStatus;
	private List<BaseModal> subjects;
}