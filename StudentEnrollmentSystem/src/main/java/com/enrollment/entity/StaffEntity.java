package com.enrollment.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="StaffPersonal")
public class StaffEntity implements Serializable{
	private static final long serialVersionUID = 1L;

	@OneToOne(mappedBy="username",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private StaffLoginEntity user;
	
	@OneToOne( fetch = FetchType.LAZY)
	@JoinColumn(name="id",nullable=false)
	@JsonIgnore
	 private StaffAssignEntity staffId;
	
	
	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
//	private long autoId;
	
	@Column(nullable=false)
	private Long newId;
	@Column(nullable=false)
	private String firstName;
	@Column(nullable=false)
	private String lastName;
	@Column(nullable=false)
	private String dateOfBirth;
	@Column(nullable=false)
	private String gender;
	@Column(nullable=false)
	private String qualification;
	@Column(nullable=false)
	private String email;
	@Column(nullable=false)
	private Long contactNo;
	@Column(nullable=false)
	private String address;
	public StaffLoginEntity getUser() {
		return user;
	}
	public void setUser(StaffLoginEntity user) {
		this.user = user;
	}
	public StaffAssignEntity getStaffId() {
		return staffId;
	}
	public void setStaffId(StaffAssignEntity staffId) {
		this.staffId = staffId;
	}
	public Long getNewId() {
		return newId;
	}
	public void setNewId(Long newId) {
		this.newId = newId;
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
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getContactNo() {
		return contactNo;
	}
	public void setContactNo(Long contactNo) {
		this.contactNo = contactNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public StaffEntity() {
		super();
	}
	public StaffEntity(StaffLoginEntity user, StaffAssignEntity staffId, Long newId, String firstName, String lastName,
			String dateOfBirth, String gender, String qualification, String email, Long contactNo, String address) {
		super();
		this.user = user;
		this.staffId = staffId;
		this.newId = newId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.qualification = qualification;
		this.email = email;
		this.contactNo = contactNo;
		this.address = address;
	}
	
	
	
	
	
	
}
