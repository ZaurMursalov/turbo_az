package com.example.msturboaz.service;
import com.example.msturboaz.model.dto.CarDto;
import com.example.msturboaz.entity.CarEntity;
import com.example.msturboaz.model.dto.PageAbleCarDto;
import com.example.msturboaz.model.request.CarRequest;
import com.example.msturboaz.model.request.CarSearchRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarService {
   PageAbleCarDto getFilterCars(int page, int count, CarSearchRequest searchRequest);
   void saveCars(CarRequest carRequest);
   List<CarEntity> getAllCar();
   CarDto getCar(String name);

void updateCars(Long id,CarRequest request);

}


