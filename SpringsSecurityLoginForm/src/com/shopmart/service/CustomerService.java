package com.shopmart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopmart.dao.CustomerDAO;
import com.shopmart.entity.Customer;


@Service
public class CustomerService {
	
	@Autowired
	private CustomerDAO customerdao;
	
	public List<Customer> getAllCustomers(){
		return customerdao.getAllCustomers();
	}
	
	public List<Customer> getCustomerById(int customerId){
		return customerdao.getCustomerById(customerId);
	}
}
