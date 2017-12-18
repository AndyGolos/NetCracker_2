package actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TransitionReplenishCardAction implements Action {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		Integer billId = Integer.parseInt(request.getParameter("billid"));
		Integer cardId = Integer.parseInt(request.getParameter("cardid"));

		request.getSession().setAttribute("cardid", cardId);
		request.getSession().setAttribute("billid", billId);
		return "replenishCardpage";
	}
}
