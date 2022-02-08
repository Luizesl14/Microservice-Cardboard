package com.systemorderproducer.insfrastructure.repositories;

import com.systemorderproducer.domain.model.OrderProducer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderProducerRepository extends JpaRepository<OrderProducer,Integer> {
}
