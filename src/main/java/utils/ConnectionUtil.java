package utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ConnectionUtil {

	public static Connection getConnection() throws Exception {
		InitialContext initContext = new InitialContext();
		DataSource dataSource = (DataSource) initContext.lookup("java:comp/env/jdbc/NetCracker_2");
		Connection connection = dataSource.getConnection();
		return connection;
	}

	public static void closeAll(Connection Connection, Statement Statement, ResultSet ResultSet) {
		closeResultSet(ResultSet);
		closeStatement(Statement);
		closeConnection(Connection);
	}

	public static void closeConnection(Connection connection) {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new RuntimeException();
			}
		}
	}

	public static void closeStatement(Statement statement) {
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				throw new RuntimeException();
			}
		}
	}

	public static void closeResultSet(ResultSet ResultSet) {
		if (ResultSet != null) {
			try {
				ResultSet.close();
			} catch (SQLException e) {
				throw new RuntimeException();
			}
		}
	}

}
