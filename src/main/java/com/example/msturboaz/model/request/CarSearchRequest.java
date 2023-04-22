package com.example.msturboaz.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CarSearchRequest {
    private BigDecimal amountTo;
    private BigDecimal amountFrom;
    private String description;
}
