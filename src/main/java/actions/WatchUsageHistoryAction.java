package actions;

import beans.CardHistory;
import services.CardHistoryService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class WatchUsageHistoryAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		CardHistoryService cardHistoryService = new CardHistoryService();

		int cardId = Integer.parseInt(request.getParameter("history"));

		List<CardHistory> cardHistories = cardHistoryService.findCardsHistory(cardId);

		request.getSession().setAttribute("histories", cardHistories);
		return "history";
	}
}
