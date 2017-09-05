package com.shopmart.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.shopmart.entity.Customer;

@Repository
public class CustomerDAO {

	@Autowired
    private SessionFactory sessionFactory;

	public List<Customer> getAllCustomers() {
		return this.sessionFactory.getCurrentSession().createQuery("from Customer").list();
	}
	
	public List<Customer> getCustomerById(int customerId) {
		return this.sessionFactory.getCurrentSession().createQuery("from Customer WHERE CUSTOMER_ID = "
				+ customerId).list();
	}

}
