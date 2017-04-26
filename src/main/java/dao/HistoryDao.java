package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.UsageHistoryEntity;
import utils.ConnectionUtil;

public class HistoryDao extends BaseDaoImpl {

	private static Connection connection = null;
	private static PreparedStatement preparedStatement = null;
	private static ResultSet resultSet = null;

	public void add(UsageHistoryEntity history) {
		String sql = "insert into usage_history (card_id,operation_time,value_change) values (?,?,?);";

		try {
			connection = ConnectionUtil.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, history.getCardId());
			preparedStatement.setTimestamp(2, new Timestamp(new Date().getTime()));
			preparedStatement.setString(3, history.getValueChange());
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			ConnectionUtil.closeAll(connection, preparedStatement, null);
		}
	}

	public List<UsageHistoryEntity> findAll(int id) {
		List<UsageHistoryEntity> listOfHistories = new ArrayList<>();
		String sql = "select * from usage_history where usage_history.card_id = ?;";
		try {
			connection = ConnectionUtil.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				UsageHistoryEntity historyEntity = new UsageHistoryEntity();
				historyEntity.setId(resultSet.getInt("id"));
				historyEntity.setCardId(resultSet.getInt("card_id"));
				historyEntity.setOperationTime(resultSet.getTimestamp("operation_time"));
				historyEntity.setValueChange(resultSet.getString("value_change"));
				listOfHistories.add(historyEntity);
			}
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			ConnectionUtil.closeAll(connection, preparedStatement, resultSet);
		}
		return listOfHistories;
	}

}
