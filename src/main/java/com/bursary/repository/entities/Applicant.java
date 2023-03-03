package com.bursary.repository.entities;

import com.bursary.common.constant.GENDER;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Table
@Data
@Builder(builderMethodName = "applicantBuilder")
public class Applicant {

	@Id
	@PrimaryKey
	@Setter(AccessLevel.NONE)
	@PrimaryKeyColumn(name = "id", type = PrimaryKeyType.PARTITIONED)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	private String firstName;
	private String middleName;
	private String lastName;
	@CassandraType(type = CassandraType.Name.INT)
	private GENDER gender;
	private Date dob;
	private String email;
	private Study study;
	@CreationTimestamp
	private LocalDateTime createdDate;
	private String referenceNo;
	@LastModifiedDate
	private Date modifiedDate;
	private Address addresses;
	private List<Qualification> qualifications;
	private int active;
}