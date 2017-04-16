package actions;

import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.UserEntity;
import services.UserService;

public class RegisterAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		if (request.getMethod().equals("GET")) {
			return "registration";
		}

		UserService service = new UserService();
		String surname = request.getParameter("surname");
		String name = request.getParameter("name");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String dateOfBirth = request.getParameter("dateOfBirth");
		String password = request.getParameter("password");
		// String repeatpassword = request.getParameter("repeatpassword");
		// TODO Какая-то серверная валидация
		UserEntity user = new UserEntity();
		user.setSurname(surname);
		user.setName(name);
		user.setLastname(lastname);
		user.setEmail(email);
		user.setDateOfBirth(LocalDate.parse(dateOfBirth));
		user.setPassword(password);

		if (service.addUser(user)) {
			request.getSession().setAttribute("user", user);
		}

		return "userpage";
	}
}
