package cn.cxd.backup;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BackMysqlData {

	public final static String dbName = "web_db";
	public final static String DRIVER = "com.mysql.jdbc.Driver";
	public final static String URL = "jdbc:mysql://localhost:3306/" + dbName;
	public final static String USER = "root";
	public final static String PASSWD = "96468223";
	public final static Connection conn = getConnection();

	static {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static Connection getConnection() {

		try {
			return DriverManager.getConnection(DRIVER, USER, PASSWD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
