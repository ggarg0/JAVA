package com.shopmart.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shopmart.entity.Customer;
import com.shopmart.service.CustomerService;


@Controller
public class CutomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/getAllCustomers")
	public List<Customer> getAllCustomers(){
		return customerService.getAllCustomers();
	}
		
	@RequestMapping("/getCustomerById/{customerId}")
	public List<Customer> getCustomerById(@PathVariable int customerId){
		return customerService.getCustomerById(customerId);
	}
	
}
