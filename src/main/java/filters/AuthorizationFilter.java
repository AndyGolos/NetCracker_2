package filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.userbeans.User;

public class AuthorizationFilter implements Filter {

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("AuthorizationFilter");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;

		User user = (User) req.getSession().getAttribute("user");
		String url = req.getRequestURI();

		System.out.println(url);
		RequestDispatcher requestDispatcher;

		// TODO Подредактировать
		if (user != null || url.endsWith("signin") || url.endsWith("registration") || url.endsWith(".js")
				|| url.endsWith(".css") || url.endsWith(".eot") || url.endsWith(".svg") || url.endsWith(".ttf")
				|| url.endsWith(".woff") || url.endsWith(".map") || url.endsWith(".woff2")
				|| url.endsWith("userpage.do") || url.endsWith("registration.do") || url.endsWith("change.do")) {

			chain.doFilter(request, response);

		} else {
			requestDispatcher = req.getRequestDispatcher("signin");
			requestDispatcher.forward(req, resp);
		}

	}

	public void destroy() {
	}

}
