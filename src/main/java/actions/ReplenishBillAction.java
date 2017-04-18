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

public class ReplenishBillAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		int billId = Integer.parseInt(request.getParameter("billid"));
		int summ = Integer.parseInt(request.getParameter("summ"));

		BillDao billDao = new BillDao();
		BillEntity billEntity = billDao.find(billId);
		billDao.setMoney(billEntity, summ);

		// ---------------------------------------------
		CardDao cardDao = new CardDao();
		billDao = new BillDao();

		CardTypeDao typeDao = new CardTypeDao();

		Card cardbean = null;
		CardBill cardBill = null;

		CardType cardType = null;

		billEntity = null;

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
		// -----------------------------------------------------

		return "userpage";
	}

}
