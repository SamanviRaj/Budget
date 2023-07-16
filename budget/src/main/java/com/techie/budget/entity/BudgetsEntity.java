package com.techie.budget.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
public class BudgetsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private BigDecimal income;
    @Column
    private BigDecimal fiftyPercentAmount;
    @Column
    private BigDecimal thirtyPercentAmount;
    @Column
    private BigDecimal twentyPercentAmount;
    @Column
    private String expenses;
    @Column
    private BigDecimal expenseTotal;

}

