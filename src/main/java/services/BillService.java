package services;

import dao.BillDao;
import dao.HistoryDao;
import entities.BillEntity;
import entities.UsageHistoryEntity;

public class BillService {

	private BillDao billDao;
	private HistoryDao historyDao;

	public BillService() {
		billDao = new BillDao();
		historyDao = new HistoryDao();
	}

	public int addBill(int password) {
		int billId = billDao.add(password);
		return billId;
	}

	public void replenishBill(int billId, int summ, int cardId) {

		BillEntity billEntity = billDao.find(billId);
		billDao.setMoney(billEntity, summ);

		UsageHistoryEntity historyEntity = new UsageHistoryEntity();
		historyEntity.setCardId(cardId);
		historyEntity.setValueChange("+" + summ);
		historyDao.add(historyEntity);
	}

	public BillEntity find(int billId) {
		return billDao.find(billId);
	}

}
