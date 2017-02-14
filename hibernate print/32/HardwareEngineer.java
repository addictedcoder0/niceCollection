package org.rudra.modelClass32;

public class HardwareEngineer extends Employee {

	private int workingHours;

	public HardwareEngineer() {
		super();
	}

	public HardwareEngineer(int id, String name, String email, float salary,int workingHours) {
		super(id, name, email, salary);
		this.workingHours = workingHours;
	}
	
	public void setWorkingHours(int workingHours) {
		this.workingHours = workingHours;
	}
	public int getWorkingHours() {
		return workingHours;
	}
}
