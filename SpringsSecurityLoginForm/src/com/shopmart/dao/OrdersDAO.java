package com.shopmart.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shopmart.entity.Orders;


@Repository
public class OrdersDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<Orders> getOrdersByCustomerId(int customerId) {
		return this.sessionFactory.getCurrentSession().createQuery
				("FROM ORDERS WHERE CUSTOMER_ID = " + customerId).list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Orders> getOrdersByStatusId(int statusId) {
		return this.sessionFactory.getCurrentSession().createQuery
				("FROM ORDERS WHERE STATUS_ID = " + statusId).list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Orders> getOrdersByInvoiceId(int invoiceId) {
		return this.sessionFactory.getCurrentSession().createQuery
				("FROM ORDERS WHERE INVOICE_ID = " + invoiceId).list();
	}	
}
