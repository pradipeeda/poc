package com.ibm.handson.receiveorderms.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.handson.receiveorderms.model.Customer;
import com.ibm.handson.receiveorderms.model.GroceryOrder;
import com.ibm.handson.receiveorderms.model.OrderItem;
import com.ibm.handson.receiveorderms.model.OrderRequest;
import com.ibm.handson.receiveorderms.repo.CustomerRepository;
import com.ibm.handson.receiveorderms.repo.GroceryOrderRepository;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class ReceiveOrderService {
	
	@Autowired
	CustomerRepository customerRepo;
	
	@Autowired
	GroceryOrderRepository groceryOrderRepo;
	
	public String getServiceTokenForUser(String inTransactionToken) {
		// TODO Auto-generated method stub
			String customerId = getCustomeridFromTransactionToken(inTransactionToken);
			
			Map<String, Object> claims = new HashMap<>();
			
			claims.put("customerid", customerId);
			String token =  Jwts.builder().setClaims(claims).setSubject(customerId).setIssuedAt(new Date(System.currentTimeMillis()))
					.setExpiration(new Date(System.currentTimeMillis() + 5*60 * 1000))
					.signWith(SignatureAlgorithm.HS512, "receiveorderms").compact();
			
			System.out.println("token : " + token);
			return token;
		}
	
	

		public String getCustomeridFromTransactionToken(String token) {
			Claims claims = getAllClaimsFromToken( token);
			
			return (String)claims.get("customerid");
			
		}

		private  Claims getAllClaimsFromToken(String token) {
			return Jwts.parser().setSigningKey("loginms").parseClaimsJws(token).getBody();
		}


		@Transactional
		public void createOrder(String userToken, String transactionToken, String serviceToken, OrderRequest inOrderRequest) {
			// TODO Auto-generated method stub
			String customerId = getCustomeridFromTransactionToken(transactionToken);
			
			Customer c = customerRepo.findByCustomerId(customerId);
			System.out.println(" customerid" + c.getCustomerId() );
			
			GroceryOrder order = new GroceryOrder();
			System.out.println(" customerid2" + c.getCustomerId() );
			order.setCustomerId(customerId);
			order.setServiceToken(serviceToken);
			order.setTransactionToken(transactionToken);
			order.setUserToken(userToken);
			
			List<OrderItem> orderItemList = inOrderRequest.getOrderItems();
			orderItemList.forEach(orderItem->{
				orderItem.groceryorder = order;
			});
			
			order.setOrderItems(orderItemList);
			order.customer = c;
			//groceryOrderRepo.save(order);
			System.out.println("c ::::" + c.toString());
			c.getOrders().add(order);
			
			System.out.println("c ::::" + c.toString());
			customerRepo.save(c);
			
		
			
		}
	
	

}
