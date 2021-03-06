package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entities.CardTypeEntity;
import utils.ConnectionUtil;

public class CardTypeDao extends BaseDaoImpl {

	private static Connection connection = null;
	private static PreparedStatement preparedStatement = null;
	private static ResultSet resultSet = null;

	public List<CardTypeEntity> findAllTypes() {
		List<CardTypeEntity> listOfTypes = new ArrayList<>();
		String sql = "select * from card_type;";

		try {
			connection = ConnectionUtil.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				CardTypeEntity typeEntity = new CardTypeEntity();
				typeEntity.setId(resultSet.getInt("id"));
				typeEntity.setType(resultSet.getString("type"));
				System.out.println(resultSet.getString("type"));
				listOfTypes.add(typeEntity);
			}
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			ConnectionUtil.closeAll(connection, preparedStatement, resultSet);
		}

		return listOfTypes;
	}

	public String find(int id) {
		String sql = "select card_type.type from card_type where card_type.id = ?;";
		String type = "";

		try {
			connection = ConnectionUtil.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.first()) {
				type = resultSet.getString("type");
			}
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			ConnectionUtil.closeAll(connection, preparedStatement, resultSet);
		}
		return type;
	}
}
