package com.shopmart.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shopmart.entity.Invoice;
import com.shopmart.service.InvoiceService;


@Controller
public class InvoiceController {
	
	@Autowired
	private InvoiceService invoiceService;
	
	
	@RequestMapping("/getInvoiceById/{invoiceId}")
	public List<Invoice> getInvoiceById(@PathVariable int invoiceId){
		return invoiceService.getInvoiceById(invoiceId);
	}
	
	@RequestMapping("/getAllInvoices")
	public List<Invoice> getAllInvoices(){
		return invoiceService.getAllInvoices();
	}
}
