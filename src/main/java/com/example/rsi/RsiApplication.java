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
import java.util.List;
import java.util.ArrayList;

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

    public static void main(String[] args) {
        SpringApplication.run(RsiApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //drop all cars
        carRepository.deleteAll();
        rentRepository.deleteAll();

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

//        reservationRepository.save(new Reservation(
//           carList.get(0).getId()
//        ));
//
//        reservationRepository.save(new Reservation(
//                carList.get(1).getId()
//        ));
    }
}
