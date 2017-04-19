package actions;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.CardBill;
import beans.CardType;
import beans.UserRole;
import beans.cardbeans.Card;
import beans.userbeans.User;
import dao.BillDao;
import dao.CardDao;
import dao.CardTypeDao;
import dao.RoleDao;
import dao.UserDao;
import entities.BillEntity;
import entities.CardEntity;
import entities.RoleEntity;
import entities.UserEntity;

public class UserPageAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// Должны приходить со страницы авторизации
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		System.out.println(email);
		System.out.println(password);

		// Инфо юзера
		UserEntity userEntity = new UserEntity();
		User userbean = new User();

		UserDao userDao = new UserDao();

		RoleDao roleDao = new RoleDao();

		User user = (User) request.getSession().getAttribute("user");

		// ----------------------------------------------------------
		if (user != null && email == null && password == null) {
			// Карточки
			CardDao cardDao = new CardDao();
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
			return "userpage";
		}
		// ----------------------------------------------------------

		userEntity.setEmail(email);
		userEntity.setPassword(password);

		userEntity = userDao.find(userEntity);

		List<RoleEntity> roleEntity = roleDao.find(userEntity.getId());

		userbean.setId(userEntity.getId());
		userbean.setName(userEntity.getName());
		userbean.setSurname(userEntity.getSurname());
		userbean.setLastname(userEntity.getLastname());
		userbean.setPassword(userEntity.getPassword());
		userbean.setEmail(userEntity.getEmail());

		UserRole userRole = null;
		List<UserRole> userRoles = new ArrayList<>();

		for (RoleEntity role : roleEntity) {
			userRole = new UserRole();
			userRole.setId(role.getId());
			userRole.setRole(role.getRole());
			userRoles.add(userRole);
		}

		userbean.setRole(userRoles);
		userbean.setRegistration(userEntity.getRegistration());
		userbean.setDateOfBirth(userEntity.getDateOfBirth());

		// Карточки

		CardDao cardDao = new CardDao();
		BillDao billDao = new BillDao();

		CardTypeDao typeDao = new CardTypeDao();

		Card cardbean = null;
		CardBill cardBill = null;

		CardType cardType = null;

		BillEntity billEntity = null;

		List<Card> cardlist = new ArrayList<>();

		List<CardEntity> cardEntities = cardDao.findAllCards(userEntity.getId());

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

		request.getSession().setAttribute("user", userbean);
		request.getSession().setAttribute("cards", cardlist);

		return "userpage";
	}
}
