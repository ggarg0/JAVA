package com.shopmart.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "CUSTOMER_ROLE")
@Table(name = "CUSTOMER_ROLE")
public class CustomerRole {

	@Id
	@Column(name = "CUSTOMER_ID")
	int customerId;
	
	@Column(name = "USERNAME")
	String username;
	
	@Column(name = "PASSWORD")
	String password;
	
	@Column(name = "ROLE")
	String role;
	
	@Column(name = "ENABLED")
	int enabled;
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getEnabled() {
		return enabled;
	}
	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}
}
