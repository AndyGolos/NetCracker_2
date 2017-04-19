package services;

import java.util.ArrayList;
import java.util.List;

import beans.UserRole;
import beans.userbeans.User;
import dao.RoleDao;
import dao.UserDao;
import entities.RoleEntity;
import entities.UserEntity;

public class UserService {
	private UserDao userDao;
	private RoleDao roleDao;

	public UserService() {
		userDao = new UserDao();
		roleDao = new RoleDao();
	}

	public void addUser(UserEntity userEntity) {
		userDao.add(userEntity);
		roleDao.add(userEntity);
	}

	public User findUserInfo(UserEntity userEntity) {

		List<UserRole> userRoles = new ArrayList<>();
		User userbean = new User();
		UserRole userRole = null;

		UserEntity currentEntity = userDao.find(userEntity);

		userbean.setId(currentEntity.getId());
		userbean.setName(currentEntity.getName());
		userbean.setSurname(currentEntity.getSurname());
		userbean.setLastname(currentEntity.getLastname());
		userbean.setPassword(currentEntity.getPassword());
		userbean.setEmail(currentEntity.getEmail());

		List<RoleEntity> roleEntity = roleDao.find(currentEntity.getId());

		for (RoleEntity role : roleEntity) {
			userRole = new UserRole();
			userRole.setId(role.getId());
			userRole.setRole(role.getRole());
			userRoles.add(userRole);
		}

		userbean.setRole(userRoles);
		userbean.setRegistration(currentEntity.getRegistration());
		userbean.setDateOfBirth(currentEntity.getDateOfBirth());

		return userbean;
	}

	public UserEntity checkUser(UserEntity user) {
		UserDao userDao = new UserDao();
		UserEntity registeredEntity = userDao.find(user);

		if (registeredEntity != null) {
			return registeredEntity;
		} else {
			return null;
		}
	}

}
