package com.example.rsi.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Rent")
public class Rent {

    @Id
    private String rentId;
    private String reservationId;
    private String startDate;
    private int rentTime;

    public String getCarInfo() {
        return carInfo;
    }

    public void setCarInfo(String carInfo) {
        this.carInfo = carInfo;
    }

    private String carInfo;

    public Rent(String reservationId, String startDate, int rentTime, String carInfo) {
        this.reservationId = reservationId;
        this.startDate = startDate;
        this.rentTime = rentTime;
        this.carInfo = carInfo;
    }

    public String getRentId() {
        return rentId;
    }

    public void setRentId(String rentId) {
        this.rentId = rentId;
    }

    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
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
