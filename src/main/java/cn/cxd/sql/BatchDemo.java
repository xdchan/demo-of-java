package cn.cxd.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import cn.cxd.tools.JdbcTools;

public class BatchDemo {

	public static void main(String[] args) {

		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/study";
		String user = "root";
		String passwd = "96468223";

		Connection conn = null;
		Statement stmt = null;

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, passwd);
			conn.setAutoCommit(false);

			stmt = conn.createStatement();
			for (int i = 0; i < 20000; i++) {
				stmt.addBatch("insert into t_user (username,pwd,regTime) values ('gao" + i + "',666666,now())");
			}

			stmt.executeBatch();
			conn.commit();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcTools.closeAll(conn, stmt);
		}
	}
}
