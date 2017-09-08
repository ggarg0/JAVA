package com.shopmart.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "CUSTOMER")
@Table(name = "CUSTOMER")
public class Customer {

	@Id
	@Column(name = "CUSTOMER_ID")
	int customerId;

	@Column(name = "FIRST_NAME")
	String firstName;

	@Column(name = "LAST_NAME")
	String lastName;

	@Column(name = "EMAIL_ID")
	String emailId;

	@Column(name = "PHONE_NUMBER")
	String phoneNumber;

	@Column(name = "ADDRESS")
	String address;

	@Column(name = "CITY")
	String city;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
