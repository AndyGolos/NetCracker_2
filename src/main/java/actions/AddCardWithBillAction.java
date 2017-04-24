package actions;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.CardType;
import beans.userbeans.User;
import dao.CardDao;
import services.BillService;

public class AddCardWithBillAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		BillService billService = new BillService();

		String type = request.getParameter("type");
		String password = request.getParameter("password");

		// Валидация--------------------------
		boolean valid = true;
		if (password.trim().isEmpty()) {
			request.setAttribute("error", "isempty");
			valid = false;
		}

		if (!valid) {
			return "createCardWithBill";
		}

		if (password.length() < 4) {
			request.setAttribute("error", "length");
			valid = false;
		}

		if (!valid) {
			return "createCardWithBill";
		}
		// Валидация-----------------------
		int billId = billService.addBill(password);

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

		CardDao cardDao = new CardDao();
		int cardid = cardDao.add(user.getId(), billId, typeId, password, Date.valueOf(LocalDate.now()),
				Date.valueOf(LocalDate.now().plusYears(5)));

		request.setAttribute("id", cardid);
		request.setAttribute("billid", billId);
		request.setAttribute("billpassword", generatePassword());
		request.setAttribute("type", type);
		request.setAttribute("cardpassword", password);

		return "infopage";
	}

	private int generatePassword() {
		Random random = new Random();
		int password = (int) (random.nextDouble() * 10000);
		if (password < 1000) {
			return generatePassword();
		}
		return password;
	}

}
