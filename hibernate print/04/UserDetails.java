package org.rudra.modelClass4;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity 
@Table(name="USER_DETAILS_3")
public class UserDetails {
	
	private int userId;
	private String userName;
	private Date joinedDate;
	private String Address;
	private String description;
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}
	@Id 
	@Column (name="user_id")
	public int getUserId() {
		return userId;
	}
	// if we don't want any of the field to be saved in DB mark it as @Transient
	@Transient
	@Column (name="user_name")
	public String getUserName() {
		return userName;
	}
	public String getAddress() {
		return Address;
	}
	public String getDescription() {
		return description;
	}
	public Date getJoinedDate() {
		return joinedDate;
	}
}
