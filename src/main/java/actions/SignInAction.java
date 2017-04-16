package actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SignInAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		if (request.getMethod().equals("GET")) {
			return "signin";
		} else
			return null;
	}
}
