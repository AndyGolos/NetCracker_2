package actions;

import java.time.LocalDate;
import java.util.ArrayList;
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

public class ReplenishBillAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		CardService cardService = new CardService();

		int billId = Integer.parseInt(request.getParameter("billid"));
		int summ = Integer.parseInt(request.getParameter("summ"));
		int cardid = Integer.parseInt(request.getParameter("cardid"));

		// --------------------------------------------------------------------
		BillDao billDao = new BillDao();
		BillEntity billEntity = billDao.find(billId);
		billDao.setMoney(billEntity, summ);

		HistoryDao historyDao = new HistoryDao();
		UsageHistoryEntity historyEntity = new UsageHistoryEntity();
		historyEntity.setCardId(cardid);
		historyEntity.setOperationTime(LocalDate.now());
		historyEntity.setValueChange("+" + summ);
		historyDao.add(historyEntity);
		// --------------------------------------------------------------------

		List<Card> cardlist = new ArrayList<>();
		User user = (User) request.getSession().getAttribute("user");
		cardlist = cardService.findAllUsersCards(user);

		request.getSession().setAttribute("cards", cardlist);
		return "userpage";
	}

}
