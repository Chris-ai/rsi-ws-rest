package com.example.rsi.repository;

import com.example.rsi.model.Reservation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ReservationRepository extends MongoRepository<Reservation, String> {
    Optional<Reservation> findById(String id);
}
