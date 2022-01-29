package com.systemorderservice.domain.repository;

import com.systemorderservice.domain.model.OrderService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderServiceRepository extends JpaRepository<OrderService,Long> {
}