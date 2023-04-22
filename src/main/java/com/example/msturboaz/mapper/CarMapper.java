package com.example.msturboaz.mapper;

import com.example.msturboaz.entity.CarEntity;
import com.example.msturboaz.model.request.CarRequest;
import com.example.msturboaz.model.dto.CarDto;

public class CarMapper {
    public static CarEntity mapToEntity(CarRequest carRequest) {

        return CarEntity.builder()
                .amount(carRequest.getAmount())
                .kind(carRequest.getKind())
                .name(carRequest.getName())
                .year(carRequest.getYear())
                .build();
    }

    public static CarDto mapToDto(CarEntity carEntity) {
        return CarDto.builder()
                .amount(carEntity.getAmount())
                .kind(carEntity.getKind())
                .name(carEntity.getName())
                .year(carEntity.getYear())
                .build();
    }

    public static void updateCar(CarRequest request,CarEntity entity){
        entity.setAmount(request.getAmount());
    }
}
