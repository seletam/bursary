package com.bursary.entities;

import com.bursary.entities.objects.GENDER;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.*;

import java.util.Date;
import java.util.UUID;

import static org.springframework.data.cassandra.core.mapping.CassandraType.Name.INT;

@Table
@Data
@Builder(builderMethodName = "applicantBuilder")
@UserDefinedType("applicant_type")
public class Applicant {

	@Id
	@PrimaryKey
	@Setter(AccessLevel.NONE)
	@PrimaryKeyColumn(name = "id", ordinal = 0,type = PrimaryKeyType.PARTITIONED)
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	private String firstName;
	private String middleName;
	private String lastName;
	@CassandraType(type = CassandraType.Name.INT)
	private GENDER gender;
	private Date dob;
	private String email;
	@Column
	@CassandraType(type = INT)
	private Study study;
	@CreatedDate
	private Date createdDate;
	private String referenceNo;
	@LastModifiedDate
	private Date modifiedDate;
	private Address addresses;
	@CassandraType(type = CassandraType.Name.INT)
	private Qualification qualifications;
	private int active;
}