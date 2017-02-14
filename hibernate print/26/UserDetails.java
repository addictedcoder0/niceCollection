package org.rudra.modelClass26;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.SelectBeforeUpdate;

@Entity 
@NamedQuery(name = "UserDetails.byId", query = "from UserDetails where userId = ?")
@NamedNativeQuery(name = "UserDetails.byName", query = "select * from user_details_26 where username = ?" ,resultClass=UserDetails.class)
@SelectBeforeUpdate //annotation is used by hibernate before update ,to find if object has changed in detached state
@Table(name="USER_DETAILS_26")
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
