package com.ibm.handson.loginms.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.handson.loginms.model.User;
import com.ibm.handson.loginms.service.LoginService;

@RestController
@RequestMapping(path = "/login")
public class LoginController {
	
	@Autowired
	LoginService  loginService;
	
	@PostMapping("/authenticate")
	public String getAccessTokensForUser(@RequestBody User inUser,HttpServletResponse response)
	{
		 System.out.println("USer :" + inUser.getUserId());
		 response.setHeader("api_token", loginService.getUserTokenForUser(inUser));
		 response.setHeader("transaction_token", loginService.getTransactionTokenForUser(inUser));
		 response.setHeader("service_token", loginService.getServiceTokenForUser(inUser));
		 
		 return "SUCCESS";
	}

}
