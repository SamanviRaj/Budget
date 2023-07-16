package com.techie.budget.controller;

import com.techie.budget.dto.BudgetsRequest;
import com.techie.budget.entity.BudgetsEntity;
import com.techie.budget.service.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/api/v1/budgets")
public class BudgetController {

    @Autowired
    private BudgetService budgetService;
    @GetMapping
    public ResponseEntity<List<BudgetsEntity>> getBudgets(){
        return new ResponseEntity<>(budgetService.getBudgets(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<BudgetsEntity> createBudget(@RequestBody BudgetsRequest budgetsRequest) throws Exception {
        return new ResponseEntity<>(budgetService.createBudget(budgetsRequest), HttpStatus.CREATED);
    }
    @GetMapping("{id}")
    public ResponseEntity<BudgetsEntity> getBudgetById(@PathVariable Long id){
        return new ResponseEntity<>(budgetService.getBudgetById(id),HttpStatus.OK);
    }
 }
