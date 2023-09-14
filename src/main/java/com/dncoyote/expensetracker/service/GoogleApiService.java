package com.dncoyote.expensetracker.service;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dncoyote.expensetracker.model.Expense;
import com.dncoyote.expensetracker.util.GoogleApiUtil;

@Service
public class GoogleApiService {

    @Autowired
    private GoogleApiUtil googleApiUtil;

    public List<Expense> readDataFromGoogleSheet() throws GeneralSecurityException, IOException {
        return googleApiUtil.getDataFromGoogleSheet();
    }

    // public Map<Object, Object> readDataFromGoogleSheet() throws GeneralSecurityException, IOException {
    //     return googleApiUtil.getDataFromGoogleSheet();
    // }

    // public GoogleSheetResponseDTO createSheet(GoogleSheetDTO request) throws
    // GeneralSecurityException, IOException {
    // return googleApiUtil.createGoogleSheet(request);
    // }
}
