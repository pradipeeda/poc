package com.ibm.handsOn.convertcurrency;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.netflix.ribbon.proxy.annotation.Hystrix;

@SpringBootApplication
@EnableFeignClients
@EnableHystrix
@EnableHystrixDashboard
@EnableEurekaClient
public class ConvertcurrencyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConvertcurrencyApplication.class, args);
	}

}
