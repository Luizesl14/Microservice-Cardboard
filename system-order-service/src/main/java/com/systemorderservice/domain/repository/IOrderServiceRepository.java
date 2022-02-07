package com.systemorderservice.domain.repository;

import com.systemorderservice.domain.model.OrderService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IOrderServiceRepository extends JpaRepository<OrderService,Integer> {

    @Query("Select od from OrderService od where od.shippingForProduction = true")
    List<OrderService> findOrderServiceBy();
}
