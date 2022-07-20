package su22.assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import su22.assignment.entities.Product;
import su22.assignment.repository.ProductDAO;

@Controller
@RequestMapping("/showProd")
public class ShowProductController {

	@Autowired
	private ProductDAO prodDao;
	
	@RequestMapping("index")
	private String index(Model model) {
		
		List<Product> products = prodDao.findAll();
		model.addAttribute("showP",products);
		
		model.addAttribute("view", "/views/showProduct.jsp");
		return "layout";
	}
}
