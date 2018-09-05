package com.bursary.bursary.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.bursary.bursary.enumerator.GENDER;

/*
 * Seleta M. Mootwane
 * 2018-08-23
 */

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Applicant implements Serializable {
	private static final long serialVersionUID = -2673662513912668135L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
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
	private char[] referenceNo;

	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date modifiedDate;

	@OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	private Set<Address> address = new HashSet<>();

	@OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	private Set<Qualification> qualification = new HashSet<>();

	public Applicant() {

	}

	public Applicant(Long id, @NotBlank String firstName, String middleName, String lastName, GENDER gender, Date dob,
			String email, Study study, char[] referenceNo, Date createdDate, Date modifiedDate, Set<Address> address,
			Set<Qualification> qualification) {
		this.id = id;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.gender = gender;
		this.dob = dob;
		this.email = email;
		this.study = study;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
		this.address = address;
		this.referenceNo = referenceNo;
		this.qualification = qualification;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public GENDER getGender() {
		return gender;
	}

	public void setGender(GENDER gender) {
		this.gender = gender;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Address> getAddress() {
		return address;
	}

	public void setAddress(Set<Address> address) {
		this.address = address;
	}

	public Study getFieldOfStudy() {
		return study;
	}

	public void setFieldOfStudy(Study study) {
		this.study = study;
	}

	public Set<Qualification> getQualification() {
		return qualification;
	}

	public void setQualification(Set<Qualification> qualification) {
		this.qualification = qualification;
	}

	public char[] getReferenceNo() {
		return referenceNo;
	}

	public void setReferenceNo(char[] referenceNo) {
		this.referenceNo = referenceNo;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public char[] OTP(int len)
    {
        System.out.println("Generating OTP using random() : ");
        System.out.print("You OTP is : ");
 
        // Using numeric values
        String numbers = "0123456789";
 
        // Using random method
        Random rndm_method = new Random();
 
        char[] otp = new char[len];
 
        for (int i = 0; i < len; i++)
        {
            // Use of charAt() method : to get character value
            // Use of nextInt() as it is scanning the value as int
            otp[i] =
             numbers.charAt(rndm_method.nextInt(numbers.length()));
        }
        return otp;
    }
	
	@Override
	public String toString() {
		return "Applicant [getId()=" + getId() + ", getQualification()=" + getQualification() + "]";
	}
}