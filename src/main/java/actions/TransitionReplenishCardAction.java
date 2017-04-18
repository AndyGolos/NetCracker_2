package actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TransitionReplenishCardAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		Integer billId = Integer.parseInt(request.getParameter("billid"));
		request.setAttribute("billid", billId);
		return "replenishCardpage";
	}

}
