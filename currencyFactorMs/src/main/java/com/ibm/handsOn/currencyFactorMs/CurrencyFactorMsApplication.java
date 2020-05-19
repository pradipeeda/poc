package com.ibm.handsOn.currencyFactorMs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CurrencyFactorMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyFactorMsApplication.class, args);
	}

}
