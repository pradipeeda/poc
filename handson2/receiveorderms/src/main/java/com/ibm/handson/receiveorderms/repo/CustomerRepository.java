package com.ibm.handson.receiveorderms.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ibm.handson.receiveorderms.model.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, String> {

	@Query("select cust from customer cust where cust.customerId = ?1")
	Customer findByCustomerId(@Param("customerid") String inCustomerId);
}
