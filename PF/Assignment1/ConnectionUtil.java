import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

	private static final String DB_URL = "jdbc:mysql://localhost:3306/vehicle_management_system";
	private static final String USER = "root";
	private static final String PASSWORD = "root";

	private Connection connection = null;

	public Connection getConnection() throws VehicleManagementException {

		/* register driver */
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new VehicleManagementException(
					"Could not establish connection");
		}

		/* open connection */
		try {
			connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

}
