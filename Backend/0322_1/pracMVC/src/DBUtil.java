import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	private final String driverName = "com.mysql.cj.jdbc.Driver";
	private final String url = "jdbc:mysql://127.0.0.1:3307/ssafyweb?serverTimezone=UTC";
	private final String user = "ssafy";
	private final String pass = "369369";
	
	private static DBUtil instance = new DBUtil();
	
	private DBUtil() {
		try {
			Class.forName(driverName);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static DBUtil geInstance() {
		return instance;
	}
	
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url,user,pass);
	}
	
	
}
