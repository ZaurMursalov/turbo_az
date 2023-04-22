package com.example.msturboaz.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CarRequest {
    private String name;
    private String kind;
    private Long year;
    private Long amount;

}
