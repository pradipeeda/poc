package com.ibm.handsOn.currencyFactorMs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "currencyconversion")
public class CurrencyConversion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(name = "countrycode", table = "currencyconversion")
	private String countryCode;
	@Column(name = "conversionfactor",table = "currencyconversion")
	private double conversionFactor;
	
	public CurrencyConversion(){
		super();
	}
	
	public CurrencyConversion(Integer inId,String inCountryCode, double inConversionFactor)
	{
		super();
		this.id = inId;
		this.countryCode = inCountryCode;
		this.conversionFactor = inConversionFactor;
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public double getConversionFactor() {
		return conversionFactor;
	}

	public void setConversionFactor(double conversionFactor) {
		this.conversionFactor = conversionFactor;
	}
	

}
