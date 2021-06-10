package com.example.rsi.controller;

import com.example.rsi.model.Reservation;
import com.example.rsi.repository.ReservationRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
@CrossOrigin("*")
public class ReservationController {

    private final ReservationRepository reservationRepository;

    public ReservationController(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }


    @GetMapping("/all")
    public List<Reservation> getAllReservations(){
        return reservationRepository.findAll();
    }

    @PostMapping("/create")
    public Reservation createReservation(@RequestBody Reservation reservation){
        reservationRepository.save(reservation);
        return reservation;
    }

//    @PutMapping("/update")
//    public Reservation editReservation(@RequestBody Reservation reservation){
//        Reservation editedReservation = reservationRepository.findReservationById(reservation.getReservationId());
//        editedReservation.setCarId(reservation.getCarId());
//        return editedReservation;
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public void deleteReservation(@RequestParam String id){
//        reservationRepository.delete(reservationRepository.findReservationById(id));
//    }

}

