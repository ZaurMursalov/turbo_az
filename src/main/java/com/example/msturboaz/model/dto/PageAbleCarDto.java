package com.example.msturboaz.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PageAbleCarDto {
    private List<CarDto> cars;
    private long totalElements;
    private int totalPages;
    private boolean hasNExtPage;
}
