package com.dncoyote.expensetracker.controller;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dncoyote.expensetracker.DTO.ExpenseRequestDto;
import com.dncoyote.expensetracker.common.ExpenseTrackerException;
import com.dncoyote.expensetracker.common.ExpenseTrackerConstants;
import com.dncoyote.expensetracker.common.Response;
import com.dncoyote.expensetracker.model.Expense;
import com.dncoyote.expensetracker.service.GoogleApiService;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/expensetracker/v1")
public class ExpenseTrackerController {

    @Autowired
    private GoogleApiService googleApiService;

    @GetMapping("/getData")
    public ResponseEntity<Response<List<Expense>>> readDataFromGoogleSheet(@ModelAttribute ExpenseRequestDto reqDto)
            throws GeneralSecurityException, IOException, NumberFormatException, ParseException {
        try {
            return ResponseEntity
                    .ok(new Response<List<Expense>>(ExpenseTrackerConstants.SUCCESS_MESSAGE,
                            googleApiService.readDataFromGoogleSheet(reqDto)));
        } catch (ExpenseTrackerException e) {
            // Handle custom application-specific exception
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new Response<>("Error: " + e.getMessage(), null));
        } catch (Exception e) {
            // Handle unexpected exceptions
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new Response<>(ExpenseTrackerConstants.ERROR_MESSAGE, null));
        }
    }

    @GetMapping("/check")
    public String check() {
        return "hello";
    }

}