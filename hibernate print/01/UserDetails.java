package org.rudra.modelClass1;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity 
public class UserDetails {

	@Id 
	private int userId;
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