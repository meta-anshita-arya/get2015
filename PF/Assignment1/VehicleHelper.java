//helper class
public class VehicleHelper {

	// to check whether car or bike input
	public static Vehicle createVehicle(String vehicleType, String make,
			String model) {
		if (vehicleType.equalsIgnoreCase("Car")) {
			Car car = new Car(make, model);
			return car;
		} else {
			Bike bike = new Bike(make, model);
			return bike;
		}
	}

}
