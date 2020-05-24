package com.ibm.handsOn.convertcurrency.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ibm.handsOn.convertcurrency.model.ConversionFactor;

@FeignClient(name = "currencyfactorms")
public interface CurencyConvFactorProxy {
	
	@GetMapping("/currencyfactor/getConversionFactor/{countrycode}")
	public ConversionFactor getConversionFactor(@PathVariable("countrycode") String inCountryCode);
}
