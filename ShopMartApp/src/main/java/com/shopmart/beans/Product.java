package com.shopmart.beans;

public class Product {
	
	int productId;
	String productName;
	double productPrice;
	String productDescription;
	int categoryId;
	int avaliableQuantity;
	int soldQuantity;

	public Product(int productId, String productName, double productPrice, String productDescription, int categoryId,
			int avaliableQuantity, int soldQuantity) {
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productDescription = productDescription;
		this.categoryId = categoryId;
		this.avaliableQuantity = avaliableQuantity;
		this.soldQuantity = soldQuantity;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public int getAvaliableQuantity() {
		return avaliableQuantity;
	}

	public void setAvaliableQuantity(int avaliableQuantity) {
		this.avaliableQuantity = avaliableQuantity;
	}

	public int getSoldQuantity() {
		return soldQuantity;
	}

	public void setSoldQuantity(int soldQuantity) {
		this.soldQuantity = soldQuantity;
	}

}
