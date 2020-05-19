package com.ibm.handsOn.currencyFactorMs.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ibm.handsOn.currencyFactorMs.model.CurrencyConversion;

@Repository
public interface CurrencyConversionRepository extends CrudRepository<CurrencyConversion, Integer> {

	@Query("select curr_conv from currencyconversion curr_conv where curr_conv.countryCode = ?1")
	CurrencyConversion findByCountryCode(@Param("countrycode") String inCountryCode);
}
