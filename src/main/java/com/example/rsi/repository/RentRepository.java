package com.example.rsi.repository;

import com.example.rsi.model.Rent;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RentRepository extends MongoRepository<Rent, String> {
}
