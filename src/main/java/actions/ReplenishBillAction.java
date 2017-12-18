package actions;

import beans.Card;
import beans.User;
import entities.CardEntity;
import services.BillService;
import services.CardService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ReplenishBillAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		CardService cardService = new CardService();
		BillService billService = new BillService();

		int billId = Integer.parseInt(request.getParameter("billid"));
		String stringSumm = request.getParameter("summ");
		int cardId = Integer.parseInt(request.getParameter("cardid"));
		String password = request.getParameter("password");
		int summ = -1;

		boolean valid = true;
		try {
			summ = Integer.parseInt(stringSumm);
		} catch (NumberFormatException e) {
			request.setAttribute("error", "format");
			valid = false;
		}

		if (!valid) {
			return "replenishCardpage";
		}

		if (summ <= 0) {
			request.setAttribute("error", "format");
			valid = false;
		}

		if (!valid) {
			return "replenishCardpage";
		}

		CardEntity cardEntity = cardService.checkCard(cardId);

		if (!cardEntity.getPassword().equals(password)) {
			request.setAttribute("error", "password");
			valid = false;
		}

		if (!valid) {
			return "replenishCardpage";
		}
		// -----------------------

		// Пополняем счёт
		billService.replenishBill(billId, summ, cardId);

		User user = (User) request.getSession().getAttribute("user");
		List<Card> cardlist = cardService.findAllUsersCards(user);

		request.getSession().setAttribute("cards", cardlist);
		return "userpage";
	}

}
