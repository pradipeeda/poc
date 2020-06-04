package com.ibm.handson.receiveorderms;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.ibm.handson.receiveorderms.model.Customer;
import com.ibm.handson.receiveorderms.repo.CustomerRepository;

@SpringBootApplication
public class ReceiveordermsApplication {

	
	@Autowired
	CustomerRepository customerRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(ReceiveordermsApplication.class, args);
	}
	
	
	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			int beanCount = ctx.getBeanDefinitionCount();
			String[] beans = ctx.getBeanDefinitionNames();
			System.out.println("Bean Count = " + beanCount);
			for (int i = 0; i < beanCount; i++) {
				System.out.println(beans[i]);
			}
			seedItUp();

		};
	}

	@Transactional
	public void seedItUp() {
		
		Customer c= new Customer("CUST0001", "Pradeep", "pradeep2020");
		customerRepo.save(c);

		
	}

}
