package cn.cxd.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class ParseTableInfo2 {

	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/cxd";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "96468223";

	/**
	 * 加载驱动
	 */
	static {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println("can not load jdbc driver");
		}
	}

	/**
	 * 打开连接
	 * 
	 * @return
	 */
	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			System.out.println("get connection failure");
		}
		return conn;
	}

	/**
	 * 关闭连接
	 * 
	 * @param conn
	 */
	public static void closeConnection(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println("close connection failure");
			}
		}
	}

	public static void main(String[] args) throws Exception {

		Connection conn = getConnection();
		PreparedStatement ps = null;
		String sqlText = "select * from goods,member where goods.id=member.id";
		String viewText = "create view testView as " + sqlText;
		System.out.println(viewText);
		String sql2 = "select * from view";
		ps = conn.prepareStatement(viewText);
		ps = conn.prepareStatement(sql2);

		ResultSetMetaData rsmd = ps.getMetaData();
		int size = rsmd.getColumnCount();
		for (int i = 0; i < size; i++) {
			String name = rsmd.getColumnName(i + 1);
			String type = rsmd.getColumnTypeName(i + 1);
			System.out.println(name + "--->" + type);
		}

		closeConnection(conn);
	}

}
