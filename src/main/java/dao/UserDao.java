package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import entities.UserEntity;
import utils.ConnectionUtil;

public class UserDao extends BaseDaoImpl {

	private static Connection connection = null;
	private static PreparedStatement preparedStatement = null;
	private static ResultSet resultSet = null;

	public void add(UserEntity user) {
		String sql = "insert into user (name,surname,lastname,email,password,date_of_birth,registration) values (?,?,?,?,?,?,?);";

		try {
			connection = ConnectionUtil.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getSurname());
			preparedStatement.setString(3, user.getLastname());
			preparedStatement.setString(4, user.getEmail());
			preparedStatement.setString(5, user.getPassword());
			preparedStatement.setDate(6, Date.valueOf(user.getDateOfBirth()));
			preparedStatement.setDate(7, Date.valueOf(LocalDate.now()));
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			// TODO Logger
			System.err.println(e);
		} finally {
			ConnectionUtil.closeAll(connection, preparedStatement, resultSet);
		}

	}

	public List<UserEntity> findAllUsers() {
		String sql = "select * from user;";
		UserEntity userEntity = null;
		List<UserEntity> listOfUsers = new ArrayList<>();
		try {
			connection = ConnectionUtil.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();

			System.out.println(resultSet.getMetaData().getColumnCount());

			while (resultSet.next()) {
				userEntity = new UserEntity();
				userEntity.setId(resultSet.getInt("id"));
				userEntity.setSurname(resultSet.getString("surname"));
				userEntity.setName(resultSet.getString("name"));
				userEntity.setLastname(resultSet.getString("lastname"));
				userEntity.setEmail(resultSet.getString("email"));
				userEntity.setDateOfBirth(resultSet.getDate("date_of_birth").toLocalDate());
				userEntity.setRegistration(resultSet.getDate("registration").toLocalDate());
				listOfUsers.add(userEntity);
			}
		} catch (Exception e) {
			// TODO Logger
			System.err.println(e);
		} finally {
			ConnectionUtil.closeAll(connection, preparedStatement, resultSet);
		}

		System.out.println();
		return listOfUsers;
	}

	public UserEntity find(UserEntity user) {
		UserEntity userEntity = null;
		String sql = "select * from user where user.email = ? and user.password = ?;";

		try {
			connection = ConnectionUtil.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, user.getEmail());
			preparedStatement.setString(2, user.getPassword());
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				userEntity = new UserEntity();
				userEntity.setId(resultSet.getInt("id"));
				userEntity.setName(resultSet.getString("name"));
				userEntity.setSurname(resultSet.getString("surname"));
				userEntity.setLastname(resultSet.getString("lastname"));
				userEntity.setEmail(resultSet.getString("email"));
				userEntity.setPassword(resultSet.getString("password"));
				userEntity.setDateOfBirth(resultSet.getDate("date_of_birth").toLocalDate());
				userEntity.setRegistration(resultSet.getDate("registration").toLocalDate());
			}
		} catch (Exception e) {
			// TODO Logger
			System.err.println(e);
		} finally {
			ConnectionUtil.closeAll(connection, preparedStatement, resultSet);
		}

		return userEntity;
	}

}
