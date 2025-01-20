package com.loancalculator.service;

import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class LoanService {

    public Map<String, Double> calculateLoan(double principal, double interestRate, int periodInYears) {
        double monthlyRate = (interestRate / 100) / 12;
        int totalMonths = periodInYears * 12;

        // Monthly payment using the amortization formula
        double monthlyPayment = (principal * monthlyRate) /
                (1 - Math.pow(1 + monthlyRate, -totalMonths));

        // Weekly and yearly payments
        double weeklyPayment = (monthlyPayment * 12) / 52;
        double yearlyPayment = monthlyPayment * 12;

        // Result
        Map<String, Double> result = new HashMap<>();
        result.put("monthlyPayment", monthlyPayment);
        result.put("weeklyPayment", weeklyPayment);
        result.put("yearlyPayment", yearlyPayment);
        return result;
    }
}