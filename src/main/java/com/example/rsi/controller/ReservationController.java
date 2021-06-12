package com.example.rsi.controller;

import com.example.rsi.model.Car;
import com.example.rsi.model.Reservation;
import com.example.rsi.repository.CarRepository;
import com.example.rsi.repository.ReservationRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reservations")
@CrossOrigin("*")
public class ReservationController {

    private final ReservationRepository reservationRepository;
    private final CarRepository carRepository;

    public ReservationController(ReservationRepository reservationRepository, CarRepository carRepository) {
        this.reservationRepository = reservationRepository;
        this.carRepository = carRepository;
    }

    @GetMapping("/all")
    public List<Reservation> getAllReservations(){
        return reservationRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Reservation> getReservationById(@PathVariable("id") String id){
        return reservationRepository.findById(id);
    }

    @PostMapping("/create")
    public Reservation createReservation(@RequestBody Reservation reservation){
        Optional<Car> car = carRepository.findById(reservation.getCarId());
        car.get().setStatus(1);
        carRepository.save(car.get());
        reservationRepository.save(reservation);
        return reservation;
    }

    @PutMapping("/update/{id}")
    public Reservation editReservation(@PathVariable("id") String id, @RequestBody Reservation reservation){
        Optional<Reservation> editedReservation = reservationRepository.findById(id);
        if(editedReservation.isPresent()){
            if(reservation.getCarId() != null)
                editedReservation.get().setCarId(reservation.getCarId());

            reservationRepository.save(editedReservation.get());
            return editedReservation.get();
        }
        return null;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteReservation(@PathVariable("id") String id){
        reservationRepository.deleteById(id);
    }

}

