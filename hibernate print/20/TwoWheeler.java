package org.rudra.modelClass20;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity

public class TwoWheeler extends Vehicle  {

	private String steeringHandle;
	
	public void setSteeringHandle(String steeringHandle) {
		this.steeringHandle = steeringHandle;
	}
	public String getSteeringHandle() {
		return steeringHandle;
	}
}
