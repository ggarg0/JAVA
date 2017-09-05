package com.shopmart.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shopmart.entity.OrderStatus;


@Repository
public class OrderStatusDAO {

	@Autowired
    private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<OrderStatus> getAllOrderStatus() {
		return this.sessionFactory.getCurrentSession().createQuery("FROM ORDER_STATUS").list();
	}
	
	@SuppressWarnings("unchecked")
	public List<OrderStatus> getOrderStatusById(int statusId) {
		return this.sessionFactory.getCurrentSession().createQuery(" FROM ORDER_STATUS WHERE STATUS_ID = "
				+ statusId).list();
	}
}
