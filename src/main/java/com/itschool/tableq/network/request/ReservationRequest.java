package com.itschool.tableq.network.request;

import com.itschool.tableq.domain.Store;
import com.itschool.tableq.domain.User;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ReservationRequest {
    private Long id;
    private String contactNumber;
    private Integer reservationNumber;
    private boolean isEntered;
    private LocalDateTime reserveTime;
    private LocalDateTime enteredTime;
    private Integer people;
    private Store store;
    private User user;
}