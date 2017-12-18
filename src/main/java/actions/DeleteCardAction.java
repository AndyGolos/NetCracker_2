package actions;

import beans.Card;
import beans.User;
import dao.CardDao;
import entities.CardEntity;
import services.CardService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class DeleteCardAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		CardService cardService = new CardService();

		String stringCardId = request.getParameter("cardid");
		String password = request.getParameter("password");

		boolean valid = true;
		int cardId = 0;
		try {
			cardId = Integer.parseInt(stringCardId);
		} catch (NumberFormatException e) {
			request.setAttribute("error", "format");
			valid = false;
		}

		if (!valid) {
			return "deleteCardPage";
		}

		CardDao cardDao = new CardDao();
		CardEntity entity = cardDao.find(cardId);

		if (entity == null) {
			request.setAttribute("error", "id");
			return "deleteCardPage";
		} else {
			if (!entity.getPassword().equals(password)) {
				request.setAttribute("error", "password");
				valid = false;
			}
		}

		if (!valid) {
			return "deleteCardPage";
		}
		// ----------------------------------------------------------

		cardDao.delete(cardId);

		// Карточки
		User user = (User) request.getSession().getAttribute("user");
		List<Card> cardlist = cardService.findAllUsersCards(user);

		request.getSession().setAttribute("cards", cardlist);
		return "userpage";
	}
}
