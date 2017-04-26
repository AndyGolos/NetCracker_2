package actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.cardbeans.Card;
import beans.userbeans.User;
import entities.BillEntity;
import entities.CardEntity;
import services.BillService;
import services.CardService;

public class TransferMoneyAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		CardService cardService = new CardService();
		BillService billService = new BillService();

		int cardId = Integer.parseInt(request.getParameter("cardid"));
		String cardPassword = request.getParameter("cardpassword");
		String stringcardTransferId = request.getParameter("cardtransferid");
		String stringSumm = request.getParameter("summ");
		int summ = -1;
		int cardTransferId = -1;

		// TODO Работает Валидация
		boolean valid = true;
		CardEntity cardEntity = cardService.checkCard(cardId);

		if (!cardEntity.getPassword().equals(cardPassword)) {
			request.setAttribute("error", "incorrectpass");
			valid = false;
		}
		if (!valid) {
			return "formtransferpage";
		}

		try {
			cardTransferId = Integer.parseInt(stringcardTransferId);
		} catch (NumberFormatException e) {
			request.setAttribute("error", "incorrectcardid");
			valid = false;
		}
		if (!valid) {
			return "formtransferpage";
		}

		CardEntity cardEntity2 = cardService.checkCard(cardTransferId);
		if (cardEntity2 == null) {
			request.setAttribute("error", "unexsistcard");
			valid = false;
		}
		if (!valid) {
			return "formtransferpage";
		}

		try {
			summ = Integer.parseInt(stringSumm);
		} catch (Exception e) {
			request.setAttribute("error", "incorrectsumm");
			valid = false;
		}
		if (!valid) {
			return "formtransferpage";
		}

		if (summ <= 0) {
			request.setAttribute("error", "incorrectsumm");
			valid = false;
		}
		if (!valid) {
			return "formtransferpage";
		}

		BillEntity billEntity = billService.find(cardEntity.getBillId());
		System.out.println(billEntity.getMoney());
		if ((billEntity.getMoney() - summ) < 0) {
			request.setAttribute("error", "lowmoney");
			valid = false;
		}
		if (!valid) {
			return "formtransferpage";
		}
		// --------------------------------

		cardService.replenishCard(cardId, cardPassword, cardTransferId, summ);

		// Карточки
		User user = (User) request.getSession().getAttribute("user");
		List<Card> cardlist = cardService.findAllUsersCards(user);

		request.getSession().setAttribute("cards", cardlist);
		return "userpage";
	}
}
