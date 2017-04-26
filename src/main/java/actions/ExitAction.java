package actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExitAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		request.getSession().invalidate();
		return "signin";
	}

}
