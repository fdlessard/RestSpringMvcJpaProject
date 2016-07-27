package com.lessard.codesamples.order.repositories;


import com.lessard.codesamples.order.model.SalesOrder;

public interface SalesOrderRepository {

	SalesOrder findByPrimaryKey(Integer id);

	Iterable<SalesOrder> findAll();

	void save(SalesOrder salesOrder);

	void delete(Integer id);

	void update(SalesOrder salesOrder);
	
}
