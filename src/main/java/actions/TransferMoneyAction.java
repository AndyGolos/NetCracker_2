package actions;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.cardbeans.Card;
import beans.userbeans.User;
import dao.BillDao;
import dao.HistoryDao;
import entities.BillEntity;
import entities.CardEntity;
import entities.UsageHistoryEntity;
import services.CardService;

public class TransferMoneyAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		CardService cardService = new CardService();

		// TODO валидация(остальное работает)
		int cardId = Integer.parseInt(request.getParameter("cardid"));
		String cardPassword = request.getParameter("cardpassword");
		int cardTransferId = Integer.parseInt(request.getParameter("cardtransferid"));
		int summ = Integer.parseInt(request.getParameter("summ"));

		// --------------------------------

		CardEntity cardEntity = cardService.checkCard(cardId);

		BillDao billDao = new BillDao();
		BillEntity billEntity = billDao.find(cardEntity.getBillId());

		billDao.setMoney(billEntity, -summ);

		HistoryDao historyDao = new HistoryDao();
		UsageHistoryEntity usageHistoryEntity = new UsageHistoryEntity();
		usageHistoryEntity.setCardId(cardId);
		usageHistoryEntity.setOperationTime(LocalDate.now());
		usageHistoryEntity.setValueChange(String.valueOf(-summ));
		historyDao.add(usageHistoryEntity);

		cardEntity = cardService.checkCard(cardTransferId);
		billEntity = billDao.find(cardEntity.getBillId());

		billDao.setMoney(billEntity, summ);

		usageHistoryEntity = new UsageHistoryEntity();
		usageHistoryEntity.setCardId(cardTransferId);
		usageHistoryEntity.setOperationTime(LocalDate.now());
		usageHistoryEntity.setValueChange("+" + summ);
		historyDao.add(usageHistoryEntity);
		// ----------------------------------------

		// Карточки
		User user = (User) request.getSession().getAttribute("user");
		List<Card> cardlist = cardService.findAllUsersCards(user);

		request.getSession().setAttribute("cards", cardlist);
		return "userpage";
	}
}
