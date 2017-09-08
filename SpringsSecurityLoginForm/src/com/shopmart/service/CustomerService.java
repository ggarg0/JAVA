package com.shopmart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shopmart.dao.CustomerDAO;
import com.shopmart.entity.Customer;
import com.shopmart.entity.CustomerRole;


@Service
public class CustomerService {
	
	@Autowired
	private CustomerDAO customerdao;
	
	@Autowired
	CustomerRole customerrole;
	
	public List<Customer> getAllCustomers(){
		return customerdao.getAllCustomers();
	}
	
	public List<Customer> getCustomerById(int customerId){
		return customerdao.getCustomerById(customerId);
	}
	

	@Transactional
	public void addCustomer(Customer customer) {
		customerdao.addCustomer(customer);
	}
	
	@Transactional
	public void addCustomerRole(Customer customer) {
		customerrole.setCustomerId(customer.getCustomerId());
		customerrole.setUsername(customer.getFirstName());
		customerrole.setPassword("pass");
		customerrole.setRole("user");
		customerrole.setEnabled(1);		
		customerdao.addCustomerRole(customerrole);
	}
	
}
