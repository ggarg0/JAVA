package com.shopmart.entity;

public class OrderDetails {

	int ordersId;
	int productId;
	int quantity;

	
	public OrderDetails(int ordersId, int productId, int quantity) {
		super();
		this.ordersId = ordersId;
		this.productId = productId;
		this.quantity = quantity;
	}

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
