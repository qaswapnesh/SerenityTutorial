package com.studentapp.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class StudentClass {
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String programme;
	private List<String> courses;
	
	public int getId(int id) {
		return id;
	}
	public String getFirstName(String firstName) {
		return firstName;
	}
	public String getLastName(String lastName) {
		return lastName;
	}
	public String getEmail(String email) {
		return email;
	}
	public String getProgramme(String programme) {
		return programme;
	}
	public 	 List<String> getCourses() {
		return courses;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setProgramme(String programme) {
		this.programme = programme;
	}
	public void setCourses(List<String> courses) {
		this.courses = courses;
	}
	public static void main(String[] args) {
		StudentClass stud = new StudentClass();

	}

}
