package com.computer;

public class Tab extends Computer implements Graphic {

	public Tab() {super();}
	public Tab(String name, int cpu, int memory, int battery) {
		super(name, cpu, memory, battery);
	}

	@Override
	public double rendering(int size) {
		double result = (double)size / (this.getCpu()*this.getMemory()) * 30;
		return result;
	}

	@Override
	public void operate(int time) {
		int use = time/5;
		this.setBattery(this.getBattery() - use);
	}
}
