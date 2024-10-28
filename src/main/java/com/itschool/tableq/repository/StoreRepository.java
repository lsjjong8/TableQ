package com.itschool.tableq.repository;

import com.itschool.tableq.domain.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StoreRepository extends JpaRepository<Restaurant, Long> {
    Optional<Restaurant> findById(Long id);
}
