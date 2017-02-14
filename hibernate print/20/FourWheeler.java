package org.rudra.modelClass20;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity

public class FourWheeler extends Vehicle {

	private String steeringWheel;
	public void setSteeringWheel(String steeringWheel) {
		this.steeringWheel = steeringWheel;
	}
	public String getSteeringWheel() {
		return steeringWheel;
	}
	
}
