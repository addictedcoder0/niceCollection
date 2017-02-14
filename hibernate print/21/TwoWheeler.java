package org.rudra.modelClass21;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="TWO_WHEELER_DETAILS_21")
public class TwoWheeler extends Vehicle  {

	private String steeringHandle;
	
	public void setSteeringHandle(String steeringHandle) {
		this.steeringHandle = steeringHandle;
	}
	public String getSteeringHandle() {
		return steeringHandle;
	}
}
