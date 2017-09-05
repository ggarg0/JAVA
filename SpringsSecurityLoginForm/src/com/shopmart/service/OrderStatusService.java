package com.shopmart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopmart.dao.OrderStatusDAO;
import com.shopmart.entity.OrderStatus;


@Service
public class OrderStatusService {
	@Autowired
	private OrderStatusDAO orderStatusdao;
	
	public List<OrderStatus> getOrderStatusById(int statusId){
		return orderStatusdao.getOrderStatusById(statusId);
	}
	
	
	public List<OrderStatus> getAllOrderStatus(){
		return orderStatusdao.getAllOrderStatus();
	}	
}
