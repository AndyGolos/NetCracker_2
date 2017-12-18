package actions;

import beans.User;
import services.BillService;
import services.CardService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Random;

public class AddCardWithBillAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		BillService billService = new BillService();
		CardService cardService = new CardService();

		String type = request.getParameter("type");
		int cardTypeId = Integer.parseInt(request.getParameter(type));
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
			request.setAttribute("error", "lowlength");
			valid = false;
		}

		if (!valid) {
			return "createCardWithBill";
		}

		if (password.length() > 20) {
			request.setAttribute("error", "biglength");
			valid = false;
		}

		if (!valid) {
			return "createCardWithBill";
		}

		// Создание счёта и получение созданного id
		int generatedPassword = generatePassword();
		int billId = billService.addBill(generatedPassword);

		User user = (User) request.getSession().getAttribute("user");

		// Создание карточки и получение созданного id
		int cardid = cardService.addCard(user.getId(), billId, cardTypeId, password, Date.valueOf(LocalDate.now()),
				Date.valueOf(LocalDate.now().plusYears(5)));

		request.setAttribute("id", cardid);
		request.setAttribute("billid", billId);
		request.setAttribute("billpassword", generatedPassword);
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
