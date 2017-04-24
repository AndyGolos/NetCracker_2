package actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.cardbeans.Card;
import beans.userbeans.User;
import entities.CardEntity;
import services.CardService;

public class UnblockCardAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		CardService cardService = new CardService();

		String stringCardId = request.getParameter("cardid");

		// TODO Работает Валидация
		boolean valid = true;
		int cardId = 0;
		try {
			cardId = Integer.parseInt(stringCardId);
		} catch (NumberFormatException e) {
			request.setAttribute("error", "format");
			valid = false;
		}

		if (!valid) {
			return "unblockCardpage";
		}

		CardEntity cardEntity = cardService.checkCard(cardId);

		if (cardEntity == null) {
			request.setAttribute("error", "nocard");
			valid = false;
		}

		if (!valid) {
			return "unblockCardpage";
		}

		if (cardEntity.getStatus() == true) {
			request.setAttribute("error", "unblocked");
			valid = false;
		}

		if (!valid) {
			return "unblockCardpage";
		}
		// --------------------------------------

		cardService.unblockCard(cardId);

		// TODO Для проверки!!!!!!!! У админа не будет карточек!!!!!!

		User user = (User) request.getSession().getAttribute("user");
		List<Card> cardlist = cardService.findAllUsersCards(user);

		request.getSession().setAttribute("cards", cardlist);
		// -----------------------------------------------------DELETE
		return "userpage";
	}

}
