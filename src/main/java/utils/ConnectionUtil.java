package utils;

import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionUtil {

	public static Connection getConnection() throws Exception {
		InitialContext initContext = new InitialContext();
		DataSource dataSource = (DataSource) initContext.lookup("java:comp/env/jdbc/NetCracker_2");
		return dataSource.getConnection();
	}

	public static void closeAll(Connection Connection, Statement Statement, ResultSet ResultSet) {
		closeResultSet(ResultSet);
		closeStatement(Statement);
		closeConnection(Connection);
	}

	private static void closeConnection(Connection connection) {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new RuntimeException();
			}
		}
	}

	private static void closeStatement(Statement statement) {
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				throw new RuntimeException();
			}
		}
	}

	private static void closeResultSet(ResultSet ResultSet) {
		if (ResultSet != null) {
			try {
				ResultSet.close();
			} catch (SQLException e) {
				throw new RuntimeException();
			}
		}
	}

}
