package com.ibm.handson.receiveorderms.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "customer")
public class Customer {
	@Id	
	@Column(name = "customerid", table = "customer")
	private String customerId;
	
	@Column(name = "customername", table = "customer")
	String customerName = "";
	
	@Column(name = "username", table = "customer")
	String username = "";
	
	
	 @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY,
     cascade = CascadeType.ALL)
	private List<GroceryOrder> orders = new ArrayList<GroceryOrder>();
	
	public Customer(String id, String customerName, String username) {
		super();
		this.customerId = id;
		this.customerName  = customerName;
		this.username = username;
	}

	

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}



	public String getCustomerId() {
		return customerId;
	}



	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}



	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		customerName = customerName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<GroceryOrder> getOrders() {
		return orders;
	}

	public void setOrders(List<GroceryOrder> orders) {
		this.orders = orders;
	}



	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", username=" + username
			 + "]";
	}
	
	

}
