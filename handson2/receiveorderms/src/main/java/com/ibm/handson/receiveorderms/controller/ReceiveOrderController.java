package com.ibm.handson.receiveorderms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.handson.receiveorderms.model.GroceryOrder;
import com.ibm.handson.receiveorderms.model.OrderRequest;
import com.ibm.handson.receiveorderms.service.ReceiveOrderService;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/receiveorder")
public class ReceiveOrderController {
	
	@Autowired
	ReceiveOrderService receiveOrderService;
	
	@RequestMapping("/processorder")
	public void processOrder(@RequestBody OrderRequest inorder ,HttpServletRequest request)
	{
		String userToken = request.getHeader("api_token");
		String transactionToken = request.getHeader("transaction_token");
		
		
		String serviceToken = receiveOrderService.getServiceTokenForUser(transactionToken );
		
		receiveOrderService.createOrder(userToken,transactionToken,serviceToken,inorder);
	}

}
