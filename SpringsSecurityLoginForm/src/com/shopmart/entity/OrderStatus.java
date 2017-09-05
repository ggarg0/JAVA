package com.shopmart.entity;

public class OrderStatus {

	int statusId;
	String status;
	String description;

	
	public OrderStatus(int statusId, String status, String description) {
		super();
		this.statusId = statusId;
		this.status = status;
		this.description = description;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
