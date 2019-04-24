package cn.cxd.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;

public class ConnectionPool {

	private static LinkedList<Connection> connectionQueue;

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public synchronized static Connection getConnection() {

		if (connectionQueue == null) {
			connectionQueue = new LinkedList<Connection>();
			for (int i = 0; i < 5; i++) {
				try {
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cxd", "root",
							"96468223");
					connectionQueue.push(conn);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return connectionQueue.poll();
	}

	public static void returnConnection(Connection conn) {
		connectionQueue.push(conn);
	}
}
