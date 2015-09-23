
import java.util.List;

public class VehicleRead {
	public static void main(String args[]) throws VehicleManagementException {
		StaxParser objSaxParser = new StaxParser();
		String filePath = "C://javaprg/eclipse/CaseStudy2_1/src/vehicles/vehicle.xml";
		List<Vehicle> readVehicleFromConfig = objSaxParser.readConfig(filePath);
		for (Vehicle objVehicle : readVehicleFromConfig) {
			System.out.println(objVehicle);
			if (objVehicle instanceof Car)
				CarJdbcHelper.insertInCarTable(((Car) objVehicle));
			else
				BikeJdbcHelper.insertInBikeTable(((Bike) objVehicle));
		}
	}
}
