package actions;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.CardHistory;
import dao.HistoryDao;
import entities.UsageHistoryEntity;

public class WatchUsageHistoryAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		int cardId = Integer.parseInt(request.getParameter("history"));

		HistoryDao historyDao = new HistoryDao();
		List<UsageHistoryEntity> historylist = historyDao.findAll(cardId);

		CardHistory cardHistory = null;

		List<CardHistory> cardHistories = new ArrayList<>();

		for (UsageHistoryEntity usageHistoryEntity : historylist) {
			cardHistory = new CardHistory();
			cardHistory.setCardId(usageHistoryEntity.getCardId());
			cardHistory.setId(usageHistoryEntity.getId());
			cardHistory.setOperationTime(usageHistoryEntity.getOperationTime());
			cardHistory.setValueChange(usageHistoryEntity.getValueChange());
			cardHistories.add(cardHistory);
		}

		request.getSession().setAttribute("histories", cardHistories);

		return "history";
	}

}
