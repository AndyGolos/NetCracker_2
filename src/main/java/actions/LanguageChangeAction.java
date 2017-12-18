package actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LanguageChangeAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String language = request.getParameter("lang");
		String page = request.getParameter("page");
		request.getSession().setAttribute("language", language);
		return page;
	}
}
