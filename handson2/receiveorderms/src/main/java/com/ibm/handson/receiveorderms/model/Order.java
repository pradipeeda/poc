package com.ibm.handson.receiveorderms.model;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity(name = "order")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "customerid", table = "order")
	private String customerid;

	@OneToMany(targetEntity = OrderItem.class, mappedBy = "id", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<OrderItem> tags = new ArrayList<OrderItem>();
	
	
	
	

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Order(Integer id, String customerid, List<OrderItem> tags) {
		super();
		this.id = id;
		this.customerid = customerid;
		this.tags = tags;
	}



	public Integer getId() {
		return id;
	}

	public void setOrderid(Integer orderid) {
		this.id = orderid;
	}

	public String getCustomerid() {
		return customerid;
	}

	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}

	public List<OrderItem> getTags() {
		return tags;
	}

	public void setTags(List<OrderItem> tags) {
		this.tags = tags;
	}
	
	
	

}
