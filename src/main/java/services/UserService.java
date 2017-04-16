package services;

import dao.RoleDao;
import dao.UserDao;
import entities.UserEntity;

public class UserService {

	public boolean addUser(UserEntity user) {
		boolean addUser = true;
		UserDao userDao = new UserDao();
		RoleDao roleDao = new RoleDao();
		UserEntity registeredEntity = userDao.find(user);

		if (registeredEntity != null) {
			return !addUser;
		} else {
			userDao.add(user);
			roleDao.add(user);
			return addUser;
		}

	}

}
