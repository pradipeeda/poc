package com.ibm.handson.loginms.service;

import java.util.Date;

import com.ibm.handson.loginms.model.IAMTokenResponse;
import com.ibm.handson.loginms.model.User;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class LoginService {

	public String getServiceTokenForUser(User inUser) {
		// TODO Auto-generated method stub
	
			Map<String, Object> claims = new HashMap<>();
			//retreive customerid using userid and then set here
			claims.put("customerid", "CUST0001");
			String token =  Jwts.builder().setClaims(claims).setSubject(inUser.getUserId()).setIssuedAt(new Date(System.currentTimeMillis()))
					.setExpiration(new Date(System.currentTimeMillis() + 2*60 * 1000))
					.signWith(SignatureAlgorithm.HS512, "loginms").compact();
			
			System.out.println("token : " + token);
			return token;
		}
	
	
	public String getTransactionTokenForUser(User inUser) {
		// TODO Auto-generated method stub
	
			Map<String, Object> claims = new HashMap<>();
			claims.put("customerid", "CUST0001");
			String token =  Jwts.builder().setClaims(claims).setSubject(inUser.getUserId()).setIssuedAt(new Date(System.currentTimeMillis()))
					.setExpiration(new Date(System.currentTimeMillis() + 5*60 * 1000))
					.signWith(SignatureAlgorithm.HS512, "loginms").compact();
			
			System.out.println("token : " + token);
			return token;
		}
	
	public String getUserTokenForUser(User inUser) {
		// TODO Auto-generated method stub
	
		
		
		RestTemplate restTemplate = new RestTemplate();
		
		StringBuilder url = new StringBuilder("https://iam.cloud.ibm.com/identity/token?");
		url.append("grant_type=urn:ibm:params:oauth:grant-type:apikey")
		.append("&")
		.append("apikey=mXFCcK5KRVEQS53lc8wEIxQhmRCjKzV_9MD9oydl8hT7");
		IAMTokenResponse tmpResponse =   restTemplate.postForObject(url.toString(), null, IAMTokenResponse.class);
				

		
		
			
			System.out.println("token : " + tmpResponse.getAccess_token());
			return tmpResponse.getAccess_token();
		}
	
		
	

}
