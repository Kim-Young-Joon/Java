package com.computer;

public class Laptop extends Computer implements Graphic {

	public Laptop() {super();}
	public Laptop(String name, int cpu, int memory, int battery) {
		super(name, cpu, memory, battery);
	}
	
	@Override
	public double rendering(int size) {
		double result = (double)size / (this.getCpu()*this.getMemory()) * 20;
		return result;
	}

	@Override
	public void operate(int time) {
		int use = time/10;
		this.setBattery(this.getBattery() - use);
	}
}
