package com.example.msturboaz.controller;
import com.example.msturboaz.model.dto.CarDto;
import com.example.msturboaz.model.dto.PageAbleCarDto;
import com.example.msturboaz.model.request.CarRequest;
import com.example.msturboaz.model.request.CarSearchRequest;
import com.example.msturboaz.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v2/car")
@RequiredArgsConstructor
public class CarController {
    private final CarService carService;
    @PostMapping
    public void saveCars(@RequestBody CarRequest carRequest) {
        carService.saveCars(carRequest);
    }

    @GetMapping("/{name}")
    public CarDto getCarName(@PathVariable String name) {
        return carService.getCar(name);
    }
    @GetMapping
    public PageAbleCarDto getFilterCar(@RequestParam int page, @RequestParam int count,
                                       CarSearchRequest searchRequest){
        return carService.getFilterCars(page, count, searchRequest);
    }
    @PatchMapping("/{id}/amount")
    public void updateCars(@PathVariable Long id,@RequestBody CarRequest amount){
        carService.updateCars(id,amount);
    }


}
