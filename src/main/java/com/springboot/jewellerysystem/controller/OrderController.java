package com.springboot.jewellerysystem.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springboot.jewellerysystem.entity.Order;
import com.springboot.jewellerysystem.entity.User;
import com.springboot.jewellerysystem.service.OrderService;
import com.springboot.jewellerysystem.service.UserService;

@Controller
@RequestMapping(value = "order")
public class OrderController {
	private OrderService orderService;
	private UserService userService;

	public OrderController(OrderService orderService, UserService userService) {
		this.orderService = orderService;
		this.userService = userService;
	}

	@GetMapping(value = "/index")
	public String orders(Model model, @RequestParam(name = "keyword", defaultValue = "") String keyword) {
		List<Order> orders = orderService.getAllOrder();
		model.addAttribute("listOrders", orders);
		model.addAttribute("keyword", keyword);
		return "admin/list/orders_list";
	}

	@GetMapping(value = "/create")
	public String formOrders(Model model) {
		model.addAttribute("order", new Order());
		List<User> users = userService.getAllUser();
		model.addAttribute("listUsers", users);

		return "admin/entry/order_entry";
	}

	@GetMapping(value = "/delete/{id}")
	public String deleteOrder(@PathVariable(value = "id") Integer id, String keyword) {
		orderService.removeOrder(id);
		return "redirect:/order/index?keyword=" + keyword;
	}

	@GetMapping(value = "/update/{id}")
	public String updateOrder(@PathVariable(value = "id") Integer id, Model model) {
		Order order = orderService.loadOrderById(id);
		model.addAttribute("order", order);
		List<User> users = userService.getAllUser();
		model.addAttribute("listUsers", users);

		return "admin/edit/order_edit";
	}

	@PostMapping(value = "/save")
	public String save(Order order) {
		orderService.createOrUpdateOrder(order);
		return "redirect:/order/index";
	}

}
