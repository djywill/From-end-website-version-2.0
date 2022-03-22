package webpro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class pub_fun {
	public static Connection getConnection() {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/web_pro";
		Connection con = null;
		try {
			Class.forName(driver);
			try {
				con = DriverManager.getConnection(url, "root", "root");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return con;
	}
}
