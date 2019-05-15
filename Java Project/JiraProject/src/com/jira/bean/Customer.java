package com.jira.bean;

import java.util.List;

public class Customer {

	private String id;
	private String name;
	private String type;
	//List<CustomerChild> details;
	CustomerChild[] details;
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public CustomerChild[] getDetails() {
		return details;
	}
	public void setDetails(CustomerChild[] details) {
		this.details = details;
	}
	
	
}
