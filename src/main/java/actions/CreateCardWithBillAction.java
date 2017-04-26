package actions;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.CardType;
import entities.CardTypeEntity;
import services.CardTypeService;

public class CreateCardWithBillAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		// Типы карточек (все)
		CardTypeService cardTypeService = new CardTypeService();
		List<CardTypeEntity> cardTypeEntities = cardTypeService.findAllTypes();

		List<CardType> cardTypes = new ArrayList<>();
		CardType cardType = null;

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
