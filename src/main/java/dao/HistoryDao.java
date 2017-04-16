package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entities.CardEntity;
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
			// TODO Надо добавить не только год-месяц-день но и время операции
			preparedStatement.setDate(2, Date.valueOf(history.getOperationTime()));
			preparedStatement.setString(3, history.getValueChange());
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			// TODO Logger!
			System.err.println(e);
		} finally {
			ConnectionUtil.closeAll(connection, preparedStatement, resultSet);
		}
	}

	public List<UsageHistoryEntity> findAll(CardEntity card) {
		List<UsageHistoryEntity> listOfHistories = null;
		String sql = "select * from usage_history where usage_history.card_id = ?;";
		try {
			connection = ConnectionUtil.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, card.getId());
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				listOfHistories = new ArrayList<>();
				UsageHistoryEntity historyEntity = new UsageHistoryEntity();
				historyEntity.setId(resultSet.getInt("id"));
				historyEntity.setCardId(resultSet.getInt("card_id"));
				// TODO Надо добавить не только год-месяц-день но и время
				// операции
				historyEntity.setOperationTime(resultSet.getDate("operation_time").toLocalDate());
				historyEntity.setValueChange(resultSet.getString("value_change"));
				listOfHistories.add(historyEntity);
			}
		} catch (Exception e) {
			// TODO Logger!
			System.err.println(e);
		} finally {
			ConnectionUtil.closeAll(connection, preparedStatement, resultSet);
		}
		return listOfHistories;
	}

}
