package com.systemcontroller.insfrastructure.repositories;

import com.systemcontroller.domain.model.Deashboard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDeashBoardRepository extends JpaRepository<Deashboard, Integer> {
}
