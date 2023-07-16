package com.techie.budget.dto;

import java.math.BigDecimal;
import java.util.List;

public class BudgetsResponse {

    private Long id;

    private BigDecimal income;

    private BigDecimal fiftyPercentAmount;

    private BigDecimal thirtyPercentAmount;

    private BigDecimal twentyPercentAmount;

    private Expense[] expenses;

    private String expenseCategory;

    private BigDecimal expenseTotal;

    private String expenseItem;

    private BigDecimal expenseAmount;

}
