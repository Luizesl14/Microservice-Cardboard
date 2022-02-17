package com.systemcontroller.insfrastructure.repositories;

import com.systemcontroller.domain.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICompanyRepository extends JpaRepository<Company, Integer> {
}
