package actions;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.UserRole;
import beans.userbeans.User;
import dao.RoleDao;
import dao.UserDao;
import entities.RoleEntity;
import entities.UserEntity;

public class WatchAllUsersAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		UserDao userDao = new UserDao();
		RoleDao roleDao = new RoleDao();
		List<UserEntity> userEntities = userDao.findAllUsers();

		User userbean = null;
		// такое имя уже будет в сессии... подумать, мб изменить его
		List<User> users = new ArrayList<>();

		List<RoleEntity> roleEntity = null;
		List<UserRole> userRoles = null;
		UserRole userRole = null;

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

		request.getSession().setAttribute("users", users);

		return "allUserspage";
	}

}
