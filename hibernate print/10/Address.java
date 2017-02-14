package org.rudra.modelClass10;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable // this annot. is needed once you are using the current class as a part of Collection.
public class Address {

	private String street;
	private String city;
	private String state;
	private String pincode;
	
	public void setCity(String city) {
		this.city = city;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public void setState(String state) {
		this.state = state;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	// this kind of override are called "general" override , b/c they will be reflected to all instances of Address.
	@Column(name="city_name")
	public String getCity() {
		return city;
	}
	public String getPincode() {
		return pincode;
	}
	public String getState() {
		return state;
	}
	public String getStreet() {
		return street;
	}
}
