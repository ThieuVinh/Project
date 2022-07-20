package su22.assignment.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import su22.assignment.beans.LoginModel;
import su22.assignment.entities.Account;
import su22.assignment.repository.AccountDAO;
import su22.assignment.utils.EncryptUtil;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private AccountDAO accDAO;
	
	@Autowired
	private HttpSession session;	
	
	@GetMapping("index")
	public String index(Model model, @ModelAttribute("login") LoginModel login) {
		model.addAttribute("view", "/views/login.jsp");
		return "layout";
	}
	
	@PostMapping("loginHome")
	public String login(Model model,@Validated @ModelAttribute("login") LoginModel login, BindingResult result) {
		
		Account account = this.accDAO.findAccountByUsername(login.getUsername());
		boolean checkPass = EncryptUtil.check(login.getPassword(), account.getPassword());
		
		if (result.hasErrors() == true) {
			session.setAttribute("error", "Đăng nhập thất bại");
			model.addAttribute("view", "/views/login.jsp");
			return "layout";
		} else {
			if (checkPass == true) {
				session.setAttribute("user", account);
				return "redirect:/showProd/index";
			} else {
				session.setAttribute("error", "Đăng nhập thất bại");
				return "redirect:/login/index";
			}
		}
	}
		
	@GetMapping("logout")
	public String logout(Model model) {
		session.removeAttribute("user");
		return "redirect:/login/index";
	}
}
