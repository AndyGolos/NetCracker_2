package actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.cardbeans.Card;
import beans.userbeans.User;
import services.CardService;

public class BlockCardAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		CardService cardService = new CardService();

		int cardId = Integer.parseInt(request.getParameter("block"));
		User user = (User) request.getSession().getAttribute("user");

		cardService.blockCard(cardId);

		List<Card> cardlist = cardService.findAllUsersCards(user);

		request.getSession().setAttribute("cards", cardlist);
		return "userpage";
	}

}
