package org.rudra.modelClass33;

public class SoftwareEngineer extends Employee {

	private String tools;
	
	
	public SoftwareEngineer() {
		super();
	}
	
	
	public SoftwareEngineer(int id, String name, String email, float salary,String tools) {
		super(id, name, email, salary);
		this.tools = tools;
	}


	public void setTools(String tools) {
		this.tools = tools;
	}
	public String getTools() {
		return tools;
	}
}
