package com.shopmart.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity (name = "CATEGORY")
@Table(name="CATEGORY")
public class Category {

	@Id
	@Column(name="CATEGORY_ID")
	int categoryId;
	 
	@Column(name="CATEGORY_NAME")
	String categoryName;
	 
	@Column(name="CATEGORY_TAG")
	String categoryTag;

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
