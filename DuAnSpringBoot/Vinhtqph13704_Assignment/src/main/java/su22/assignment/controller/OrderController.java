package su22.assignment.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import su22.assignment.beans.OrderDetailModel;
import su22.assignment.beans.OrderModel;
import su22.assignment.entities.Account;
import su22.assignment.entities.Order;
import su22.assignment.entities.OrderDetail;
import su22.assignment.entities.Product;
import su22.assignment.repository.OrderDAO;
import su22.assignment.repository.OrderDetailDAO;

@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderDAO orderDAO;

	@Autowired
	private OrderDetailDAO orderDetailDAO;

	@Autowired
	private HttpSession session;

	@GetMapping("index/{id}")
	public String index(@PathVariable("id") Product prod, Model model, @ModelAttribute("order") OrderModel orderModel) {
		model.addAttribute("product", prod);
		model.addAttribute("view", "/views/order/createOrder.jsp");
		return "layout";
	}

	@PostMapping("create/{id}")
	public String create(@PathVariable("id") Product prod, Model model,
			@Validated @ModelAttribute("order") OrderModel orderModel, BindingResult result) {
		try {
			if (result.hasErrors() == true) {
				model.addAttribute("product", prod);
				model.addAttribute("view", "/views/order/createOrder.jsp");
				return "layout";
			} else {
				// Order
				Account acc = (Account) session.getAttribute("user");
				List<Order> listOder = orderDAO.findAll();
				Order oder = new Order();
				boolean chekOder = true;
				if (chekOder) {
					oder.setUser(acc);
					oder.setCreatedDate(new Date());
					oder.setAddress(orderModel.getAddress());
					orderDAO.save(oder);
				}
				for (int i = 0; i < listOder.size(); i++) {
					if (listOder.get(i).getUser().getId() == acc.getId()) {
						chekOder = false;
						oder = listOder.get(i);
						break;
					}
				}

				// OrderDetail
				List<OrderDetail> listOderDe = orderDetailDAO.findAll();
				OrderDetail oderDe = new OrderDetail();
				boolean checkOderDe = true;
				if (checkOderDe) {
					oderDe.setOrder(oder);
					oderDe.setProduct(prod);
					oderDe.setPrice(prod.getPrice());
					oderDe.setQuatity(orderModel.getQuatity());
					orderDetailDAO.save(oderDe);
				}
				for (int i = 0; i < listOderDe.size(); i++) {
					if (listOderDe.get(i).getProduct().getId() == prod.getId()) {
						if (listOderDe.get(i).getOrder().getAddress().equalsIgnoreCase(orderModel.getAddress())) {
							checkOderDe = false;
							oderDe = listOderDe.get(i);
							oderDe.setQuatity(listOderDe.get(i).getQuatity() + orderModel.getQuatity());
							orderDetailDAO.save(oderDe);
							break;
						}
					}
				}

				session.setAttribute("message", "Thêm thành công");
			}
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("error", "Thêm thất bại");
		}

		return "redirect:/order/orderdetail";
	}

	@GetMapping("orderdetail")
	public String orderDetail(Model model ,@ModelAttribute("order") OrderDetailModel oderDeModel) {
		Account acc = (Account) session.getAttribute("user");
		List<OrderDetail> listOderDe = orderDetailDAO.findById(acc.getId());
		float tongTien = 0;
		for (OrderDetail od : listOderDe) {
			tongTien += (od.getPrice() * od.getQuatity());
		}
		
		model.addAttribute("listOderDe",listOderDe);
		model.addAttribute("tongTien", tongTien);
		
		model.addAttribute("view","/views/orderdetail/createOrderDetail.jsp");
		return "layout";
	}
	
	@SuppressWarnings("deprecation")
	@PostMapping("update/{id}")
	public String update(Model model, @PathVariable("id") Integer id, @Validated @ModelAttribute("order") OrderDetailModel oderDeModel, BindingResult result) {
		try {
			if (result.hasErrors() == true) {
				Account acc = (Account) session.getAttribute("user");
				List<OrderDetail> listOderDe = orderDetailDAO.findById(acc.getId());
				model.addAttribute("listOderDe",listOderDe);
				model.addAttribute("view","/views/orderdetail/createOrderDetail.jsp");
				return "layout";
			} else {
				OrderDetail oderDe = orderDetailDAO.getById(id);
				oderDe.setQuatity(oderDeModel.getQuatity());
				orderDetailDAO.save(oderDe);
				
				session.setAttribute("message", "Cập nhật thành công");
			}
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("error", "Cập nhật thất bại");
		}
		return "redirect:/order/orderdetail";
	}
	
	@GetMapping("delete/{id}")
	public String delete(@PathVariable("id") OrderDetail oderDe) {
		try {
			orderDetailDAO.delete(oderDe);
			session.setAttribute("message", "Xóa đơn hàng thành công!");
		} catch (Exception e) {
			session.setAttribute("error", "Xóa đơn hàng thất bại!");
			e.printStackTrace();
		}
		return "redirect:/order/orderdetail";
	}
}
