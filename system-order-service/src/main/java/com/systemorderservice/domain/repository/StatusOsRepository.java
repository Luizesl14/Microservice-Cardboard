package com.systemorderservice.domain.repository;

import com.systemorderservice.domain.entity.StatusOsType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusOsRepository extends JpaRepository<StatusOsType,Long> {
}
