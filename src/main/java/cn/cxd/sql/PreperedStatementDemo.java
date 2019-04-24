package cn.cxd.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.cxd.tools.JdbcTools;

public class PreperedStatementDemo {

	public final static String DRIVER = "com.mysql.jdbc.Driver";
	public final static String URL = "jdbc:mysql://localhost:3306/study";
	public final static String USER = "root";
	public final static String PASSWD = "96468223";

	public static void main(String[] args) {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USER, PASSWD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// 增
		// insert(conn, ps);

		// 删
		// String id = "6";
		// delete(conn, ps, id);

		// 改
		// String name = "ear";
		// int id = 4;
		// update(conn, ps, id, name);

		// 查
		select(conn, ps, rs);

		JdbcTools.closeAll(conn, ps, rs);

	}

	public static void select(Connection conn, PreparedStatement ps, ResultSet rs) {

		String sql = "select * from student";
		System.out.println("id-name-age-place");
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				int age = rs.getInt(3);
				String place = rs.getString(4);
				System.out.println(id + "," + name + "," + age + "," + place);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void update(Connection conn, PreparedStatement ps, int id, String name) {

		String sql = "update student set id = ? where name = ?";
		System.out.println(sql);
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void delete(Connection conn, PreparedStatement ps, String id) {

		String sql = "delete from student where id = ? ";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void insert(Connection conn, PreparedStatement ps) {

		String sql = "insert into student (name, age, place) values (?,?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, "file");
			ps.setInt(2, 27);
			ps.setString(3, "东京");
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
