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
		int userId = userDao.add(userEntity);
		roleDao.add(userId);
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
		UserEntity registeredEntity = userDao.find(user);
		if (!registeredEntity.getPassword().equals(user.getPassword())) {
			return null;
		} else
			return registeredEntity;
	}

	public List<User> findAllUsers() {

		List<User> users = new ArrayList<>();

		User userbean = null;
		UserRole userRole = null;

		List<UserEntity> userEntities = userDao.findAllUsers();
		List<RoleEntity> roleEntity = null;
		List<UserRole> userRoles = null;

		for (UserEntity userEntity : userEntities) {
			userbean = new User();
			userbean.setId(userEntity.getId());
			userbean.setName(userEntity.getName());
			userbean.setSurname(userEntity.getSurname());
			userbean.setLastname(userEntity.getLastname());
			userbean.setPassword(userEntity.getPassword());
			userbean.setEmail(userEntity.getEmail());

			roleEntity = roleDao.find(userEntity.getId());

			userRoles = new ArrayList<>();

			for (RoleEntity role : roleEntity) {
				userRole = new UserRole();
				userRole.setId(role.getId());
				userRole.setRole(role.getRole());
				userRoles.add(userRole);
			}

			userbean.setRole(userRoles);
			userbean.setRegistration(userEntity.getRegistration());
			userbean.setDateOfBirth(userEntity.getDateOfBirth());
			users.add(userbean);
		}

		return users;

	}

}
