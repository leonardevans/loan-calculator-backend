package com.loancalculator.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.loancalculator.dto.LoanRequestDTO;
import com.loancalculator.responses.ApiResponse;
import com.loancalculator.service.LoanService;
import com.loancalculator.util.HttpUtil;

import jakarta.validation.Valid;

import java.util.Map;

@RestController
@RequestMapping("/api/loan")
public class LoanAPI extends HttpUtil {

    private LoanService loanService;

    public LoanAPI(LoanService loanService) {
        this.loanService = loanService;
    }

    @CrossOrigin(origins = {"https://resilientsystems-loan-calculator.netlify.app/"})
    // @CrossOrigin(origins = {"http://localhost:3000", "https://resilientsystems-loan-calculator.netlify.app/"})
    @PostMapping("/calculate")
    public ResponseEntity<?> calculateLoan(
            @RequestBody @Valid LoanRequestDTO loanRequestDTO,
            BindingResult bindingResult) {
        ApiResponse apiResponse = null;

        // Check if there are validation errors
        if (bindingResult.hasErrors()){
            apiResponse = new ApiResponse(false, "Failed to caculate loan payment. Please provide correct information.");
            apiResponse.setErrors(this.getErrors(bindingResult));
            return ResponseEntity.badRequest().body(apiResponse);
        }

        // Call the loan service to calculate the loan payments
        Map<String, Double> result = loanService.calculateLoan(
                loanRequestDTO.getPrincipal(),
                loanRequestDTO.getInterestRate(),
                loanRequestDTO.getPeriodInYears());

        apiResponse = new ApiResponse(true, "Calculated loan payments successfully");
        apiResponse.setData(result);
        return ResponseEntity.ok().body(apiResponse);
    }
}

