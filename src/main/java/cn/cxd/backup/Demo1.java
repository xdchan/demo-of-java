package cn.cxd.backup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 备份步骤： 1.获取库下面所有的表 2.对于获取的表，首先获取其建表语句，将建表语句写入脚本文件；然后再获取表中的数据，将数据写入脚本文件。
 * 
 * @author Leon
 *
 */
public class Demo1 {

	Connection conn = BackMysqlData.conn;

	public static void main(String[] args) throws SQLException {
		String sql = "show tables";
		Connection conn = BackMysqlData.conn;
		PreparedStatement ps = conn.prepareStatement(sql);

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			System.out.println(rs.getString(1));
		}
	}

	public void method() throws SQLException {

		String sql = "show tables";
		ResultSet rs = getResultSet(sql);

		while (rs.next()) {

			String tableName = rs.getString(1);
			backUpTable(tableName);

		}
	}

	private void backUpTable(String tableName) throws SQLException {

		String createTbSql = "show create table " + tableName;
		String backDataSql = "select * from " + tableName;

		ResultSet rs1 = getResultSet(createTbSql);
		@SuppressWarnings("unused")
		ResultSet rs2 = getResultSet(backDataSql);

		while (rs1.next()) {
			// String info
		}

	}

	private ResultSet getResultSet(String sql) throws SQLException {

		PreparedStatement ps = conn.prepareStatement(sql);

		ResultSet rs = ps.executeQuery();

		return rs;
	}
}
