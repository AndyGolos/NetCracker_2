package actions;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.CardBill;
import beans.CardType;
import beans.cardbeans.Card;
import beans.userbeans.User;
import dao.BillDao;
import dao.CardDao;
import dao.CardTypeDao;
import entities.BillEntity;
import entities.CardEntity;

public class DeleteCardAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		int cardId = Integer.parseInt(request.getParameter("cardid"));
		String password = request.getParameter("password");

		CardDao cardDao = new CardDao();
		CardEntity entity = cardDao.find(cardId);

		/*
		 * if (entity == null) { // Добавляем в сессию ошибки return
		 * "deleteCardPage"; }
		 * 
		 * if (!password.equals(entity.getPassword())) { // Добавляем в сессию
		 * ошибки return "deleteCardPage"; }
		 */

		cardDao.delete(cardId);

		// Опять поиск нужных для заполнения userpage карточек
		BillDao billDao = new BillDao();

		CardTypeDao typeDao = new CardTypeDao();

		Card cardbean = null;
		CardBill cardBill = null;

		CardType cardType = null;

		BillEntity billEntity = null;

		List<Card> cardlist = new ArrayList<>();

		User user = (User) request.getSession().getAttribute("user");
		List<CardEntity> cardEntities = cardDao.findAllCards(user.getId());

		for (CardEntity cardEntity : cardEntities) {
			cardbean = new Card();
			cardBill = new CardBill();
			cardType = new CardType();

			cardbean.setId(cardEntity.getId());
			cardbean.setPassword(cardEntity.getPassword());
			cardbean.setTimeOfRegistration(cardEntity.getRegistration());
			cardbean.setValidity(cardEntity.getValidity());
			cardbean.setStatus(cardEntity.getStatus());

			billEntity = billDao.find(cardEntity.getBillId());

			cardBill.setId(billEntity.getId());
			cardBill.setMoney(billEntity.getMoney());
			cardBill.setPassword(billEntity.getPassword());
			cardbean.setBill(cardBill);

			cardType.setType(typeDao.find(cardEntity.getCardType()));
			cardbean.setType(cardType);

			cardlist.add(cardbean);
		}

		request.getSession().setAttribute("cards", cardlist);

		return "userpage";
	}
}
