package org.rudra.modelClass9;

import java.io.Serializable;

import javax.persistence.Embeddable;

//@Embeddable
public class UserId implements Serializable {

	private int id;
	
	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
}
