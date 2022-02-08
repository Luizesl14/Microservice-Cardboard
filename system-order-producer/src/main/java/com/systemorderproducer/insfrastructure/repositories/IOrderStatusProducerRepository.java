package com.systemorderproducer.insfrastructure.repositories;

import com.systemorderproducer.domain.model.OrderProducer;
import com.systemorderproducer.domain.model.OrderStatusProducer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderStatusProducerRepository extends JpaRepository<OrderStatusProducer,Integer> {
}
