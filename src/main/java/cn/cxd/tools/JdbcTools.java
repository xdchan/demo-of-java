package cn.cxd.tools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcTools {

	public static void closeAll(Connection conn, PreparedStatement ps) {
		JdbcTools.closeAll(conn, ps, null, null);
	}

	public static void closeAll(Connection conn, Statement stmt) {
		JdbcTools.closeAll(conn, null, stmt, null);
	}

	public static void closeAll(Connection conn, PreparedStatement ps, ResultSet rs) {
		JdbcTools.closeAll(conn, ps, null, rs);
	}

	public static void closeAll(Connection conn, Statement st, ResultSet rs) {
		JdbcTools.closeAll(conn, null, st, rs);
	}

	private static void closeAll(Connection conn, PreparedStatement ps, Statement st, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
