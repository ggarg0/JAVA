package com.shopmart.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shopmart.entity.Invoice;

@Repository
public class InvoiceDAO {
	
	@Autowired
    private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<Invoice> getAllInvoices() {
		return this.sessionFactory.getCurrentSession().createQuery("from Invoice").list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Invoice> getInvoiceById(int invoiceId) {
		return this.sessionFactory.getCurrentSession().createQuery("from INVOICE WHERE INVOICE_ID = "
				+ invoiceId).list();
	}
	
}
