package com.example.rsi;

import com.example.rsi.model.Car;
import com.example.rsi.model.Rent;
import com.example.rsi.model.Reservation;
import com.example.rsi.repository.CarRepository;
import com.example.rsi.repository.RentRepository;
import com.example.rsi.repository.ReservationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

@ServletComponentScan
@SpringBootApplication
public class RsiApplication implements CommandLineRunner {

    public RsiApplication(CarRepository carRepository, RentRepository rentRepository, ReservationRepository reservationRepository) {
        this.carRepository = carRepository;
        this.rentRepository = rentRepository;
        this.reservationRepository = reservationRepository;
    }

    private CarRepository carRepository;
    private RentRepository rentRepository;
    private ReservationRepository reservationRepository;
    private List<Car> carList = new ArrayList<>();
    private List<Reservation> reservationList = new ArrayList<>();

    public static void main(String[] args) {
        SpringApplication.run(RsiApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //drop all cars
        carRepository.deleteAll();
        rentRepository.deleteAll();
        reservationRepository.deleteAll();

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

        carList = carRepository.findAll();

        reservationRepository.save(new Reservation(
                carList.get(0).getId(),
                carList.get(0).getCarBrand() + " " + carList.get(0).getCarModel()

        ));
        Car car = carList.get(0);
        car.setStatus(1);
        carRepository.save(car);

        reservationRepository.save(new Reservation(
                carList.get(1).getId(),
                carList.get(1).getCarBrand() + " " + carList.get(1).getCarModel()
        ));
        car = carList.get(1);
        car.setStatus(1);
        carRepository.save(car);

        reservationRepository.save(new Reservation(
                carList.get(2).getId(),
                carList.get(2).getCarBrand() + " " + carList.get(2).getCarModel()
        ));
        car = carList.get(2);
        car.setStatus(1);
        carRepository.save(car);

        reservationList = reservationRepository.findAll();

        rentRepository.save(new Rent(
                reservationList.get(0).getReservationId(),
                new Date().toString(),
                100,
                carList.get(0).getCarBrand() + " " + carList.get(0).getCarModel()
        ));
        car = carList.get(0);
        car.setStatus(2);
        carRepository.save(car);

        rentRepository.save(new Rent(
                reservationList.get(1).getReservationId(),
                new Date().toString(),
                200,
                carList.get(1).getCarBrand() + " " + carList.get(1).getCarModel()
        ));
        car = carList.get(1);
        car.setStatus(2);
        carRepository.save(car);
    }
}
