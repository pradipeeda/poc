package com.ibm.handson.loginservicems.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ibm.handson.loginservicems.model.User;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class LoginService {

	public String getAccessTokensForUser(User inUser) {
		// TODO Auto-generated method stub
	
			Map<String, Object> claims = new HashMap<>();
			String token =  Jwts.builder().setClaims(claims).setSubject(inUser.getUserId()).setIssuedAt(new Date(System.currentTimeMillis()))
					.setExpiration(new Date(System.currentTimeMillis() + 5*60 * 1000))
					.signWith(SignatureAlgorithm.HS512, "groceryapp").compact();
			
			System.out.println("token : " + token);
			return token;
		}
	
		
	

}
