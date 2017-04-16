package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import entities.BillEntity;
import entities.CardEntity;
import utils.ConnectionUtil;

public class BillDao extends BaseDaoImpl {

	private static Connection connection = null;
	private static PreparedStatement preparedStatement = null;
	private static ResultSet resultSet = null;

	public void add(BillEntity bill) {
		String sql = "insert into bill (money,password) value (?,?);";
		try {
			connection = ConnectionUtil.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, 0);
			preparedStatement.setString(1, bill.getPassword());
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			// TODO Logger
			System.err.println(e);
		} finally {
			ConnectionUtil.closeAll(connection, preparedStatement, resultSet);
		}
	}

	public BillEntity find(CardEntity card) {
		BillEntity bill = null;
		String sql = "select * from bill where bill.id = ?;";
		try {
			connection = ConnectionUtil.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, card.getBillId());
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
		}
		return bill;
	}

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
		}
	}
}
