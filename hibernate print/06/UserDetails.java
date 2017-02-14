package org.rudra.modelClass6;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity 
@Table(name="USER_DETAILS_6")
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
	@GeneratedValue
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
	/** when we feel that , we have a field which can have more than 255 char , we can mark it as LOB(Large Object)
	 *  based on which Hibernate will take care of it converting it into Blob(Byte Lob) or Clob(character Lob).
	 */
	@Lob
	public String getDescription() {
		return description;
	}
	// this will add the Date alone and not the complete timestamp , which is a default value of Date()
	@Temporal(TemporalType.DATE)
	public Date getJoinedDate() {
		return joinedDate;
	}
}
