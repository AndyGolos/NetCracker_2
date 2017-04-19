package actions;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.CardType;
import beans.userbeans.User;
import dao.BillDao;
import dao.CardDao;

public class AddCardWithBillAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String type = request.getParameter("type");
		String password = request.getParameter("password");

		// TODO Валидация

		BillDao billDao = new BillDao();
		int billId = billDao.add(password);

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

		// TODO Придумать генерацию пароля для счтёа

		request.setAttribute("id", cardid);
		request.setAttribute("billid", billId);
		request.setAttribute("billpassword", new Integer(1111));
		request.setAttribute("type", type);
		request.setAttribute("cardpassword", password);

		return "infopage";
	}

}
