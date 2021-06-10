package com.example.rsi.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Rent")
public class Rent {

    @Id
    private String rentId;
    private int reservationId;
    private String startDate;
    private int rentTime;

    public Rent(int reservationId, String startDate, int rentTime) {
        this.reservationId = reservationId;
        this.startDate = startDate;
        this.rentTime = rentTime;
    }

    public String getRentId() {
        return rentId;
    }

    public void setRentId(String rentId) {
        this.rentId = rentId;
    }

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public int getRentTime() {
        return rentTime;
    }

    public void setRentTime(int rentTime) {
        this.rentTime = rentTime;
    }
}
