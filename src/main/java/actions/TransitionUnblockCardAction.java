package actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TransitionUnblockCardAction implements Action {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		return "unblockCardpage";
	}
}
