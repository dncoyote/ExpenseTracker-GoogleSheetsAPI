package com.dncoyote.expensetracker.controller;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dncoyote.expensetracker.model.Expense;
import com.dncoyote.expensetracker.service.GoogleApiService;

@RestController
public class ExpenseTrackerController {

    @Autowired
    private GoogleApiService googleApiService;

    @GetMapping("/getData")
    public List<Expense> readDataFromGoogleSheet() throws GeneralSecurityException, IOException {
        return googleApiService.readDataFromGoogleSheet();
    }

    // @PostMapping("/createSheet")
    // public GoogleSheetResponseDTO createGoogleSheet(@RequestBody GoogleSheetDTO
    // request)
    // throws GeneralSecurityException, IOException {
    // return googleApiService.createSheet(request);
    // }

    @GetMapping("/check")
    public String check() {
        return "hello";
    }

}
