package com.techie.budget.service;

import com.techie.budget.dto.BudgetsRequest;
import com.techie.budget.entity.BudgetsEntity;

import java.util.List;

public interface BudgetService {

    public List<BudgetsEntity> getBudgets();

    public BudgetsEntity getBudgetById(Long id);

    public BudgetsEntity createBudget(BudgetsRequest expense) throws Exception;

    public BudgetsEntity updateBudget(BudgetsEntity budget);

    public String deleteBudget(Long id);

}
