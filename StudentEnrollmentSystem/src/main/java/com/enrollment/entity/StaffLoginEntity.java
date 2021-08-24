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
@Table(name="StaffLogin")
public class StaffLoginEntity implements Serializable {

	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id",nullable=false)
	@JsonIgnore
	 private StaffEntity username;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long userId;
	@Column(nullable=false)
	private long loginId;
	@Column(nullable=false)
	private String password;
	
	public StaffEntity getUsername() {
		return username;
	}
	public void setUsername(StaffEntity username) {
		this.username = username;
	}
	public long getLoginId() {
		return loginId;
	}
	public void setLoginId(long loginId) {
		this.loginId = loginId;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public StaffLoginEntity() {
		super();
	}
	public StaffLoginEntity(StaffEntity username, long loginId, long userId, String password) {
		super();
		this.username = username;
		this.loginId = loginId;
		this.userId = userId;
		this.password = password;
	}

	
	
	
	
	
}
