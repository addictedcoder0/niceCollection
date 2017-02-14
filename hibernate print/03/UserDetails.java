package org.rudra.modelClass3;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity (name="USER_DETAILS_1")
public class UserDetails {
	
	private int userId;
	private String userName;
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Id 
	@Column (name="user_id")
	public int getUserId() {
		return userId;
	}
	@Column (name="user_name")
	public String getUserName() {
		return userName;
	}
}
