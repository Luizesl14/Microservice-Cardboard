package com.systemorderservice.domain.repository;

import com.systemorderservice.domain.entity.Os;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OsRepository extends JpaRepository<Os,Long> {
}
