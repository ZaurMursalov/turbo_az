package com.example.msturboaz.repository;
import com.example.msturboaz.entity.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<CarEntity,Long>,
        JpaSpecificationExecutor<CarEntity> {
     Optional<CarEntity> findByName(String name);
}
