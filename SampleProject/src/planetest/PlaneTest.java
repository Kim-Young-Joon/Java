package planetest;

public class PlaneTest {
	public static void infoPlane(Plane p, Plane s) {
		System.out.println("  Plane" + "\t\t" + "fuelSize");
		System.out.println("--------------------------");
		System.out.println("  " + p.getPlaneName() + "\t\t" + p.getFuelSize());
		System.out.println("  " + s.getPlaneName() + "\t\t" + s.getFuelSize());
	}

	public static void main(String[] args) {
		Airplane airplane = new Airplane("L747", 1000);
		Cargoplane cargoplane = new Cargoplane("C40", 1000);

		infoPlane(airplane, cargoplane);

		System.out.println("\n100 운항");
		airplane.flight(100);
		cargoplane.flight(100);
		infoPlane(airplane, cargoplane);

		System.out.println("\n200 주유");
		airplane.refuel(200);
		cargoplane.refuel(200);
		infoPlane(airplane, cargoplane);
	}
}