package com.systemorderservice.domain.repository;

import com.systemorderservice.domain.model.enums.StatusOrderServiceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusOrderServiceRepository extends JpaRepository<StatusOrderServiceType, Long> {
}