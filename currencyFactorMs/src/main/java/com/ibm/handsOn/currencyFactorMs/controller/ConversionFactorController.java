package com.ibm.handsOn.currencyFactorMs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.handsOn.currencyFactorMs.model.ConversionFactor;
import com.ibm.handsOn.currencyFactorMs.model.CurrencyConversion;
import com.ibm.handsOn.currencyFactorMs.service.CurrencyFactorService;

@RestController
@RequestMapping(path = "/currencyfactor")
public class ConversionFactorController {
	
	@Autowired
	private CurrencyFactorService currencyFactorService;
	
	@PostMapping("/addConversionFactor")
	public String addConversionFactor(@RequestBody ConversionFactor inConversionFactor)
	{
		return currencyFactorService.addUpdateConverSionFactor(inConversionFactor);			
	}
	
	@PostMapping("/updateConversionFactor")
	public String updateConversionFactor(@RequestBody ConversionFactor inConversionFactor)
	{
		return currencyFactorService.addUpdateConverSionFactor(inConversionFactor);					
	}
	
	@GetMapping("/getConversionFactor/{countrycode}")
	public ConversionFactor getConversionFactor(@PathVariable("countrycode") String inCountrycode)
	{
		System.out.println("inCountrycode ::::" + inCountrycode);
		return currencyFactorService.getConverSionFactor(inCountrycode);					
	}
	
	
	

}
