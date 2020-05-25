package com.ibm.handsOn.convertcurrency.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.handsOn.convertcurrency.model.ConversionFactor;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
@Service
public class CurrencyConverterService {

	@Autowired
	private CurencyConvFactorProxy curencyConvFactorProxy;
	
	 @HystrixCommand(fallbackMethod = "convertToRupeeFallback",commandProperties = {
	            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "50000")
	        })
	public String convertToRupee(String countryCode, double amount) {
		
		System.out.println("countryCode/amount" + amount + ":" + countryCode);
		ConversionFactor conversionFactor = curencyConvFactorProxy.getConversionFactor(countryCode);
		StringBuilder message = new StringBuilder();

			double amountInRupees = amount*conversionFactor.getConversionFactor();
			String amountInString = Double.toString(amountInRupees);
			
			
			message.append("Amount of ")
					.append(amount)
					.append(" in ")
					.append(countryCode)
					.append(" is equivalent to ")
					.append( amountInRupees)
					.append(" Rupees.");
	
		
		
		
		
		// TODO Auto-generated method stub
		return message.toString();
	}
	
	
	public String convertToRupeeFallback(String countryCode, double amount) {
		
	
		String 	message = " Service Unavailable. Please try after sometime";

		// TODO Auto-generated method stub
		return message;
	}

}
