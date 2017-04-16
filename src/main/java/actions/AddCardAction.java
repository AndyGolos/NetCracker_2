package actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddCardAction implements Action {

	public String execute(HttpServletRequest request, HttpServletResponse response) {
		return "addCard";
	}

}
