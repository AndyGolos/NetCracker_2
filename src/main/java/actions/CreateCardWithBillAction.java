package actions;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.CardType;
import dao.CardTypeDao;
import entities.CardTypeEntity;

public class CreateCardWithBillAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

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

		return "createCardWithBill";
	}

}
