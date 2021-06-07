package com.example.rsi;

import com.example.rsi.model.Car;
import com.example.rsi.repository.CarRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RsiApplication implements CommandLineRunner {

    public RsiApplication(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    private CarRepository carRepository;

    public static void main(String[] args) {
        SpringApplication.run(RsiApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //drop all cars
        carRepository.deleteAll();

        carRepository.save(new Car(
                "Audi",
                "RS6",
                2018,
                150
        ));

        carRepository.save(new Car(
                "BMW",
                "e36",
                2004,
                50
        ));

        carRepository.save(new Car(
                "Volkswagen",
                "Golf",
                2010,
                60
        ));

        carRepository.save(new Car(
                "Audi",
                "A3-8V",
                2016,
                100
        ));

        carRepository.save(new Car(
                "Toyota",
                "Yaris",
                2008,
                50
        ));
    }
}
