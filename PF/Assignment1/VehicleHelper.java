// creates instance of various vehicle classes

public class VehicleHelper {

	// creates instance of vehicle class
	public static Vehicle createVehicle(String vehicleType, String make,
			String model) {
		Vehicle vehicle;
		if (vehicleType.equals(VehicleType.Car))
			vehicle = new Car();
		else
			vehicle = new Bike();
		vehicle.setMake(make);
		vehicle.setModel(model);
		return vehicle;

	}

}
