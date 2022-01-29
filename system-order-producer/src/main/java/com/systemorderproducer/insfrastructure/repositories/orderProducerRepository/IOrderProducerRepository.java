package com.systemorderproducer.insfrastructure.repositories.orderProducerRepository;

import com.systemorderproducer.domain.model.orderProducer.OrderProducer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderProducerRepository extends JpaRepository<OrderProducer,Long> {
}
