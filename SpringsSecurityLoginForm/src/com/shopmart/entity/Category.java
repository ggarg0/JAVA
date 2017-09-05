package com.shopmart.entity;

public class Category {

	int categoryId;
	String categoryName;
	String categoryTag;

	public Category(int categoryId, String categoryName, String categoryTag) {
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.categoryTag = categoryTag;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryTag() {
		return categoryTag;
	}

	public void setCategoryTag(String categoryTag) {
		this.categoryTag = categoryTag;
	}
}
