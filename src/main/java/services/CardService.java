package services;

import java.util.ArrayList;
import java.util.List;

import beans.CardBill;
import beans.CardHistory;
import beans.CardType;
import beans.cardbeans.Card;
import beans.userbeans.User;
import dao.BillDao;
import dao.CardDao;
import dao.CardTypeDao;
import dao.HistoryDao;
import entities.BillEntity;
import entities.CardEntity;
import entities.UsageHistoryEntity;

public class CardService {

	private CardDao cardDao;
	private BillDao billDao;
	private CardTypeDao typeDao;
	private HistoryDao historyDao;

	public CardService() {
		cardDao = new CardDao();
		billDao = new BillDao();
		typeDao = new CardTypeDao();
		historyDao = new HistoryDao();
	}

	// Карточки
	public List<Card> findAllUsersCards(User user) {
		cardDao = new CardDao();
		billDao = new BillDao();
		typeDao = new CardTypeDao();

		Card cardbean = null;
		CardBill cardBill = null;
		CardType cardType = null;

		BillEntity billEntity = null;

		List<CardEntity> cardEntities = cardDao.findAllCards(user.getId());

		List<Card> cardlist = new ArrayList<>();
		for (CardEntity cardEntity : cardEntities) {
			cardbean = new Card();
			cardBill = new CardBill();
			cardType = new CardType();

			cardbean.setId(cardEntity.getId());
			cardbean.setPassword(cardEntity.getPassword());
			cardbean.setTimeOfRegistration(cardEntity.getRegistration());
			cardbean.setValidity(cardEntity.getValidity());
			cardbean.setStatus(cardEntity.getStatus());

			billEntity = billDao.find(cardEntity.getBillId());

			cardBill.setId(billEntity.getId());
			cardBill.setMoney(billEntity.getMoney());
			cardBill.setPassword(billEntity.getPassword());
			cardbean.setBill(cardBill);

			cardType.setType(typeDao.find(cardEntity.getCardType()));
			cardbean.setType(cardType);

			cardlist.add(cardbean);
		}

		return cardlist;
	}

	public List<CardHistory> findCardsHistory(int cardId) {

		CardHistory cardHistory = null;
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
