package com.shopmart.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "INVOICE")
@Table(name = "INVOICE")
public class Invoice {

	@Id
	@Column(name = "INVOICE_ID")
	int invoiceId;

	@Column(name = "TOTAL_PRODUCT_PRICE")
	double totalProductPrice;
	
	@Column(name = "DELIVERY_CHARGE")
	double deliveryCharge;
	
	@Column(name = "TAXES")
	double taxes;
	
	@Column(name = "TOTAL_AMOUNT")
	double totalAmount;


	public int getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}

	public double getTotalProductPrice() {
		return totalProductPrice;
	}

	public void setTotalProductPrice(double totalProductPrice) {
		this.totalProductPrice = totalProductPrice;
	}

	public double getDeliveryCharge() {
		return deliveryCharge;
	}

	public void setDeliveryCharge(double deliveryCharge) {
		this.deliveryCharge = deliveryCharge;
	}

	public double getTaxes() {
		return taxes;
	}

	public void setTaxes(double taxes) {
		this.taxes = taxes;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
}
