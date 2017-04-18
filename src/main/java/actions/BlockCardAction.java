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

public class BlockCardAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		int cardid = Integer.parseInt(request.getParameter("block"));
		User user = (User) request.getSession().getAttribute("user");

		System.out.println(cardid);

		CardDao cardDao = new CardDao();
		cardDao.blockCard(cardid);

		BillDao billDao = new BillDao();
		CardTypeDao typeDao = new CardTypeDao();

		Card cardbean = null;
		CardBill cardBill = null;
		CardType cardType = null;

		BillEntity billEntity = null;

		List<Card> cardlist = new ArrayList<>();

		List<CardEntity> cardEntities = cardDao.findAllCards(user.getId());

		for (CardEntity cardEntity : cardEntities) {
			cardbean = new Card();
			cardBill = new CardBill();
			cardType = new CardType();

			cardbean.setId(cardEntity.getId());
			System.out.println("cardid = " + cardEntity.getId());
			cardbean.setPassword(cardEntity.getPassword());
			cardbean.setTimeOfRegistration(cardEntity.getRegistration());
			cardbean.setValidity(cardEntity.getValidity());
			cardbean.setStatus(cardEntity.getStatus());
			System.out.println("статус бина = " + cardbean.getStatus());

			billEntity = billDao.find(cardEntity.getBillId());

			cardBill.setId(billEntity.getId());
			cardBill.setMoney(billEntity.getMoney());
			cardBill.setPassword(billEntity.getPassword());

			cardbean.setBill(cardBill);

			cardType.setType(typeDao.find(cardEntity.getCardType()));
			cardbean.setType(cardType);

			// cardbean.setUser(user);

			cardlist.add(cardbean);
		}

		if (request.getSession().getAttribute("user") != null) {
			request.getSession().setAttribute("cards", null);
		}

		request.getSession().setAttribute("cards", cardlist);

		return "userpage";
	}

}
