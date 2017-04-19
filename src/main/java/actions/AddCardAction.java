package actions;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.CardType;
import beans.userbeans.User;
import dao.CardDao;

public class AddCardAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		int billId = Integer.parseInt(request.getParameter("billid"));
		int billPassword = Integer.parseInt(request.getParameter("billpassword"));
		String type = request.getParameter("type");
		String password = request.getParameter("password");

		// TODO Валидация

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

		CardDao cardDao = new CardDao();
		int cardid = cardDao.add(user.getId(), billId, typeId, password, Date.valueOf(LocalDate.now()),
				Date.valueOf(LocalDate.now().plusYears(5)));

		request.setAttribute("id", cardid);
		request.setAttribute("type", type);
		request.setAttribute("cardpassword", password);

		return "infopage";
	}

}
