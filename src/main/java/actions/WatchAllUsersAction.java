package actions;

import beans.User;
import services.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

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
