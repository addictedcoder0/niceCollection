package org.rudra.modelClass33;

public class Admin extends Employee {

	private String branch;

	public Admin() {
		super();
	}

	public Admin(int id, String name, String email, float salary,String branch) {
		super(id, name, email, salary);
		this.branch = branch;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}
	
	
}
