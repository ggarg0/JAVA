package com.shopmart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopmart.dao.InvoiceDAO;
import com.shopmart.entity.Invoice;

@Service
public class InvoiceService {

	@Autowired
	private InvoiceDAO invoicedao;
	
	public List<Invoice> getInvoiceById(int invoiceId){
		return invoicedao.getInvoiceById(invoiceId);
	}
	
	
	public List<Invoice> getAllInvoices(){
		return invoicedao.getAllInvoices();
	}	
}
