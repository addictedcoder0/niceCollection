package org.rudra.modelClass16;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="VEHICLE_DETAILS_16")
public class Vehicle {

	@Id @GeneratedValue
	private int vehicleId;
	private String vehicleName;
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private UserDetails user;
	
	public void setUser(UserDetails user) {
		this.user = user;
	}
	public UserDetails getUser() {
		return user;
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
