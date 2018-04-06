package dbmodel;

import java.sql.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbconnection {

	private final String url = "jdbc:postgresql://localhost/qrcode";
	private final String user = "postgres";
	private final String password = "";
	private static Connection conn = null;

	public Connection connect() {

		try {
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("Connected to the PostgreSQL server successfully.");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return conn;
	}

	public void Closeconnection() {
		try {
			conn.close();
			System.out.println("close successfuly");
		} catch (SQLException e) {

			e.printStackTrace();

		}
	}

}
