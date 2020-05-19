package com.ibm.handsOn.currencyFactorMs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.handsOn.currencyFactorMs.model.ConversionFactor;
import com.ibm.handsOn.currencyFactorMs.model.CurrencyConversion;
import com.ibm.handsOn.currencyFactorMs.repo.CurrencyConversionRepository;

@Service
public class CurrencyFactorService {
	
	@Autowired CurrencyConversionRepository currencyConversionRepository;

	public String addUpdateConverSionFactor(ConversionFactor inConversionFactor) {
		
		CurrencyConversion existingCurrencyConversion  = currencyConversionRepository.findByCountryCode(inConversionFactor.getCountryCode());
		
		String tmpReturn = "FAILED";
		if(inConversionFactor.getCountryCode()!= null && inConversionFactor.getCountryCode().length() >0)
		{
			if(existingCurrencyConversion!= null)
			{
				existingCurrencyConversion.setConversionFactor(inConversionFactor.getConversionFactor());
				currencyConversionRepository.save(existingCurrencyConversion);
				tmpReturn = "UPDATED";
			}
			else
			{
				CurrencyConversion newCurrencyConversion = new CurrencyConversion();
				newCurrencyConversion.setCountryCode(inConversionFactor.getCountryCode());
				newCurrencyConversion.setConversionFactor(inConversionFactor.getConversionFactor());
				currencyConversionRepository.save(newCurrencyConversion);
				tmpReturn = "ADDED";
			}
		}
		// TODO Auto-generated method stub
		return tmpReturn;
	}

	public ConversionFactor getConverSionFactor(String inCountrycode) {
		CurrencyConversion existingCurrencyConversion  = currencyConversionRepository.findByCountryCode(inCountrycode);
		
		ConversionFactor newConversionFactor = new ConversionFactor();
		if(existingCurrencyConversion!= null)
		{
			newConversionFactor.setCountryCode(existingCurrencyConversion.getCountryCode());
			newConversionFactor.setConversionFactor(existingCurrencyConversion.getConversionFactor());
		}
		// TODO Auto-generated method stub
		return newConversionFactor;
	}
	


}
