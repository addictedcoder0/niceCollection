package org.rudra.modelClass19;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Car")
public class FourWheeler extends Vehicle {

	private String steeringWheel;
	public void setSteeringWheel(String steeringWheel) {
		this.steeringWheel = steeringWheel;
	}
	public String getSteeringWheel() {
		return steeringWheel;
	}
	
}
