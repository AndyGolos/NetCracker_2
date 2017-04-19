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
import entities.UsageHistoryEntity;
import services.CardService;

public class TransferMoneyAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		CardService cardService = new CardService();

		int billId = Integer.parseInt(request.getParameter("billid"));
		String billPassword = request.getParameter("billpassword");
		int billTransferId = Integer.parseInt(request.getParameter("billtransferid"));
		int summ = Integer.parseInt(request.getParameter("summ"));

		BillDao billDao = new BillDao();
		HistoryDao historyDao = new HistoryDao();
		UsageHistoryEntity historyEntity = new UsageHistoryEntity();

		BillEntity billEntity = billDao.find(billId);
		billDao.setMoney(billEntity, -summ);

		@SuppressWarnings("unchecked")
		List<Card> cardlist = (List<Card>) request.getSession().getAttribute("cards");

		for (Card card : cardlist) {
			if (card.getBill().getId() == billId) {
				historyEntity.setCardId(card.getId());
				break;
			}
		}

		historyEntity.setOperationTime(LocalDate.now());
		historyEntity.setValueChange(String.valueOf(-summ));
		historyDao.add(historyEntity);

		// -----------------------сняли

		billEntity = billDao.find(billTransferId);
		billDao.setMoney(billEntity, summ);

		historyEntity = new UsageHistoryEntity();
		for (Card card : cardlist) {
			if (card.getBill().getId() == billTransferId) {
				historyEntity.setCardId(card.getId());
				System.out.println(card.getId());
				break;
			}
		}

		historyEntity.setOperationTime(LocalDate.now());
		historyEntity.setValueChange(String.valueOf(+summ));
		historyDao.add(historyEntity);

		// Карточки
		User user = (User) request.getSession().getAttribute("user");
		cardlist = cardService.findAllUsersCards(user);

		request.getSession().setAttribute("cards", cardlist);
		return "userpage";
	}
}
