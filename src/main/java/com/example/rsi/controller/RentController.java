package com.example.rsi.controller;

import com.example.rsi.model.Rent;
import com.example.rsi.repository.RentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rents")
@CrossOrigin("*")
public class RentController {

    private final RentRepository rentRepository;

    public RentController(RentRepository rentRepository) {
        this.rentRepository = rentRepository;
    }

    @GetMapping("/all")
    public List<Rent> getAllRents(){
        return rentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Rent> getRentById(@PathVariable("id") String id){
        return rentRepository.findById(id);
    }

    @PostMapping("/create")
    public Rent createRent(@RequestBody Rent rent){
        rentRepository.save(rent);
        return rent;
    }

    @PutMapping("/update/{id}")
    public Rent editRent(@PathVariable("id") String id, @RequestBody Rent rent){
        Optional<Rent> editedRent = rentRepository.findById(id);
        if(editedRent.isPresent()){
            if(rent.getReservationId() != null)
                editedRent.get().setReservationId(rent.getReservationId());
            if(rent.getStartDate() != null)
                editedRent.get().setStartDate(rent.getStartDate());
            if(rent.getRentTime() != 0)
                editedRent.get().setRentTime(rent.getRentTime());

            rentRepository.save(editedRent.get());
            return editedRent.get();
        }
        return null;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteRent(@PathVariable("id") String id){
        rentRepository.deleteById(id);
    }

}

