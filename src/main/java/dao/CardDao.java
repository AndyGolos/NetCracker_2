package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entities.CardEntity;
import utils.ConnectionUtil;

public class CardDao extends BaseDaoImpl {

	private static Connection connection = null;
	private static PreparedStatement preparedStatement = null;
	private static ResultSet resultSet = null;

	public int add(int userId, int billId, int type, String password, Date registration, Date validity) {
		int id = -1;
		String sql = "insert into card (user_id,bill_id,card_type_id,password,registration,validity) values (?,?,?,?,?,?);";
		try {
			connection = ConnectionUtil.getConnection();
			preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			preparedStatement.setInt(1, userId);
			preparedStatement.setInt(2, billId);
			preparedStatement.setInt(3, type);
			preparedStatement.setString(4, password);
			preparedStatement.setDate(5, registration);
			preparedStatement.setDate(6, validity);
			preparedStatement.executeUpdate();

			resultSet = preparedStatement.getGeneratedKeys();

			if (resultSet != null && resultSet.next()) {
				id = resultSet.getInt(1);
			}
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			ConnectionUtil.closeAll(connection, preparedStatement, resultSet);
		}

		return id;
	}

	public CardEntity find(int cardid) {
		String sql = "select * from card where card.id = ?;";
		CardEntity cardEntity = null;

		try {
			connection = ConnectionUtil.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, cardid);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				cardEntity = new CardEntity();
				cardEntity.setId(resultSet.getInt("id"));
				cardEntity.setUserId(resultSet.getInt("user_id"));
				cardEntity.setBillId(resultSet.getInt("bill_id"));
				cardEntity.setCardType(resultSet.getInt("card_type_id"));
				cardEntity.setPassword(resultSet.getString("password"));
				cardEntity.setStatus(resultSet.getBoolean("status"));
				cardEntity.setRegistration(resultSet.getDate("registration").toLocalDate());
				cardEntity.setValidity(resultSet.getDate("validity").toLocalDate());
			}
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			ConnectionUtil.closeAll(connection, preparedStatement, resultSet);
		}

		return cardEntity;
	}

	public List<CardEntity> findAllCards(int id) {
		CardEntity cardEntity = null;
		String sql = "select * from  card where card.user_id = ?;";
		List<CardEntity> listOfCards = new ArrayList<>();

		try {
			connection = ConnectionUtil.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				cardEntity = new CardEntity();
				cardEntity.setId(resultSet.getInt("id"));
				cardEntity.setUserId(resultSet.getInt("user_id"));
				cardEntity.setBillId(resultSet.getInt("bill_id"));
				cardEntity.setCardType(resultSet.getInt("card_type_id"));
				cardEntity.setPassword(resultSet.getString("password"));
				cardEntity.setStatus(resultSet.getBoolean("status"));
				cardEntity.setRegistration(resultSet.getDate("registration").toLocalDate());
				cardEntity.setValidity(resultSet.getDate("validity").toLocalDate());
				listOfCards.add(cardEntity);
			}
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			ConnectionUtil.closeAll(connection, preparedStatement, resultSet);
		}
		return listOfCards;
	}

	public void blockCard(int id) {
		String sql = "update card set status = false where card.id = ?;";
		try {
			connection = ConnectionUtil.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			ConnectionUtil.closeAll(connection, preparedStatement, resultSet);
		}
	}

	public void unBlockCard(int cardId) {
		String sql = "update card set status = true where card.id = ?;";
		try {
			connection = ConnectionUtil.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, cardId);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			ConnectionUtil.closeAll(connection, preparedStatement, resultSet);
		}
	}

	public void delete(int cardId) {
		String sql = "delete from card where card.id = ?;";
		try {
			connection = ConnectionUtil.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, cardId);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			ConnectionUtil.closeAll(connection, preparedStatement, resultSet);
		}
	}
}
