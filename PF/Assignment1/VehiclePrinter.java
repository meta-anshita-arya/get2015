//vehicle class
public class VehiclePrinter {

	// to print vehicle detail
	public static String printVehicleSpecification(Vehicle vehicle) {
		String result = "{make" + ":" + vehicle.make + "," + "model:"
				+ vehicle.model + "}";
		return result;
	}

}
