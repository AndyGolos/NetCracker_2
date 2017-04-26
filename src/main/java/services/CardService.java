package services;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import beans.CardBill;
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

	public List<Card> findAllUsersCards(User user) {

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

	public int addCard(int userId, int billId, int type, String password, Date registration, Date validity) {
		int cardId = cardDao.add(userId, billId, type, password, registration, validity);
		return cardId;
	}

	public void unblockCard(int cardId) {
		cardDao.unBlockCard(cardId);
	}

	public CardEntity checkCard(int cardId) {
		CardEntity cardEntity = cardDao.find(cardId);
		return cardEntity;
	}

	public void blockCard(int cardId) {
		cardDao.blockCard(cardId);
	}

	public void replenishCard(int cardId, String cardPassword, int cardTransferId, int summ) {
		CardEntity cardEntity = checkCard(cardId);

		BillEntity billEntity = billDao.find(cardEntity.getBillId());

		billDao.setMoney(billEntity, -summ);

		UsageHistoryEntity usageHistoryEntity = new UsageHistoryEntity();
		usageHistoryEntity.setCardId(cardId);
		usageHistoryEntity.setValueChange(String.valueOf(-summ));
		historyDao.add(usageHistoryEntity);

		cardEntity = checkCard(cardTransferId);
		billEntity = billDao.find(cardEntity.getBillId());

		billDao.setMoney(billEntity, summ);

		usageHistoryEntity = new UsageHistoryEntity();
		usageHistoryEntity.setCardId(cardTransferId);
		usageHistoryEntity.setValueChange("+" + summ);
		historyDao.add(usageHistoryEntity);
	}

}
