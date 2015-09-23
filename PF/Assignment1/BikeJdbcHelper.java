import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BikeJdbcHelper {

	public static void insertInBikeTable(Bike objBike)
			throws VehicleManagementException {
		Connection con = null;
		Statement stmt = null;
		PreparedStatement ps = null;
		ConnectionUtil conUtil = new ConnectionUtil();
		/* creates connection to db */
		con = conUtil.getConnection();
		ResultSet rs = null;

		String query = "INSERT INTO Vehicle (make, model, engine_in_cc, fuel_capacity, milage, price, road_tax) VALUES (?,?,?,?,?,?,?)";

		try {
			ps = (PreparedStatement) con.prepareStatement(query);
			/* set variable in prepared statement */
			ps.setString(1, objBike.getMake());
			ps.setString(2, objBike.getModel());
			ps.setDouble(3, objBike.getEngineInCC());
			ps.setDouble(4, objBike.getFuelCapacity());
			ps.setDouble(5, objBike.getMilage());
			ps.setDouble(6, objBike.getPrice());
			ps.setDouble(7, objBike.getRoadTax());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		ps = null;

		String query1 = "SELECT make FROM Vehicle";
		String query2 = "INSERT INTO Bike ( self_start, helmet_price, vehicle_id ) VALUES (?,?,?)";

		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(query1);
			int vehicle_id = 0;
			while (rs.next())
				vehicle_id += 1;
			System.out.println(vehicle_id);
			ps = (PreparedStatement) con.prepareStatement(query2);
			/* set variable in prepared statement */
			ps.setBoolean(1, objBike.getSelfStart());
			ps.setDouble(2, objBike.getHelmetPrice());
			ps.setInt(3, vehicle_id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			/* close connection */
			try {
				if (con != null) {
					con.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
