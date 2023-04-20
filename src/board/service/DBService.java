package board.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBService {
	public Connection connect() {
		Connection con = null;
		try {

			Class.forName("org.mariadb.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/board", "root", "1234");
		} catch (Exception e) {
		}
		return con;
	}

	public void disconnect(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
