package planetest;

public class Cargoplane extends Plane {

	// constructors
	public Cargoplane() {

	}

	public Cargoplane(String planeName, int fuelSize) {
		super(planeName, fuelSize);
	}

	// method
	@Override
	public void flight(int distance) {
		int fuel = (distance / 10) * 50;
		this.setFuelSize(this.getFuelSize() - fuel);
	}
}
