package org.rudra.modelClass37;

import java.util.Set;

public class Course {

	private int course_id;
	private String course_name;
	private int course_fee;
	private Set<Faculty> faculties;
	
	public Course(){
		
	}

	public int getCourse_id() {
		return course_id;
	}

	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	public int getCourse_fee() {
		return course_fee;
	}

	public void setCourse_fee(int course_fee) {
		this.course_fee = course_fee;
	}

	public Set<Faculty> getFaculties() {
		return faculties;
	}

	public void setFaculties(Set<Faculty> faculties) {
		this.faculties = faculties;
	}
	
	
}
