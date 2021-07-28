package com.revature.project.model.LibraryManagement;

public class Users
{
	private Integer id;
	private String name;
	private String emailId;
	private Long phnNo;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public Long getPhnNo() {
		return phnNo;
	}
	public void setPhnNo(Long phnNo) {
		this.phnNo = phnNo;
	}
	@Override
	public String toString() {

		return "\nUsers [id=" + id + ", name=" + name + ", emailId=" + emailId + ", phnNo=" + phnNo + "]";
	}
	
}
