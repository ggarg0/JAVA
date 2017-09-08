package com.shopmart.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity(name = "ORDER_STATUS")
@Table(name = "ORDER_STATUS")
public class OrderStatus {

	@Id
	@Column(name = "STATUS_ID")
	int statusId;
	
	@Column(name = "STATUS")
	String status;
	
	@Column(name = "DESCRIPTION")
	String description;


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
