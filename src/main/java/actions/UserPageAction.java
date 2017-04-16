package actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserPageAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		return "userpage";
	}
}
