package utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtil {
	private static String driverClassName;
	private static String url;
	private static String user;
	private static String password;

	static {
		try {

			// 读取 db.properties 文件中的数据
			InputStream in = JdbcUtil.class.getClassLoader()
					.getResourceAsStream("db.properties");
			Properties props = new Properties();
			props.load(in);
			String driverClassName = props.getProperty("driverClassName");
			user = props.getProperty("user");
			url = props.getProperty("url");
			password = props.getProperty("password");
			Class.forName(driverClassName);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws Exception {
		return (Connection) DriverManager.getConnection(url, user, password);
	}

	public static void release(ResultSet rs, Statement stmt, Connection conn) {

		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			rs = null;
		}
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			stmt = null;
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
