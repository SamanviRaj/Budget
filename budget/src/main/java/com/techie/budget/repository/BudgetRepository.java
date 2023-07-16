package com.techie.budget.repository;

import com.techie.budget.entity.BudgetsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BudgetRepository extends JpaRepository<BudgetsEntity,Long> {
}
