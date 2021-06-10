package com.example.rsi.repository;

import com.example.rsi.model.Rent;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RentRepository extends MongoRepository<Rent, String> {
    Optional<Rent> findById(String id);
}
