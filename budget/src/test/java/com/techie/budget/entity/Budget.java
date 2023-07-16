package com.techie.budget.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "budgets")
public class Budget {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private BigDecimal incomeAmount;
    @Column
    private BigDecimal fiftyPercentAmount;
    @Column
    private BigDecimal thirtyPercentAmount;
    @Column
    private BigDecimal twentyPercentAmount;
    @Column
    private String expenseItem;
    @Column
    private BigDecimal expenseAmount;
    @Column
    private String expenseCategory;
    @Column
    private BigDecimal expenseTotal;
    @Column
    private BigDecimal savings;

}
