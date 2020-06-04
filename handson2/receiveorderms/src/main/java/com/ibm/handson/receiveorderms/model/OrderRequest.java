package com.ibm.handson.receiveorderms.model;

import java.util.ArrayList;
import java.util.List;

public class OrderRequest {

	private List<OrderItem> orderItems = new ArrayList<OrderItem>();

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	
	
}
