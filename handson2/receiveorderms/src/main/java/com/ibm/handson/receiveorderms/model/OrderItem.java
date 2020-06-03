package com.ibm.handson.receiveorderms.model;


import javax.persistence.*;

@Entity(name = "orderitem")
public class OrderItem {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "productname", table = "orderitem")
	private String productname;
	
	@Column(name = "productname", table = "orderitem")
	private String productQuantity;

}
