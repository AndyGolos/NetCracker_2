package actions;

import beans.User;
import entities.BillEntity;
import services.BillService;
import services.CardService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.time.LocalDate;

public class AddCardAction implements Action {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        CardService cardService = new CardService();

        int billId = Integer.parseInt(request.getParameter("billid"));
        String stringBillPassword = request.getParameter("billpassword");

        String type = request.getParameter("type");
        int cardTypeId = Integer.parseInt(request.getParameter(type));
        String password = request.getParameter("password");

        // TODO Работает Валидация
        BillService billService = new BillService();
        BillEntity billEntity = billService.find(billId);
        boolean valid = true;
        int billPassword = 0;

        try {
            billPassword = Integer.parseInt(stringBillPassword);
        } catch (NumberFormatException e) {
            request.setAttribute("error", "billpasswordformat");
            valid = false;
        }

        if (!valid) {
            return "createCard";
        }

        if (Integer.valueOf(billEntity.getPassword()) != billPassword) {
            request.setAttribute("error", "billpassword");
            valid = false;
        }

        if (!valid) {
            return "createCard";
        }

        if (password.length() < 4) {
            request.setAttribute("error", "passwordlength");
            valid = false;
        }

        if (!valid) {
            return "createCard";
        }

        if (password.length() > 20) {
            request.setAttribute("error", "biglength");
            valid = false;
        }

        if (!valid) {
            return "createCard";
        }

        if (password.trim().isEmpty()) {
            request.setAttribute("error", "passwordblank");
            valid = false;
        }

        if (!valid) {
            return "createCard";
        }

        User user = (User) request.getSession().getAttribute("user");
        int cardid = cardService.addCard(user.getId(), billId, cardTypeId, password, Date.valueOf(LocalDate.now()),
                Date.valueOf(LocalDate.now().plusYears(5)));

        request.setAttribute("id", cardid);
        request.setAttribute("type", type);
        request.setAttribute("cardpassword", password);
        return "infopage";
    }

}
