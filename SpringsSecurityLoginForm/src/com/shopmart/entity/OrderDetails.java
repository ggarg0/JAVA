package com.shopmart.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "ORDER_DETAILS")
@Table(name = "ORDER_DETAILS")
public class OrderDetails {

@Id
	@Column(name = "ORDER_ID")
	int ordersId;
	
	@Column(name = "PRODUCT_ID")
	int productId;
	
	@Column(name = "QUANTITY")
	int quantity;


	public int getOrdersId() {
		return ordersId;
	}

	public void setOrdersId(int ordersId) {
		this.ordersId = ordersId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
