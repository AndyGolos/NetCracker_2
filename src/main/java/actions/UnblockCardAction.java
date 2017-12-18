package actions;

import beans.Card;
import beans.User;
import entities.CardEntity;
import services.CardService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class UnblockCardAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		CardService cardService = new CardService();

		String stringCardId = request.getParameter("cardid");


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

		if (cardEntity.getStatus()) {
			request.setAttribute("error", "unblocked");
			valid = false;
		}

		if (!valid) {
			return "unblockCardpage";
		}
		// --------------------------------------

		cardService.unblockCard(cardId);

		User user = (User) request.getSession().getAttribute("user");
		List<Card> cardlist = cardService.findAllUsersCards(user);

		request.getSession().setAttribute("cards", cardlist);

		return "userpage";
	}
}
