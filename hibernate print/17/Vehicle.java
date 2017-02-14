package org.rudra.modelClass17;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;

@Entity
@Table(name="VEHICLE_DETAILS_17")
public class Vehicle {

	@Id @GeneratedValue
	private int vehicleId;
	private String vehicleName;
	@ManyToMany(mappedBy="vehicle")
	//@NotFound
	private Collection<UserDetails> userList = new ArrayList<UserDetails>();
	
	public void setUserList(Collection<UserDetails> userList) {
		this.userList = userList;
	}
	public Collection<UserDetails> getUserList() {
		return userList;
	}
	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
}
