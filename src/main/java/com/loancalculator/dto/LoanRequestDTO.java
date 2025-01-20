package com.loancalculator.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LoanRequestDTO {

    @NotNull(message = "Principal is required")
    @Min(value = 100, message = "Principal must be at least 100")
    private Double principal;

    @NotNull(message = "Interest rate is required")
    @Min(value = 1, message = "Interest rate must be at least 1%")
    private Double interestRate;

    @NotNull(message = "Period in years is required")
    @Min(value = 1, message = "Period must be at least 1 year")
    private Integer periodInYears;

    // Getters and Setters
}
