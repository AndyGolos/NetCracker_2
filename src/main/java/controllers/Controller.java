package controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import actions.Action;
import actions.ActionFactory;
import resources.ClassParser;

public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static Map<String, Action> classMapping = new HashMap<>();

	// Парсим xml файл в котором будут находится наш урл к странице и наш класс,
	// который будем вызывать рефлексией
	@Override
	public void init(ServletConfig config) throws ServletException {
		classMapping = ClassParser.parseXML(config.getServletContext().getRealPath("/") + "/WEB-INF");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println(classMapping);

		Action action = ActionFactory.getAction(request);
		System.out.println(action);

		if (action != null) {
			String view = action.execute(request, response);
			System.out.println("controller = " + view);
			request.getRequestDispatcher(view).forward(request, response);
		} else {
			request.getRequestDispatcher("errorpage").forward(request, response);
		}

	}
}
