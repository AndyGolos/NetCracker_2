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

	public void add(CardEntity card) {
		String sql = "insert into card (user_id,bill_id,card_type_id,password,registration,validity) values (?,?,?,?,?,?);";
		try {
			connection = ConnectionUtil.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, card.getUserId());
			preparedStatement.setInt(2, card.getBillId());
			preparedStatement.setInt(3, card.getCardType());
			preparedStatement.setString(4, card.getPassword());
			preparedStatement.setDate(5, Date.valueOf(card.getRegistration()));
			preparedStatement.setDate(6, Date.valueOf(card.getValidity()));
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			// TODO Logger!
			System.err.println(e);
		} finally {
			ConnectionUtil.closeAll(connection, preparedStatement, null);
		}
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
			// TODO Logger!
			System.err.println(e);
		} finally {
			ConnectionUtil.closeAll(connection, preparedStatement, null);
		}

		return cardEntity;
	}

	// Было UserEntity
	public List<CardEntity> findAllCards(int id) {
		CardEntity cardEntity = null;
		/*
		 * String sql =
		 * "select card.id, card.bill_id , card.card_type_id, card.status, bill.money, card.validity from"
		 * + " card,bill,user where user.email = ? and user.password = ?; ";
		 */

		/*
		 * String sql =
		 * "select card.id, card.bill_id , card.card_type_id, card.status, bill.money, card.validity from"
		 * + " card,bill,user where user.id = ?; ";
		 */

		String sql = "select * from  card where card.user_id = ?;";
		List<CardEntity> listOfCards = new ArrayList<>();

		try {
			connection = ConnectionUtil.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				System.out.println("carddao");
				cardEntity = new CardEntity();
				cardEntity.setId(resultSet.getInt("id"));
				cardEntity.setUserId(resultSet.getInt("user_id"));
				cardEntity.setBillId(resultSet.getInt("bill_id"));
				cardEntity.setCardType(resultSet.getInt("card_type_id"));
				cardEntity.setPassword(resultSet.getString("password"));
				cardEntity.setStatus(resultSet.getBoolean("status"));
				// System.out.println(resultSet.getBoolean("status"));
				cardEntity.setRegistration(resultSet.getDate("registration").toLocalDate());
				cardEntity.setValidity(resultSet.getDate("validity").toLocalDate());
				listOfCards.add(cardEntity);
			}
		} catch (Exception e) {
			// TODO Logger
			System.err.println(e);
		} finally {
			ConnectionUtil.closeAll(connection, preparedStatement, resultSet);
		}
		return listOfCards;
	}

	// Было CardEntity
	public void blockCard(int id) {
		String sql = "update card set status = false where card.id = ?;";
		try {
			connection = ConnectionUtil.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			// TODO Logger
			System.err.println(e);
		} finally {
			ConnectionUtil.closeAll(connection, preparedStatement, resultSet);
		}
	}

	// Было CardEntity
	public void unBlockCard(int cardId) {
		String sql = "update card set status = true where card.id = ?;";
		try {
			connection = ConnectionUtil.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, cardId);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			// TODO Logger
			System.err.println(e);
		} finally {
			ConnectionUtil.closeAll(connection, preparedStatement, resultSet);
		}
	}

	// Было CardEntity
	public void delete(int cardId) {
		String sql = "delete from card where card.id = ?;";
		try {
			connection = ConnectionUtil.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, cardId);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			// TODO Logger
			System.err.println(e);
		} finally {
			ConnectionUtil.closeAll(connection, preparedStatement, resultSet);
		}
	}
}
