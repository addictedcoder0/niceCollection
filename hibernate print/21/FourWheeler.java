package org.rudra.modelClass21;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="FOUR_WHEELER_DETAILS_21")
public class FourWheeler extends Vehicle {

	private String steeringWheel;
	public void setSteeringWheel(String steeringWheel) {
		this.steeringWheel = steeringWheel;
	}
	public String getSteeringWheel() {
		return steeringWheel;
	}
	
}
