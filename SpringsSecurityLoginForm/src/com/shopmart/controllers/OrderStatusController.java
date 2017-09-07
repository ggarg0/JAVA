package com.shopmart.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shopmart.entity.OrderStatus;
import com.shopmart.service.OrderStatusService;


@Controller
public class OrderStatusController {

	@Autowired
	private OrderStatusService orderStatusService;

	@RequestMapping("/getAllOrderStatus")
	public List<OrderStatus> getAllOrderStatus() {
		return orderStatusService.getAllOrderStatus();
	}

	@RequestMapping("/getOrderStatusById/{statusId}")
	public List<OrderStatus> getOrderStatusById(@PathVariable int statusId) {
		return orderStatusService.getOrderStatusById(statusId);
	}
}
