package su22.assignment.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

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

import su22.assignment.beans.AccountModel;
import su22.assignment.entities.Account;
import su22.assignment.repository.AccountDAO;
import su22.assignment.utils.EncryptUtil;

@Controller
@RequestMapping("/account")
public class AccountController {
	@Autowired
	private AccountDAO accDao;

	@Autowired
	private HttpSession session;

	@Autowired
	private ServletContext servletContext;

	@GetMapping("index")								
	public String index(Model model, @ModelAttribute("account") Account acc,
			@RequestParam(name = "page", defaultValue = "0") Integer page,
			@RequestParam(name = "size", defaultValue = "5") Integer size,
			@RequestParam(name = "sort", defaultValue = "username") String sorting) {
//		List<Account> listAcc = accDao.findAll();
//		model.addAttribute("listAcc", listAcc);

		Pageable pageable = PageRequest.of(page, size, Sort.by(sorting));
		Page<Account> data = this.accDao.findAll(pageable);
		model.addAttribute("data", data);
		model.addAttribute("sort", sorting);

		model.addAttribute("view", "/views/account/createAcc.jsp");
		return "layout";
	}

	@PostMapping("create")
	public String create(Model model, @Validated @ModelAttribute("account") AccountModel accModel, BindingResult result,
			@RequestParam(name = "page", defaultValue = "0") Integer page,
			@RequestParam(name = "size", defaultValue = "5") Integer size) {
		try {
			if (result.hasErrors() == true) {
				session.setAttribute("error", "Thêm mói thất bại");
				
				Pageable pageable = PageRequest.of(page, size);
				Page<Account> data = this.accDao.findAll(pageable);
				model.addAttribute("data", data);

				model.addAttribute("view", "/views/account/createAcc.jsp");
				return "layout";
			} else {
				Account account = new Account();
				account.setUsername(accModel.getUsername());
				String maHoaPass = EncryptUtil.entypt(accModel.getPassword());
				account.setPassword(maHoaPass);
				account.setFullname(accModel.getFullname());
				account.setEmail(accModel.getEmail());
				account.setAdmin(accModel.getAdmin());
				account.setActivated(accModel.getActivated());
				
				if (!accModel.getPhotoName().isEmpty()) {
					String upload = servletContext.getRealPath("images");
					File file = new File(upload);
					if (!file.exists()) {
						file.mkdirs();
					}
					try {
						String fileName = accModel.getPhotoName().getOriginalFilename();
						File file2 = new File(file.getAbsoluteFile() + File.separator + fileName);
						BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file2));
						bos.write(accModel.getPhotoName().getBytes());
						bos.close();
						account.setPhoto(fileName);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}

				accDao.save(account);
				session.setAttribute("message", "Thêm mói thành công");
			}
			return "redirect:/account/index";
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("error", "Thêm mói thất bại");
			return "redirect:/account/index";
		}
	}

	@GetMapping("edit/{id}")
	public String edit(Model model, @PathVariable("id") Account acc,
			@RequestParam(name = "page", defaultValue = "0") Integer page,
			@RequestParam(name = "size", defaultValue = "5") Integer size) {
		Account account = accDao.findById(acc.getId()).get();
		model.addAttribute("account", account);

//		List<Account> listAcc = accDao.findAll();
//		model.addAttribute("listAcc", listAcc);

		Pageable pageable = PageRequest.of(page, size);
		Page<Account> data = this.accDao.findAll(pageable);
		model.addAttribute("data", data);

		model.addAttribute("view", "/views/account/createAcc.jsp");
		return "layout";
	}

	@PostMapping("update/{id}")
	public String update(@PathVariable("id") Integer id, @Validated @ModelAttribute("account") AccountModel accModel,BindingResult result,Model model,
			@RequestParam(name = "page", defaultValue = "0") Integer page,
			@RequestParam(name = "size", defaultValue = "5") Integer size) {
		try {
			if (result.hasErrors() == true) {
				session.setAttribute("error", "Cập nhật thất bại");
			
				Pageable pageable = PageRequest.of(page, size);
				Page<Account> data = this.accDao.findAll(pageable);
				model.addAttribute("data", data);

				model.addAttribute("view", "/views/account/createAcc.jsp");
				return "layout";
			} else {
				Account accountUp = new Account();
				accountUp.setId(accModel.getId());
				accountUp.setUsername(accModel.getUsername());
				String maHoaPass = EncryptUtil.entypt(accModel.getPassword());
				accountUp.setPassword(maHoaPass);
				accountUp.setFullname(accModel.getFullname());
				accountUp.setEmail(accModel.getEmail());
				accountUp.setAdmin(accModel.getAdmin());
				accountUp.setActivated(accModel.getActivated());
				if (!accModel.getPhotoName().isEmpty()) {
					String upload = servletContext.getRealPath("images");
					File file = new File(upload);
					if (!file.exists()) {
						file.mkdirs();
					}
					try {
						String fileName = accModel.getPhotoName().getOriginalFilename();
						File file2 = new File(file.getAbsoluteFile() + File.separator + fileName);
						BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file2));
						bos.write(accModel.getPhotoName().getBytes());
						bos.close();
						accountUp.setPhoto(fileName);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				this.accDao.save(accountUp);
				session.setAttribute("message", "Cập nhật thành công");
				return "redirect:/account/edit/" + id;
			}
		} catch (Exception e) {
			session.setAttribute("error", "Cập nhật thất bại");
			e.printStackTrace();
			return "redirect:/account/edit/" + id;
		}

	}

	@GetMapping("delete/{id}")
	public String delete(@PathVariable("id") Account acc) {
		try {
			accDao.deleteById(acc.getId());
			session.setAttribute("message", "Xóa thành công");
			return "redirect:/account/index";
		} catch (Exception e) {
			session.setAttribute("error", "Xóa thất bại");
			e.printStackTrace();
			return "redirect:/account/index";
		}
	}
}
