package actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.cardbeans.Card;
import beans.userbeans.User;
import entities.UserEntity;
import services.CardService;
import services.UserService;

public class UserPageAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		List<Card> cardlist = null;
		CardService cardService = new CardService();
		UserService userService = new UserService();
		User userbean = null;

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		System.out.println(email);
		System.out.println(password);

		UserEntity userEntity = null;
		userEntity = new UserEntity();
		userEntity.setEmail(email);
		userEntity.setPassword(password);

		User user = (User) request.getSession().getAttribute("user");
		// ----------------------------------------------------------
		if (user != null && email == null && password == null) {
			cardlist = cardService.findAllUsersCards(user);
			request.getSession().setAttribute("cards", cardlist);
			return "userpage";
		}
		// ----------------------------------------------------------

		// Валидация--------------------------------------------------
		UserEntity currentUser = userService.checkUser(userEntity);
		if (currentUser == null) {
			request.setAttribute("useremail", "error");
			request.setAttribute("userpassword", "error");
			System.out.println("Im here");
			return "signin";
		}
		// ----------------------------------------------------------

		// Инфо юзера
		userEntity = new UserEntity();
		userEntity.setEmail(email);
		userEntity.setPassword(password);
		userbean = userService.findUserInfo(userEntity);

		// Карточки
		cardlist = cardService.findAllUsersCards(userbean);

		request.getSession().setAttribute("user", userbean);
		request.getSession().setAttribute("cards", cardlist);

		return "userpage";
	}
}
