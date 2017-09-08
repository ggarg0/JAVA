package com.shopmart.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shopmart.entity.Customer;
import com.shopmart.service.CustomerService;


@Controller
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}	
	
	
	@RequestMapping("/getAllCustomers")
	public List<Customer> getAllCustomers(){
		return customerService.getAllCustomers();
	}
		
	@RequestMapping("/getCustomerById/{customerId}")
	public List<Customer> getCustomerById(@PathVariable int customerId){
		return customerService.getCustomerById(customerId);
	}
	
	@RequestMapping(value = "/newcustomer", method = RequestMethod.GET)
	public String newCustomer(ModelMap model) {
		model.addAttribute("customer", new Customer());
		return "newcustomer";
	}	

	@RequestMapping(value = "/addcustomer", method = RequestMethod.POST)
	public String addCustomer(
			@ModelAttribute(value = "customer") Customer customer,
			BindingResult result) {
		customerService.addCustomer(customer);
		customerService.addCustomerRole(customer);
		return "redirect:/login";
	}
	
}
