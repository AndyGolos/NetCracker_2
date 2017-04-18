package actions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.CardType;
import beans.cardbeans.Card;
import dao.CardTypeDao;
import entities.CardTypeEntity;

public class CreateCardAction implements Action {

	public String execute(HttpServletRequest request, HttpServletResponse response) {

		// Наши счета, на которые зарегестрированы карточки
		@SuppressWarnings("unchecked")
		List<Card> listOfUserCards = (List<Card>) request.getSession().getAttribute("cards");
		Set<Integer> cardsBills = new HashSet<>();

		for (Card card : listOfUserCards) {
			cardsBills.add(card.getBill().getId());
		}

		request.getSession().setAttribute("cardsBills", cardsBills);

		// Наши типы карточек (все)
		CardTypeDao cardTypeDao = new CardTypeDao();

		List<CardType> cardTypes = new ArrayList<>();
		CardType cardType = null;
		List<CardTypeEntity> cardTypeEntities = cardTypeDao.findAllTypes();

		for (CardTypeEntity cardTypeEntity : cardTypeEntities) {
			cardType = new CardType();
			cardType.setId(cardTypeEntity.getId());
			cardType.setType(cardTypeEntity.getType());
			cardTypes.add(cardType);
		}

		request.getSession().setAttribute("cardTypes", cardTypes);

		return "createCard";
	}

}
