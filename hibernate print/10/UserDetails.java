package org.rudra.modelClass10;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity 
@Table(name="USER_DETAILS_10")
public class UserDetails {
	
	private UserId userId;
	private String userName;
	private Date joinedDate;
	private List<Address> listOfAddress = new LinkedList<Address>();
	private String description;
	
	public void setUserId(UserId userId) {
		this.userId = userId;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setListOfAddress(List<Address> listOfAddress) {
		this.listOfAddress = listOfAddress;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}
	//@Id : if we used this one here then it will send the object reference in the DB,instead of its integer value object.
	@EmbeddedId
	@Column (name="user_id")
	public UserId getUserId() {
		return userId;
	}
	// if we don't want any of the field to be saved in DB mark it as @Transient
	@Transient
	@Column (name="user_name")
	public String getUserName() {
		return userName;
	}
	@ElementCollection // automatically hibernate will save this in a different table , but will attach its id as the FK
	public List<Address> getListOfAddress() {
		return listOfAddress;
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
