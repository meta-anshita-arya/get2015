//Class to create vehicle
public class VehicleHelper {
	// Function to create vehicle,car and bike object
	public static Vehicle createVehicle(VehicleType vehicleType, String make,
			String model) {
		Vehicle vehicle;
		if (VehicleType.CAR.equals(vehicleType)) {
			vehicle = new Car();

		} else {

			vehicle = new Bike();

		}
		vehicle.setModel(model);
		vehicle.setMake(make);
		return vehicle;
	}

}
