package org.example;

public class Employee {
	
	private long id = 1L;
	
	private String name;
	
	public Employee() {
	}

	public Employee(String fname) {
		name = fname;
	}
	
	public long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
