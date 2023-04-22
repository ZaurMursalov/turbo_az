package com.example.msturboaz.service.impl;
import com.example.msturboaz.exception.ExceptionConstant;
import com.example.msturboaz.exception.NotFoundException;
import com.example.msturboaz.model.dto.CarDto;
import com.example.msturboaz.entity.CarEntity;
import com.example.msturboaz.mapper.CarMapper;
import com.example.msturboaz.model.dto.PageAbleCarDto;
import com.example.msturboaz.model.request.CarSearchRequest;
import com.example.msturboaz.repository.CarRepository;
import com.example.msturboaz.model.request.CarRequest;
import com.example.msturboaz.service.CarService;
import com.example.msturboaz.specification.CarSpecification;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.msturboaz.exception.ExceptionConstant.UNEXPECTED_EXCEPTION_CODE;
import static com.example.msturboaz.exception.ExceptionConstant.UNEXPECTED_EXCEPTION_MESSAGE;


@Service
@RequiredArgsConstructor
@Slf4j
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;


    @Override
    public PageAbleCarDto getFilterCars(int page, int count, CarSearchRequest searchRequest) {
        log.info("ActionLog.getFilterCars.start");
        var pageable= PageRequest.of(page,count, Sort.by(Sort.Direction.ASC,"amount"));
        var pageAbleCars=
                carRepository.findAll(
                        new CarSpecification(searchRequest),pageable);
        var cars=pageAbleCars.getContent()
                .stream()
                .map(CarMapper::mapToDto)
                .collect(Collectors.toList());
        log.info("ActionLog.getFilterCars.start");
        return PageAbleCarDto.builder()
                .cars(cars)
                .totalPages(pageAbleCars.getTotalPages())
                .totalElements(pageAbleCars.getTotalElements())
                .hasNExtPage(pageAbleCars.hasNext())
                .build();
    }

    @Override
    public void saveCars(CarRequest carRequest) {
        carRepository.save(CarMapper.mapToEntity(carRequest));
    }

    @Override
    public List<CarEntity> getAllCar() {
        return carRepository.findAll();
    }

    @Override
    public CarDto getCar(String name) {
       var car=fetchExistsName(name);
       return CarMapper.mapToDto(car);

    }

    @Override
    public void updateCars(Long id, CarRequest request) {
        var car=fetchExistsId(id);
        CarMapper.updateCar(request,car);
        carRepository.save(car);
    }


    private CarEntity fetchExistsName(String name){
        return carRepository.findByName(name).orElseThrow(()->new RuntimeException("THIS_CAR_NOT_FOUND"));
    }
    private CarEntity fetchExistsId(Long id){
        return carRepository.findById(id) .orElseThrow(()-> new NotFoundException(UNEXPECTED_EXCEPTION_CODE,UNEXPECTED_EXCEPTION_MESSAGE));
    }
}
