package com.shopmart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopmart.dao.OrdersDAO;
import com.shopmart.entity.Orders;

@Service
public class OrdersService {

	@Autowired
	private OrdersDAO ordersdao;
		
	public List<Orders> getOrdersByCustomerId(int customerId){
		return ordersdao.getOrdersByCustomerId(customerId);
	}
	
	public List<Orders> getOrdersByStatusId(int statusId){
		return ordersdao.getOrdersByStatusId(statusId);
	}
	
	public List<Orders> getOrdersByInvoiceId(int invoiceId){
		return ordersdao.getOrdersByInvoiceId(invoiceId);
	}	
}
