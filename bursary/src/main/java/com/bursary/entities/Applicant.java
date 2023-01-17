package com.bursary.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.bursary.entities.objects.GENDER;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Applicant implements Serializable {
	private static final long serialVersionUID = -2673662513912668135L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Nonnull
	private String firstName;
	private String middleName;
	private String lastName;
	@Enumerated
	private GENDER gender;
	@Temporal(TemporalType.DATE)
	@Column(name = "birth_date")
	private Date dob;
	private String email;
	@OneToOne
	private Study study;

	@Column(name = "createdDate", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createdDate;
	private String referenceNo;

	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date modifiedDate;

	@OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	private Set<Address> address = new HashSet<>();

	@OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	private Set<Qualification> qualification = new HashSet<>();
}