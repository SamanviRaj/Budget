package com.techie.budget.dto;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.techie.budget.AppUtils.JsonMessage;
import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.math.BigDecimal;

@Data
@Component
public class Expense implements JsonMessage {

    private String expenseItem;

    private BigDecimal expenseAmount;

    private String expenseCategory;

    @Override
    public String toJson() {
        Writer writer = new StringWriter();
        try (JsonGenerator jg = new JsonFactory().createGenerator(writer)) {
            jg.writeStartObject();
            if(getExpenseItem() != null)
            jg.writeStringField("expenseItem", getExpenseItem());
            if(getExpenseAmount() != null)
            jg.writeStringField("expenseAmount", getExpenseAmount().toString());
            if(getExpenseCategory() != null)
            jg.writeStringField("expenseCategory",getExpenseCategory());
            jg.writeEndObject();
        } catch (IOException e) {
            throw new RuntimeException("Message serialization toJson failed", e);
        }
        return writer.toString();
    }
}
