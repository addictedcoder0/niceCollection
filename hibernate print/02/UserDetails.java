package org.rudra.modelClass2;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity (name="USER_DETAILS")
public class UserDetails {

	@Id 
	@Column (name="user_id")
	private int userId;
	@Column (name="user_name")
	private String userName;
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getUserId() {
		return userId;
	}
	public String getUserName() {
		return userName;
	}
}
