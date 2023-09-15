package com.dncoyote.expensetracker.controller;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dncoyote.expensetracker.common.Response;
import com.dncoyote.expensetracker.model.Expense;
import com.dncoyote.expensetracker.service.GoogleApiService;

@RestController
@CrossOrigin("http://localhost:3000")
public class ExpenseTrackerController {

    @Autowired
    private GoogleApiService googleApiService;

    @GetMapping("/getData")
    public ResponseEntity<Response<List<Expense>>> readDataFromGoogleSheet()
            throws GeneralSecurityException, IOException {
        return ResponseEntity.ok(new Response<List<Expense>>("Success", googleApiService.readDataFromGoogleSheet()));
    }

    @GetMapping("/check")
    public String check() {
        return "hello";
    }

}