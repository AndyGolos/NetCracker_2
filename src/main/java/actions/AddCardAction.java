package actions;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.CardType;
import beans.userbeans.User;
import services.CardService;

public class AddCardAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		CardService cardService = new CardService();

		int billId = Integer.parseInt(request.getParameter("billid"));
		String stringBillPassword = request.getParameter("billpassword");
		String type = request.getParameter("type");
		String password = request.getParameter("password");

		// TODO Валидация
		/*
		 * BillDao billDao = new BillDao(); BillEntity billEntity =
		 * billDao.find(billId); boolean valid = true; int billPassword = 0;
		 * 
		 * try { billPassword = Integer.parseInt(stringBillPassword); } catch
		 * (NumberFormatException e) { request.setAttribute("error",
		 * "billpasswordformat"); valid = false; }
		 * 
		 * if (!valid) { return "createCard"; }
		 * 
		 * if (Integer.valueOf(billEntity.getPassword()) != billPassword) {
		 * request.setAttribute("error", "billpassword"); valid = false; }
		 * 
		 * if (!valid) { return "createCard"; }
		 * 
		 * if (password.length() < 4) { request.setAttribute("error",
		 * "passwordlength"); valid = false; }
		 * 
		 * if (!valid) { return "createCard"; }
		 * 
		 * if (password.trim().isEmpty()) { request.setAttribute("error",
		 * "passwordblank"); valid = false; }
		 * 
		 * if (!valid) { return "createCard"; }
		 */
		// ----------------------------------------------------------

		// TODO Повторяющийся код
		@SuppressWarnings("unchecked")
		List<CardType> cardTypes = (List<CardType>) request.getSession().getAttribute("cardTypes");
		User user = (User) request.getSession().getAttribute("user");

		int typeId = 0;
		for (CardType cardType : cardTypes) {
			if (cardType.getType().equals(type)) {
				typeId = cardType.getId();
				break;
			}
		}

		int cardid = cardService.addCard(user.getId(), billId, typeId, password, Date.valueOf(LocalDate.now()),
				Date.valueOf(LocalDate.now().plusYears(5)));

		request.setAttribute("id", cardid);
		request.setAttribute("type", type);
		request.setAttribute("cardpassword", password);
		return "infopage";
	}

}
