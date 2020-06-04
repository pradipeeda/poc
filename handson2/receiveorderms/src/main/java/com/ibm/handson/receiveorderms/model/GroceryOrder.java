package com.ibm.handson.receiveorderms.model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity(name = "groceryorder")
public class GroceryOrder implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", table = "groceryorder")
	private Integer id;
	
	@Column(name = "customerid", table = "groceryorder")
	private String customerId;
		
	@Column(name = "usertoken", table = "groceryorder" , length = 2000)
	private String userToken;
	
	@Column(name = "transactiontoken", table = "groceryorder", length = 2000)
	private String transactionToken;
	
	@Column(name = "servicetoken", table = "groceryorder" , length = 2000)
	private String serviceToken;
	
//	//@OneToMany(targetEntity = OrderItem.class)
	 @OneToMany(mappedBy = "groceryorder", fetch = FetchType.LAZY,
     cascade = CascadeType.ALL)
	private List<OrderItem> orderItems;
	 
	 
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customer_customerid", nullable = false)
	public Customer customer;

	
	public GroceryOrder() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public GroceryOrder(Integer id, String customerid,Customer inCustomer) {
		super();
		this.id = id;
		this.customer = inCustomer;
//		this.orderItems = orderItems;
	}



	public Integer getId() {
		return id;
	}

	public void setOrderid(Integer orderid) {
		this.id = orderid;
	}

//	public String getCustomerid() {
//		return customerId;
//	}
//
//	public void setCustomerid(String customerid) {
//		this.customerId = customerid;
//	}



	public String getCustomerId() {
		return customerId;
	}


	public String getUserToken() {
		return userToken;
	}


	public void setUserToken(String userToken) {
		this.userToken = userToken;
	}


	public String getTransactionToken() {
		return transactionToken;
	}


	public void setTransactionToken(String transactionToken) {
		this.transactionToken = transactionToken;
	}


	public String getServiceToken() {
		return serviceToken;
	}


	public void setServiceToken(String serviceToken) {
		this.serviceToken = serviceToken;
	}


	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}


	public List<OrderItem> getOrderItems() {
		return orderItems;
	}



	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}


	
	
	
	
	

}
