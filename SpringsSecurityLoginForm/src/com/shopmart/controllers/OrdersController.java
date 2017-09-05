package com.shopmart.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shopmart.entity.Orders;
import com.shopmart.service.OrdersService;

@Controller
public class OrdersController {

	@Autowired
	private OrdersService ordersService;
	
	
	@RequestMapping("/getOrdersByCustomerId/{customerId}")
	public List<Orders> getOrdersByCustomerId(@PathVariable int customerId){
		return ordersService.getOrdersByCustomerId(customerId);
	}
	
	@RequestMapping("/getOrdersByStatusId/{statusId}")
	public List<Orders> getOrdersByStatusId(@PathVariable int statusId){
		return ordersService.getOrdersByStatusId(statusId);
	}
	
	@RequestMapping("/getOrdersByInvoiceId/{invoiceId}")
	public List<Orders> getOrdersByInvoiceId(@PathVariable int invoiceId){
		return ordersService.getOrdersByInvoiceId(invoiceId);
	}
	
}

