package com.dncoyote.expensetracker.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//Expense
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Expense {
    public Expense(Object object, Object object2) {
        this.type = (String) object;
        this.amount = (double) object2;
    }

    private String type;
    private double amount;

}
