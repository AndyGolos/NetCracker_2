package filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class AuthorizationFilter implements Filter {

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("AuthorizationFilter");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		/*
		 * HttpServletRequest req = (HttpServletRequest) request;
		 * HttpServletResponse resp = (HttpServletResponse) response;
		 * 
		 * User user = (User) req.getSession().getAttribute("user"); String url
		 * = req.getRequestURI();
		 * 
		 * System.out.println(url);
		 * 
		 * // Фильтр не пашет как надо) if (user != null ||
		 * url.endsWith("signin") || url.endsWith("registration") ||
		 * url.endsWith(".js") || url.endsWith(".css")) {
		 * chain.doFilter(request, response); } else { RequestDispatcher
		 * requestDispatcher = req.getRequestDispatcher("signin");
		 * requestDispatcher.forward(req, resp); }
		 */

		/*
		 * HttpServletRequest req = (HttpServletRequest) request;
		 * HttpServletResponse resp = (HttpServletResponse) response;
		 * 
		 * HttpSession session = (HttpSession) req.getSession();
		 * 
		 * String userrole = (String) session.getAttribute("userrole");
		 * 
		 * // User user = (User) session.getAttribute("user");
		 * 
		 * System.out.println(req.getServletPath());
		 * System.out.println(req.getContextPath());
		 * 
		 * if (userrole == null) { RequestDispatcher dispatcher;
		 * session.setAttribute("userrole", "client");
		 * 
		 * if (req.getServletPath().equals("/registration")) { dispatcher =
		 * req.getRequestDispatcher("registration"); dispatcher.forward(req,
		 * resp); return; } else if (req.getServletPath().equals("/signin") ||
		 * req.getServletPath().equals("/index.jsp")) { dispatcher =
		 * ((HttpServletRequest) request).getRequestDispatcher("signin");
		 * dispatcher.forward(req, resp); return; } else { dispatcher =
		 * req.getRequestDispatcher("errorpage"); dispatcher.forward(req, resp);
		 * return; }
		 * 
		 * } else { // pass the request along the filter chain
		 * chain.doFilter(request, response); }
		 */

		chain.doFilter(request, response);
	}

	public void destroy() {
	}

}
