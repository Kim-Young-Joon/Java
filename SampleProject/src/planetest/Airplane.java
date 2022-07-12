package planetest;

public class Airplane extends Plane {
	
	// constructors
	public Airplane() {
		
	}
	public Airplane(String planeName, int fuelSize) {
		super(planeName, fuelSize);
	}
	
	// method
	@Override
	public void flight(int distance) {
		int fuel = (distance / 10) * 30;
		this.setFuelSize(this.getFuelSize() - fuel);
	}
}
