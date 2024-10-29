package com.itschool.tableq.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "reviews")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long id;

    @Column(nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(name = "restaurant_id", updatable = false)
    private Restaurant restaurant;

    @ManyToOne
    @JoinColumn(name = "user_id", updatable = false)
    private User user;

    @Builder
    public Review(String content, Restaurant restaurant, User user){
        this.content = content;
        this.restaurant = restaurant;
        this.user = user;
    }
}