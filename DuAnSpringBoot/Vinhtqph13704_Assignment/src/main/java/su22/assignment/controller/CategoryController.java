package su22.assignment.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import su22.assignment.beans.CategoryModel;
import su22.assignment.entities.Category;
import su22.assignment.repository.CategoryDAO;

@Controller
@RequestMapping("/category")
public class CategoryController {
	@Autowired
	private CategoryDAO cateDao;
	
	@Autowired
	private HttpSession session;
	
	@GetMapping("index")
	public String index(Model model,@ModelAttribute("category") CategoryModel cateModel,
			@RequestParam(name = "page", defaultValue = "0") Integer page,
			@RequestParam(name = "size", defaultValue = "5") Integer size,
			@RequestParam(name = "sort", defaultValue = "name") String sorting) {
		
		Pageable pageable = PageRequest.of(page, size, Sort.by(sorting));
		Page<Category> data = this.cateDao.findAll(pageable);
		model.addAttribute("data", data);
		model.addAttribute("sort", sorting);
		
		model.addAttribute("view", "/views/category/createCate.jsp");
		return "layout";
	}
	
	@PostMapping("create")
	public String create(Model model,@Validated @ModelAttribute("category") CategoryModel cateModel, BindingResult result,
			@RequestParam(name = "page", defaultValue = "0") Integer page,
			@RequestParam(name = "size", defaultValue = "5") Integer size) {
		try {
			if (result.hasErrors() == true) {
				session.setAttribute("error", "Thêm mói thất bại");
				
				Pageable pageable = PageRequest.of(page, size);
				Page<Category> data = this.cateDao.findAll(pageable);
				model.addAttribute("data", data);
				
				model.addAttribute("view", "/views/category/createCate.jsp");
				return "layout";
			} else {
				Category category = new Category();
				category.setName(cateModel.getName());
				
				cateDao.save(category);
				session.setAttribute("message", "Thêm mới thành công");
			}
			return "redirect:/category/index";
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("error", "Thêm mới thất bại");
			return "redirect:/category/index";
		}
	}
	
	@GetMapping("edit/{id}")
	public String edit(Model model, @PathVariable("id") Category cate,
			@RequestParam(name = "page", defaultValue = "0") Integer page,
			@RequestParam(name = "size", defaultValue = "5") Integer size) {
		
		Category category = cateDao.findById(cate.getId()).get();
		model.addAttribute("category",category);
		
		Pageable pageable = PageRequest.of(page, size);
		Page<Category> data = this.cateDao.findAll(pageable);
		model.addAttribute("data", data);
		
		model.addAttribute("view", "/views/category/createCate.jsp");
		return "layout";
	}
	
	@PostMapping("update/{id}")
	public String update(Model model ,@PathVariable("id") Integer id, @ModelAttribute("category") CategoryModel cateModel,
			BindingResult result, @RequestParam(name = "page", defaultValue = "0") Integer page,
			@RequestParam(name = "size", defaultValue = "5") Integer size) {
		try {
			if (result.hasErrors() == true) {
				session.setAttribute("error", "Cập nhật thất bại");
				
				Pageable pageable = PageRequest.of(page, size);
				Page<Category> data = this.cateDao.findAll(pageable);
				model.addAttribute("data", data);
				
				model.addAttribute("view", "/views/category/createCate.jsp");
				return "layout";
			} else {
				Category categoryUp = new Category();
				categoryUp.setId(cateModel.getId());
				categoryUp.setName(cateModel.getName());
				
				this.cateDao.save(categoryUp);
				session.setAttribute("message", "Cập nhật thành công");	
				return "redirect:/category/edit/" + id;
			}
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("error", "Cập nhật thất bại");
			return "redirect:/category/edit/" + id;
		}
	}
	
	@GetMapping("delete/{id}") 
	public String delete(@PathVariable("id") Category cate) {
		try {
			cateDao.deleteById(cate.getId());
			session.setAttribute("message", "Xóa thành công");
			return "redirect:/category/index";
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("error", "Xóa thất bại");
			return "redirect:/category/index";
		}
	}
}
