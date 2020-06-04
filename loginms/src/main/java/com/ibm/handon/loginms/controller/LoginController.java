package com.ibm.handon.loginms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.handon.loginms.model.User;
import com.ibm.handon.loginms.service.LoginService;

@RestController
@RequestMapping(path = "/loginms")
public class LoginController {
	
	@Autowired
	LoginService  loginService;
	
	@PostMapping("/authenticate")
	public String getAccessTokensForUser(@RequestBody User inUser)
	{
		System.out.println("USer :" + inUser.getUserId());
		return loginService.getAccessTokensForUser(inUser);			
	}

}
