package services;

import beans.CardHistory;
import dao.HistoryDao;
import entities.UsageHistoryEntity;

import java.util.ArrayList;
import java.util.List;

public class CardHistoryService {

	private HistoryDao historyDao;

	public CardHistoryService() {
		historyDao = new HistoryDao();
	}

	public List<CardHistory> findCardsHistory(int cardId) {

		CardHistory cardHistory;
		List<CardHistory> cardHistories = new ArrayList<>();

		List<UsageHistoryEntity> historylist = historyDao.findAll(cardId);

		for (UsageHistoryEntity usageHistoryEntity : historylist) {
			cardHistory = new CardHistory();
			cardHistory.setCardId(usageHistoryEntity.getCardId());
			cardHistory.setId(usageHistoryEntity.getId());
			cardHistory.setOperationTime(usageHistoryEntity.getOperationTime());
			cardHistory.setValueChange(usageHistoryEntity.getValueChange());
			cardHistories.add(cardHistory);
		}
		return cardHistories;
	}
}
