package com.dncoyote.expensetracker.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Expense {

    private String category;
    private String type;
    private double amount;
    private String description;
    private String date;

}