package actions;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.cardbeans.Card;

public class TransitionTransferMoneyAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// Наши счета, на которые зарегестрированы карточки
		@SuppressWarnings("unchecked")
		List<Card> listOfUserCards = (List<Card>) request.getSession().getAttribute("cards");

		Set<Integer> cardsIds = new HashSet<>();

		for (Card card : listOfUserCards) {
			cardsIds.add(card.getId());
		}

		request.getSession().setAttribute("cardsIds", cardsIds);
		return "formtransferpage";
	}

}
