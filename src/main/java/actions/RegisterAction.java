package actions;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.cardbeans.Card;
import beans.userbeans.User;
import entities.UserEntity;
import services.CardService;
import services.UserService;

public class RegisterAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		UserService userService = new UserService();
		CardService cardService = new CardService();

		String surname = request.getParameter("surname");
		String name = request.getParameter("name");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String dateOfBirth = request.getParameter("dateOfBirth");
		String password = request.getParameter("password");
		// String repeatpassword = request.getParameter("repeatpassword");

		// Валидация---------------------------------------------------
		UserEntity user = new UserEntity();
		user.setSurname(surname);
		user.setName(name);
		user.setLastname(lastname);
		user.setEmail(email);
		user.setDateOfBirth(LocalDate.parse(dateOfBirth));
		user.setPassword(password);

		UserEntity currentUser = userService.checkUser(user);

		if (currentUser != null) {
			request.setAttribute("currentuser", "error");
			return "registration";
		}
		// ------------------------------------------------------------

		// Добавить юзера
		userService.addUser(user);

		// Инфо юзера
		UserEntity userEntity = new UserEntity();
		User userbean = null;
		userEntity.setEmail(email);
		userEntity.setPassword(password);
		userbean = userService.findUserInfo(userEntity);

		// Карточки юзера
		List<Card> cardlist = cardService.findAllUsersCards(userbean);

		request.getSession().setAttribute("user", userbean);
		request.getSession().setAttribute("cards", cardlist);

		return "userpage";
	}
}
