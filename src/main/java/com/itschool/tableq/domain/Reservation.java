package com.itschool.tableq.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDateTime;

@Table(name = "reservations")
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    /*@Column(nullable = false)
    private String contactNumber;*/

    @Column(nullable = false, updatable = false)
    private Integer reservationNumber;

    @Column(nullable = false)
    @ColumnDefault("false")
    private boolean isEntered;

    @Column(nullable = false, updatable = false)
    private LocalDateTime reserveTime;

    private LocalDateTime enteredTime;

    private Integer people;

    @ManyToOne
    @JoinColumn(name = "store_id",updatable = false)
    private Store store;

    @ManyToOne
    @JoinColumn(name = "user_id", updatable = false)
    private User user;

    @Builder
    public Reservation(Integer reservationNumber,
                       LocalDateTime reserveTime, Integer people, Store store, User user){
        this.reservationNumber = reservationNumber;
        this.reserveTime = reserveTime;
        this.people = people;
        this.store = store;
        this.user = user;
    }
}
