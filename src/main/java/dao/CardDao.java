package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entities.CardEntity;
import entities.UserEntity;
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
			ConnectionUtil.closeAll(connection, preparedStatement, resultSet);
		}
	}

	public List<CardEntity> findAllCards(UserEntity user) {
		String sql = "select card.id, card.bill_id , card.card_type_id, card.status, bill.money, card.validity from"
				+ " card,bill,user where user.email = ? and user.password = ?; ";
		List<CardEntity> listOfCards = new ArrayList<>();

		try {
			connection = ConnectionUtil.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, user.getEmail());
			preparedStatement.setString(2, user.getPassword());
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				CardEntity cardEntity = new CardEntity();
				cardEntity.setId(resultSet.getInt("id"));
				cardEntity.setBillId(resultSet.getInt("bill_id"));
				cardEntity.setCardType(resultSet.getInt("card.card_type_id"));
				cardEntity.setStatus(resultSet.getBoolean("status"));
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

	public void blockCard(CardEntity card) {
		String sql = "update card set status = false where card.id = ?;";
		try {
			connection = ConnectionUtil.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, card.getId());
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			// TODO Logger
			System.err.println(e);
		} finally {
			ConnectionUtil.closeAll(connection, preparedStatement, resultSet);
		}
	}

	public void unBlockCard(CardEntity card) {
		String sql = "update card set status = true where card.id = ?;";
		try {
			connection = ConnectionUtil.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, card.getId());
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			// TODO Logger
			System.err.println(e);
		} finally {
			ConnectionUtil.closeAll(connection, preparedStatement, resultSet);
		}
	}

	public void delete(CardEntity card) {
		String sql = "delete from card where card.id = ?;";
		try {
			connection = ConnectionUtil.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, card.getId());
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			// TODO Logger
			System.err.println(e);
		}
	}
}
