package com.dncoyote.expensetracker.service;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dncoyote.expensetracker.DTO.ExpenseRequestDto;
import com.dncoyote.expensetracker.common.ExpenseTrackerException;
import com.dncoyote.expensetracker.model.Expense;
import com.dncoyote.expensetracker.util.GoogleApiUtil;

@Service
public class GoogleApiService {

    @Autowired
    private GoogleApiUtil googleApiUtil;

    public List<Expense> readDataFromGoogleSheet(ExpenseRequestDto reqDto)
            throws GeneralSecurityException, IOException, NumberFormatException, ParseException {
        try {
            return googleApiUtil.getDataFromGoogleSheet(reqDto);
        } catch (IOException | GeneralSecurityException | NumberFormatException | ParseException e) {
            throw new ExpenseTrackerException("Error while fetching data from Google Sheet.", e);
        }
    }

}
