import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BikeJdbcHelper {

	public static void insertInBikeTable(Bike objBike)
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
			preparedStatement = (PreparedStatement) connection.prepareStatement(query);
			/* set variable in prepared statement */
			preparedStatement.setString(1, objBike.getMake());
			preparedStatement.setString(2, objBike.getModel());
			preparedStatement.setDouble(3, objBike.getEngineInCC());
			preparedStatement.setDouble(4, objBike.getFuelCapacity());
			preparedStatement.setDouble(5, objBike.getMilage());
			preparedStatement.setDouble(6, objBike.getPrice());
			preparedStatement.setDouble(7, objBike.getRoadTax());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		preparedStatement = null;

		String query1 = "SELECT make FROM Vehicle";
		String query2 = "INSERT INTO Bike ( self_start, helmet_price, vehicle_id ) VALUES (?,?,?)";

		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query1);
			int vehicle_id = 0;
			while (resultSet.next())
				vehicle_id += 1;
			System.out.println(vehicle_id);
			preparedStatement = (PreparedStatement) connection.prepareStatement(query2);
			/* set variable in prepared statement */
			preparedStatement.setBoolean(1, objBike.getSelfStart());
			preparedStatement.setDouble(2, objBike.getHelmetPrice());
			preparedStatement.setInt(3, vehicle_id);
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
