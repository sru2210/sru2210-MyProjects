package com.enrollment.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@Entity
@Table(name="StaffAssign")
public class StaffAssignEntity implements Serializable {

	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="deptId",nullable=false)
	@JsonIgnore
	private DepartmentEntity dept;
	
	
	
	@OneToOne(mappedBy="staffId",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private StaffEntity user;
	
	
//	@GeneratedValue(strategy=GenerationType.AUTO)
//	 private long assignId;
	@Id 
	@Column(nullable=false,unique=true)
	private long id;
	
	@Column(nullable=false)
	private String name;
	
	@Temporal(TemporalType.DATE)
	private Date joiningDate;

	public DepartmentEntity getDept() {
		return dept;
	}

	public void setDept(DepartmentEntity dept) {
		this.dept = dept;
	}

	public StaffEntity getUser() {
		return user;
	}

	public void setUser(StaffEntity user) {
		this.user = user;
	}

//	public long getAssignId() {
//		return assignId;
//	}
//
//	public void setAssignId(long assignId) {
//		this.assignId = assignId;
//	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}
	
	
	
}
