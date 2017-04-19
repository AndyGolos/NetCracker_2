package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import entities.BillEntity;
import utils.ConnectionUtil;

public class BillDao extends BaseDaoImpl {

	private static Connection connection = null;
	private static PreparedStatement preparedStatement = null;
	private static ResultSet resultSet = null;

	// Было CardEntity
	public int add(String password) {
		String sql = "insert into bill (password) value (?);";
		int id = -1;
		try {
			connection = ConnectionUtil.getConnection();
			preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, password);
			preparedStatement.executeUpdate();

			resultSet = preparedStatement.getGeneratedKeys();
			if (resultSet != null && resultSet.next()) {
				id = resultSet.getInt(1);
			}

		} catch (Exception e) {
			// TODO Logger
			System.err.println(e);
		} finally {
			ConnectionUtil.closeAll(connection, preparedStatement, resultSet);
		}

		return id;
	}

	// Было CardEntity
	public BillEntity find(int billId) {
		BillEntity bill = null;
		String sql = "select * from bill where bill.id = ?;";
		try {
			connection = ConnectionUtil.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, billId);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				bill = new BillEntity();
				bill.setId(resultSet.getInt("id"));
				bill.setMoney(resultSet.getInt("money"));
				bill.setPassword(resultSet.getString("password"));
			}
		} catch (Exception e) {
			// TODO Logger
			System.err.println(e);
		} finally {
			ConnectionUtil.closeAll(connection, preparedStatement, resultSet);
		}
		return bill;
	}

	// Было BillEntity
	public void setMoney(BillEntity bill, int money) {
		String sqlset = "update bill set money = ? where bill.id = ?;";
		try {
			connection = ConnectionUtil.getConnection();
			preparedStatement = connection.prepareStatement(sqlset);
			preparedStatement.setInt(1, bill.getMoney() + money);
			preparedStatement.setInt(2, bill.getId());
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			// TODO Logger
			System.err.println(e);
		} finally {
			ConnectionUtil.closeAll(connection, preparedStatement, resultSet);
		}
	}
}
