package net.patriciodossantos.MinhaEstante.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public Connection getConnection() {
		String url = "jdbc:mysql://localhost/minha_estante";
		try {
			return DriverManager.getConnection(url, "root", "root");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
