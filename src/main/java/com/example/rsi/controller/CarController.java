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

    @PutMapping("/update/{id}")
    public Car editCar(@PathVariable("id") String id, @RequestBody Car car){
        Optional<Car> editedCar = carRepository.findById(id);
        if(car.getCarBrand() != null)
            editedCar.get().setCarBrand(car.getCarBrand());
        if(car.getCarModel() != null)
            editedCar.get().setCarModel(car.getCarModel());
        if(car.getProductionYear() != 0)
            editedCar.get().setProductionYear(car.getProductionYear());
        if(car.getPrice() != 0)
            editedCar.get().setPrice(car.getPrice());
        if(car.getStatus() != 0)
            editedCar.get().setStatus(car.getStatus());

        carRepository.save(editedCar.get());
        return editedCar.get();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCar(@PathVariable("id") String id){
        carRepository.deleteById(id);
    }

}

