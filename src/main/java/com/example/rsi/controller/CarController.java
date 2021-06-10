package com.example.rsi.controller;

import com.example.rsi.model.Car;
import com.example.rsi.repository.CarRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("/create")
    public Car createCar(@RequestBody Car car){
        carRepository.save(car);
        return car;
    }

    @PutMapping("/update")
    public Car editCar(@RequestBody Car car){
        Car editedCar = carRepository.findCarById(car.getId());
        editedCar.setCarBrand(car.getCarBrand());
        editedCar.setCarModel(car.getCarModel());

        return editedCar;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCar(@RequestParam String id){
        carRepository.delete(carRepository.findCarById(id));
    }

}

