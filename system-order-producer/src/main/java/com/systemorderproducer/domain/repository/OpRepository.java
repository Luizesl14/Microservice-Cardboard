package com.systemorderproducer.domain.repository;

import com.systemorderproducer.domain.entity.Op;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpRepository extends JpaRepository<Op,Long> {
}
