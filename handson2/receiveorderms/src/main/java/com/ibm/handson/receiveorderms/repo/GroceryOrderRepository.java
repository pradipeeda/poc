package com.ibm.handson.receiveorderms.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ibm.handson.receiveorderms.model.GroceryOrder;

@Repository
public interface GroceryOrderRepository extends CrudRepository<GroceryOrder, Integer> {

}
