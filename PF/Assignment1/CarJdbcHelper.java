import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CarJdbcHelper {

	public static void insertInCarTable(Car objCar)
			throws VehicleManagementException {
		Connection connection = null;
		Statement statement = null;
		PreparedStatement preparedStatement = null;
		ConnectionUtil connectionUtil = new ConnectionUtil();
		/* creates connection to db */
		connection = connectionUtil.getConnection();
		ResultSet resultSet = null;

		String query = "INSERT INTO Vehicle (make, model, engine_in_cc, fuel_capacity, milage, price, road_tax) VALUES (?,?,?,?,?,?,?)";

		try {
			preparedStatement = (PreparedStatement) connection
					.prepareStatement(query);
			/* set variable in prepared statement */
			preparedStatement.setString(1, objCar.getMake());
			preparedStatement.setString(2, objCar.getModel());
			preparedStatement.setDouble(3, objCar.getEngineInCC());
			preparedStatement.setDouble(4, objCar.getFuelCapacity());
			preparedStatement.setDouble(5, objCar.getMilage());
			preparedStatement.setDouble(6, objCar.getPrice());
			preparedStatement.setDouble(7, objCar.getRoadTax());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		preparedStatement = null;

		String query1 = "SELECT make FROM Vehicle";
		String query2 = "INSERT INTO Car ( ac, power_steering, accessory_kit, vehicle_id ) VALUES (?,?,?,?)";

		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query1);
			int vehicle_id = 0;
			while (resultSet.next())
				vehicle_id += 1;
			System.out.println(vehicle_id);
			preparedStatement = (PreparedStatement) connection
					.prepareStatement(query2);
			/* set variable in prepared statement */
			preparedStatement.setBoolean(1, objCar.getAC());
			preparedStatement.setBoolean(2, objCar.getPowerSteering());
			preparedStatement.setBoolean(3, objCar.getAccessoryKit());
			preparedStatement.setInt(4, vehicle_id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			/* close connection */
			try {
				if (connection != null) {
					connection.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
