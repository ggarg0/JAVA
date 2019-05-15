package com.jira.bean;

public class ProductComponent {

	private String self;
	private String value;
	private String id;
	ProductComponentChild child;
	
	public String getSelf() {
		return self;
	}
	public void setSelf(String self) {
		this.self = self;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public ProductComponentChild getChild() {
		return child;
	}
	public void setChild(ProductComponentChild child) {
		this.child = child;
	}
	
}
