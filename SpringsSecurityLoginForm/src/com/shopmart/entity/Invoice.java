package com.shopmart.entity;

public class Invoice {

	int invoiceId;
	double totalProductPrice;
	double deliveryCharge;
	double taxes;
	double totalAmount;

	
	public Invoice(int invoiceId, double totalProductPrice, double deliveryCharge, double taxes, double totalAmount) {
		this.invoiceId = invoiceId;
		this.totalProductPrice = totalProductPrice;
		this.deliveryCharge = deliveryCharge;
		this.taxes = taxes;
		this.totalAmount = totalAmount;
	}

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
