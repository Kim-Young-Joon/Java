package com.uni;

public class Human {
	// fields
	private String name;
	private int age;
	private int height;
	private int weight;
	
	// constructors
	public Human() {
		
	}
	
	public Human(String name, int age, int height, int weight) {
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
	}
	
	// methods
	public String printInformation() {
		return this.getName() + " " + this.getAge() + " " + this.getHeight() + " " + this.getWeight();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
}
