package services;

import beans.Card;
import beans.CardBill;
import beans.CardType;
import beans.User;
import dao.BillDao;
import dao.CardDao;
import dao.CardTypeDao;
import dao.HistoryDao;
import entities.BillEntity;
import entities.CardEntity;
import entities.UsageHistoryEntity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

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

		Card cardbean;
		CardBill cardBill;
		CardType cardType;

		BillEntity billEntity;

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
		return cardDao.add(userId, billId, type, password, registration, validity);
	}

	public void unblockCard(int cardId) {
		cardDao.unBlockCard(cardId);
	}

	public CardEntity checkCard(int cardId) {
		return cardDao.find(cardId);
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
