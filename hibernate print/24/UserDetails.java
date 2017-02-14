package org.rudra.modelClass24;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.SelectBeforeUpdate;

@Entity 
@SelectBeforeUpdate //annotation is used by hibernate before update ,to find if object has changed in detached state
@Table(name="USER_DETAILS_24")
public class UserDetails {
	@Id @GeneratedValue
	private int userId;
	private String userName;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
		
}
