package com.techie.budget.AppUtils;

import com.techie.budget.dto.BudgetsRequest;
import com.techie.budget.entity.BudgetsEntity;
import org.springframework.stereotype.Component;

@Component
public class AppUtils {

    public static BudgetsEntity mapToBudgetEntity(BudgetsRequest expense){
        BudgetsEntity budgets = new BudgetsEntity();
        budgets.setId(expense.getId());
        budgets.setIncome(expense.getIncome());
        return budgets;
    }

    public static BudgetsRequest mapToBudgeDTO(BudgetsEntity Budget){
        BudgetsRequest expense = new BudgetsRequest();
        expense.setId(Budget.getId());
        expense.setIncome(Budget.getIncome());
        return expense;
    }
}
