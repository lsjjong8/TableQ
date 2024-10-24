package com.itschool.tableq.network.Response;

import com.itschool.tableq.domain.Reservation;
import com.itschool.tableq.domain.Store;
import com.itschool.tableq.domain.User;

import java.time.LocalDateTime;

public class ReservationResponse {
    private Long id;
    private Integer reservation_number;
    private boolean isEntered;
    private LocalDateTime reserveTime;
    private LocalDateTime enteredTime;
    private Integer people;
    private Store store;
    private User user;

    public ReservationResponse(Reservation reservation) {
        this.id = reservation.getId();
        this.reservation_number = reservation.getReservationNumber();
        this.isEntered = reservation.isEntered();
        this.reserveTime = reservation.getReserveTime();
        this.enteredTime = reservation.getEnteredTime();
        this.people = reservation.getPeople();
        this.store = reservation.getStore();
        this.user = reservation.getUser();
    }
}