package com.example.rsi.controller;

import com.example.rsi.model.Car;
import com.example.rsi.repository.CarRepository;
import org.springframework.web.bind.annotation.*;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cars")
@CrossOrigin("*")
public class CarController {

    private final CarRepository carRepository;

    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }


    @GetMapping("/all")
    public List<Car> getAllCars(){
        return carRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Car> getCarById(@PathVariable("id") String id){
        return carRepository.findById(id);
    }

    @PostMapping("/create")
    public Car createCar(@RequestBody Car car){
        carRepository.save(car);
        return car;
    }

    @PutMapping("/update")
    public Car editCar(@RequestBody Car car){
        carRepository.save(car);
        return car;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCar(@PathVariable("id") String id){
        carRepository.deleteById(id);
    }

}

