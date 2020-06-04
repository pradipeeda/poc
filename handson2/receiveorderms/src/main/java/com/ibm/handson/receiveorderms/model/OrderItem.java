package com.ibm.handson.receiveorderms.model;


import java.io.Serializable;

import javax.persistence.*;

@Entity(name = "orderitem")
public class OrderItem implements Serializable{

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "productname", table = "orderitem")
	private String productname;
	
	@Column(name = "productquantity", table = "orderitem")
	private String productQuantity;
	
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "groceryorder_id", nullable = false)
	public GroceryOrder groceryorder;

	public OrderItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderItem(Integer id, String productname, String productQuantity,GroceryOrder inGroceryOrder ) {
		super();
		this.id = id;
		this.productname = productname;
		this.productQuantity = productQuantity;
		this.groceryorder = inGroceryOrder;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(String productQuantity) {
		this.productQuantity = productQuantity;
	}

	@Override
	public String toString() {
		return "OrderItem [id=" + id==null?"":id + ", productname=" + productname + ", productQuantity=" + productQuantity
				+ ", groceryorder=" + groceryorder + "]";
	}
	
	
	

}
