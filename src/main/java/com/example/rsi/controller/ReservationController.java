package com.example.rsi.controller;

import com.example.rsi.model.Reservation;
import com.example.rsi.repository.ReservationRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reservations")
@CrossOrigin("*")
public class ReservationController {

    private ReservationRepository reservationRepository;

    public ReservationController(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @GetMapping("/all")
    public List<Reservation> getAllReservations(){
        return reservationRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Reservation> getReservation(@PathVariable("id") String id){
        return reservationRepository.findById(id);
    }

    @PostMapping("/create")
    public Reservation createReservation(@RequestBody Reservation reservation){
        return reservationRepository.save(reservation);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteReservation(@PathVariable("id") String id){
        reservationRepository.deleteById(id);
    }

}

