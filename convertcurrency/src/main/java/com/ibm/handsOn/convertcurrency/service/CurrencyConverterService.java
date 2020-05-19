package com.ibm.handsOn.convertcurrency.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.handsOn.convertcurrency.model.ConversionFactor;
@Service
public class CurrencyConverterService {

	@Autowired
	private CurencyConvFactorProxy curencyConvFactorProxy;
	public String convertToRupee(String countryCode, double amount) {
		
		System.out.println("countryCode/amount" + amount + ":" + countryCode);
		ConversionFactor conversionFactor = curencyConvFactorProxy.getConversionFactor(countryCode);
		double amountInRupees = amount*conversionFactor.getConversionFactor();
		String amountInString = Double.toString(amountInRupees);
		// TODO Auto-generated method stub
		return amountInString;
	}

}
