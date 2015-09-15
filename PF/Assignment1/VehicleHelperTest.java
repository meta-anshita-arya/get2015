import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class VehicleHelperTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	// To test for vehicleHelper class
	public void testVehicleHelper() {
		// Check for creation of car or bike object
		Car car = new Car("abc", "xyz");
		Bike bike = new Bike("def", "asd");
		VehicleHelper.createVehicle("Car", "yes", "101");
		VehicleHelper.createVehicle("Bike", "yes", "1001");
		assertNotNull(car);
		assertNotNull(bike);
	}
}