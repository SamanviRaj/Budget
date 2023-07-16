package com.techie.budget.dto;

import com.techie.budget.AppUtils.JsonMessage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.math.BigDecimal;
import com.fasterxml.jackson.core.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BudgetsRequest implements JsonMessage {

    private Long id;

    private BigDecimal income;

    private BigDecimal fiftyPercentAmount;

    private BigDecimal thirtyPercentAmount;

    private BigDecimal twentyPercentAmount;

    private Expense[] expenses;

    private BigDecimal expenseTotal;

    private String expenseItem;

    private BigDecimal expenseAmount;

    @Override
    public String toJson() {
        Writer writer = new StringWriter();
        try (JsonGenerator jg = new JsonFactory().createGenerator(writer)) {
            jg.writeStartObject();
            jg.writeStringField("@class", "com.techie.budget.dto.BudgetsRequest");
            jg.writeEndObject();
        } catch (IOException e) {
            throw new RuntimeException("Message serialization toJson failed", e);
        }
        return writer.toString();
    }
}
