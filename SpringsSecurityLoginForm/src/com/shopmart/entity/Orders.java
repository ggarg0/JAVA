package com.shopmart.entity;

import java.util.Date;

public class Orders {

	int orderId;
	int customerId;
	Date dateCreated;
	int statusId;
	int invoiceId;

	
	public Orders(int orderId, int customerId, Date dateCreated, int statusId, int invoiceId) {
		this.orderId = orderId;
		this.customerId = customerId;
		this.dateCreated = dateCreated;
		this.statusId = statusId;
		this.invoiceId = invoiceId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public int getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}
	
}
