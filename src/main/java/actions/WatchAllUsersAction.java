package actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.userbeans.User;
import services.UserService;

public class WatchAllUsersAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		UserService userService = new UserService();

		// такое имя уже будет в сессии... подумать, мб изменить его
		List<User> users = userService.findAllUsers();

		request.getSession().setAttribute("users", users);
		return "allUserspage";
	}

}
