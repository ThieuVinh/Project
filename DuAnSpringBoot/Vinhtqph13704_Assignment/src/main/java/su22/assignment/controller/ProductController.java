package su22.assignment.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
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

import su22.assignment.beans.ProductModel;
import su22.assignment.entities.Category;
import su22.assignment.entities.Product;
import su22.assignment.repository.CategoryDAO;
import su22.assignment.repository.ProductDAO;

@Controller
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductDAO prodDAO;

	@Autowired
	private CategoryDAO cateDAO;

	@Autowired
	private HttpSession session;

	@Autowired
	private ServletContext servletContext;

	@GetMapping("index")
	public String index(Model model, @ModelAttribute("product") ProductModel prodModel,
			@RequestParam(name = "page", defaultValue = "0") Integer page,
			@RequestParam(name = "size", defaultValue = "5") Integer size,
			@RequestParam(name = "sort", defaultValue = "name") String sorting) {
		
		Pageable pageable = PageRequest.of(page, size, Sort.by(sorting));
		Page<Product> data = this.prodDAO.findAll(pageable);
		model.addAttribute("data", data);
		model.addAttribute("sort", sorting);

		model.addAttribute("view", "/views/product/createProd.jsp");
		return "layout";
	}
	
	@ModelAttribute("listCate")
	public Map<Integer, String> getCategory() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		List<Category> list = this.cateDAO.findAll();
		for (Category cate : list) {
			map.put(cate.getId(), cate.getName());
		}
		return map;
	}
	
	@ModelAttribute("status")
	public Map<Integer, String> getStatus() {
		Map<Integer, String> map = new HashMap<>();
		map.put(0, "Còn hàng");
		map.put(1, "Hết hàng");
		return map;
	}

	@SuppressWarnings("deprecation")
	@PostMapping("create")
	public String create(Model model,@Validated @ModelAttribute("product") ProductModel prodModel,
			BindingResult result, @RequestParam(name = "page", defaultValue = "0") Integer page,
			@RequestParam(name = "size", defaultValue = "5") Integer size) {
		try {
			if (result.hasErrors() == true) {
				session.setAttribute("error", "Thêm mới thất bại");

				Pageable pageable = PageRequest.of(page, size);
				Page<Product> data = this.prodDAO.findAll(pageable);
				model.addAttribute("data", data);

				model.addAttribute("view", "/views/product/createProd.jsp");
				return "layout";
			} else {
				Product product = new Product();
				product.setName(prodModel.getName());
				product.setPrice(prodModel.getPrice());
				product.setCreatedDate(new Date());
				product.setAvailable(prodModel.getAvailable());

				Category cate = cateDAO.getById(prodModel.getCategoryId());
				product.setCategory(cate);
				if (!prodModel.getImageName().isEmpty()) {
					String upload = servletContext.getRealPath("imageProduct");
					File file = new File(upload);
					if (!file.exists()) {
						file.mkdirs();
					}
					try {
						String fileName = prodModel.getImageName().getOriginalFilename();
						File file2 = new File(file.getAbsoluteFile() + File.separator + fileName);
						BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file2));
						bos.write(prodModel.getImageName().getBytes());
						bos.close();
						product.setImage(fileName);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				prodDAO.save(product);
				session.setAttribute("message", "Thêm mới thành công");
			}
			return "redirect:/product/index";
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("error", "Thêm mới thất bại");
			return "redirect:/product/index";
		}
	}

	@GetMapping("edit/{id}")
	public String edit(Model model, @PathVariable("id") Product prod,
			@RequestParam(name = "page", defaultValue = "0") Integer page,
			@RequestParam(name = "size", defaultValue = "5") Integer size) {
		
		ProductModel productModel = new ProductModel();
		productModel.setName(prod.getName());
		productModel.setPrice(prod.getPrice());
		productModel.setCategoryId(prod.getCategory().getId());
		productModel.setAvailable(prod.getAvailable());
		model.addAttribute("product", productModel);
		
		Pageable pageable = PageRequest.of(page, size);
		Page<Product> data = this.prodDAO.findAll(pageable);
		model.addAttribute("data", data);

		model.addAttribute("view", "/views/product/createProd.jsp");
		return "layout";
	}

	@SuppressWarnings("deprecation")
	@PostMapping("update/{id}")
	public String update(@PathVariable("id") Integer id, @Validated @ModelAttribute("product") ProductModel prodModel, BindingResult result,
			Model model, @RequestParam(name = "page", defaultValue = "0") Integer page,
			@RequestParam(name = "size", defaultValue = "5") Integer size) {

		try {
			if (result.hasErrors() == true) {
				session.setAttribute("error", "Cập nhật thất bại");

				Pageable pageable = PageRequest.of(page, size);
				Page<Product> data = this.prodDAO.findAll(pageable);
				model.addAttribute("data", data);

				model.addAttribute("view", "/views/product/createProd.jsp");
				return "layout";
			} else {
				Product product = new Product();
				product.setId(prodModel.getId());
				product.setName(prodModel.getName());
				product.setPrice(prodModel.getPrice());
				product.setCreatedDate(new Date());
				product.setAvailable(prodModel.getAvailable());

				Category cate = cateDAO.getById(prodModel.getCategoryId());
				product.setCategory(cate);
				if (!prodModel.getImageName().isEmpty()) {
					String upload = servletContext.getRealPath("imageProduct");
					File file = new File(upload);
					if (!file.exists()) {
						file.mkdirs();
					}
					try {
						String fileName = prodModel.getImageName().getOriginalFilename();
						File file2 = new File(file.getAbsoluteFile() + File.separator + fileName);
						BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file2));
						bos.write(prodModel.getImageName().getBytes());
						bos.close();
						product.setImage(fileName);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				this.prodDAO.save(product);
				session.setAttribute("message", "Cập nhật thành công");
			}
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("error", "Cập nhật thất bại");
		}
		return "redirect:/product/index";
	}
	
	@GetMapping("delete/{id}")
	public String delete(@PathVariable("id") Product prod) {
		try {
			prodDAO.deleteById(prod.getId());
			session.setAttribute("message", "Xóa thành công");
			return "redirect:/product/index";
		} catch (Exception e) {
			session.setAttribute("error", "Xóa thất bại");
			e.printStackTrace();
			return "redirect:/product/index";
		}
	}
}
