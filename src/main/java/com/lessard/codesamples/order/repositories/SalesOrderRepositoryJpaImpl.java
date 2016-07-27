package com.lessard.codesamples.order.repositories;

import com.lessard.codesamples.order.model.SalesOrder;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Component
public class SalesOrderRepositoryJpaImpl implements SalesOrderRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public SalesOrder findByPrimaryKey(Integer id) {

		return 	entityManager.find(SalesOrder.class, id);
	}

	@Override
	public List<SalesOrder> findAll() {

        String s = "SELECT o FROM SalesOrder o ORDER BY o.id";

		TypedQuery<SalesOrder> query = entityManager.createQuery(s, SalesOrder.class);

		return query.getResultList();

	}

    @Override
	public void save(SalesOrder salesOrder) {

        entityManager.persist(salesOrder);
	}

    @Override
	public void delete(Integer id) {

		SalesOrder salesOrder = entityManager.find(SalesOrder.class, id);
		if(salesOrder != null){
			entityManager.remove(salesOrder);
		}
    }

    @Override
    public void	update(SalesOrder salesOrder) {

        entityManager.merge(salesOrder);
	}
}
