package planetest;

public abstract class Plane {
	// fields
	private String planeName;
	private int fuelSize;

	// constructors
	public Plane() {

	}

	public Plane(String planeName, int fuelSize) {
		this.planeName = planeName;
		this.fuelSize = fuelSize;
	}

	// methods
	public abstract void flight(int distance);

	public void refuel(int fuel) {
		this.setFuelSize(this.getFuelSize() + fuel);
	}

	public String getPlaneName() {
		return planeName;
	}

	public void setPlaneName(String planeName) {
		this.planeName = planeName;
	}

	public int getFuelSize() {
		return fuelSize;
	}

	public void setFuelSize(int fuelSize) {
		this.fuelSize = fuelSize;
	}
}
