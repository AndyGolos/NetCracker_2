package actions;

import javax.servlet.http.HttpServletRequest;

import controllers.Controller;

public class ActionFactory {

	public static Action getAction(HttpServletRequest request) {
		String path = request.getServletPath();
		int slashIndex = path.lastIndexOf('/');
		int period = path.lastIndexOf('.');
		System.out.println(request.getMethod() + "/" + path.substring(slashIndex + 1, period));
		return Controller.classMapping.get(request.getMethod() + "/" + path.substring(slashIndex + 1, period));
	}

}
