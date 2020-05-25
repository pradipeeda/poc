package com.ibm.handsOn.convertcurrency.service;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ibm.handsOn.convertcurrency.model.ConversionFactor;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;

@FeignClient(name = "currencyfactorms")
@RibbonClient(name = "currencyfactorms")
public interface CurencyConvFactorProxy {
	
	@GetMapping("/currencyfactor/getConversionFactor/{countrycode}")
	public ConversionFactor getConversionFactor(@PathVariable("countrycode") String inCountryCode);
	
	
	
}
