package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entities.RoleEntity;
import utils.ConnectionUtil;

public class RoleDao extends BaseDaoImpl {

	private static Connection connection = null;
	private static PreparedStatement preparedStatement = null;
	private static ResultSet resultSet = null;

	public void add(int userId) {
		String sql = "insert into user_roles (user_id,role_id) values (?, 1);";
		try {
			connection = ConnectionUtil.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, userId);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			ConnectionUtil.closeAll(connection, preparedStatement, resultSet);
		}
	}

	public List<RoleEntity> find(int id) {
		List<RoleEntity> roleList = new ArrayList<>();
		String sql = "select role.id, role.role from role left join user_roles on role.id = user_roles.role_id where user_id = ?;";

		try {
			connection = ConnectionUtil.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				RoleEntity entity = new RoleEntity();
				entity.setId(resultSet.getInt("id"));
				entity.setRole(resultSet.getString("role"));
				roleList.add(entity);
			}
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			ConnectionUtil.closeAll(connection, preparedStatement, resultSet);
		}
		return roleList;
	}
}
