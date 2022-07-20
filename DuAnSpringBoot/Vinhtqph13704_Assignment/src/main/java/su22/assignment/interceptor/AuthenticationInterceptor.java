package su22.assignment.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import su22.assignment.entities.Account;

@Component
public class AuthenticationInterceptor implements HandlerInterceptor{
	
	@Autowired
	private HttpSession session;
	
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) throws Exception {
		Account acc = (Account) session.getAttribute("user");
		
		if (acc == null) {
			res.sendRedirect("/Vinhtqph13704_Assignment/login/index");
		} else if (acc.getAdmin() == 0) {
			res.sendRedirect("/Vinhtqph13704_Assignment/showProd/index");
		}
		
		return true;
	}
}
