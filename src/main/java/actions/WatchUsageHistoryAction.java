package actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.CardHistory;
import services.CardHistoryService;

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
