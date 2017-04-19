package actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.CardHistory;
import services.CardService;

public class WatchUsageHistoryAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		CardService cardService = new CardService();

		int cardId = Integer.parseInt(request.getParameter("history"));

		// TODO История карточки? Возможно нужно создать и historyService
		List<CardHistory> cardHistories = cardService.findCardsHistory(cardId);

		request.getSession().setAttribute("histories", cardHistories);
		return "history";
	}

}
