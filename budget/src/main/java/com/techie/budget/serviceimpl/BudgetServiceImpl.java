package com.techie.budget.serviceimpl;

import com.techie.budget.AppUtils.AppUtils;
import com.techie.budget.dto.BudgetsRequest;
import com.techie.budget.dto.Expense;
import com.techie.budget.entity.BudgetsEntity;
import com.techie.budget.repository.BudgetRepository;
import com.techie.budget.service.BudgetService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
@Service
public class BudgetServiceImpl implements BudgetService {

    private final String COMA = ",";
    private final String BRAKET_OPEN = "[";
    private final String BRAKET_CLOSE = "]";

    @Autowired
    private BudgetRepository budgetRepository;

    @Override
    public List<BudgetsEntity> getBudgets() {
        return budgetRepository.findAll();
    }

    @Override
    public BudgetsEntity getBudgetById(Long id) {
        return budgetRepository.findById(id).get();
    }

    @Override
    public BudgetsEntity createBudget(BudgetsRequest budgetsRequest) throws Exception {
        BudgetsEntity budgetsEntity = new BudgetsEntity();
        budgetsEntity.setIncome(budgetsRequest.getIncome());
        budgetCalculations(budgetsRequest,budgetsEntity);
        budgetsEntity.setExpenses(convertExpensesObjecttoString(budgetsRequest).replaceAll("[\"]", ""));
        return budgetRepository.save(budgetsEntity);
    }
    @Override
    public BudgetsEntity updateBudget(BudgetsEntity budget) {
        BudgetsEntity updatedBudget = budgetRepository.findById(budget.getId()).get();
//        updatedBudget.setExpenseAmount(budget.getExpenseAmount());
//        updatedBudget.setExpenseItem(budget.getExpenseItem());
//        updatedBudget.setExpenseAmount(budget.getExpenseAmount());
        return budgetRepository.save(updatedBudget);
    }

    @Override
    public String deleteBudget(Long id) {
        budgetRepository.deleteById(id);
        return "Deleted Budget Sucessfully";
    }

    private String convertExpensesObjecttoString(BudgetsRequest budgetsRequest){
        StringBuilder sb = new StringBuilder(128);
        if(budgetsRequest.getExpenses().length > 0) {
            int length = budgetsRequest.getExpenses().length;
            sb.append(BRAKET_OPEN);
            for (Expense e : budgetsRequest.getExpenses()) {
                sb.append(e.toJson());
                length = length - 1;
                if (length > 0) {
                    sb.append(COMA);
                }
            }
            sb.append(BRAKET_CLOSE);
        }
        System.out.println("!!!!! budget Expenses request "+sb.toString());
        return sb.toString();
    }

    private void budgetCalculations(BudgetsRequest budgetsRequest, BudgetsEntity budgetsEntity) throws Exception {

        BigDecimal fiftyPercent = budgetsRequest.getIncome().multiply(new BigDecimal("0.5"));
        BigDecimal thirtyPercent = budgetsRequest.getIncome().multiply(new BigDecimal("0.3"));
        BigDecimal twentyPercent = budgetsRequest.getIncome().multiply(new BigDecimal("0.2"));
        BigDecimal expenseSum = new BigDecimal(0);

        budgetsEntity.setFiftyPercentAmount(fiftyPercent);
        budgetsEntity.setThirtyPercentAmount(thirtyPercent);
        budgetsEntity.setTwentyPercentAmount(twentyPercent);

        for (Expense e: budgetsRequest.getExpenses()) {
            expenseSum = e.getExpenseAmount().add(expenseSum);
        }

        budgetsEntity.setExpenseTotal(expenseSum);
    }

    public List<Expense> convertExpensesObjecttoList(BudgetsRequest budgetsRequest) throws Exception {
        JSONArray jsonArray = new JSONArray(budgetsRequest.getExpenses());
        List<Expense> expenseList = new ArrayList<>();
        int i = 0;
        while (i < jsonArray.length()) {
            Expense exp = new Expense();
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            exp.setExpenseItem(jsonObject.getString("expenseItem"));
            exp.setExpenseItem(jsonObject.getString("expenseAmount"));
            exp.setExpenseItem(jsonObject.getString("expenseCategory"));
            expenseList.add(exp);
        }
        return expenseList;
    }
}
