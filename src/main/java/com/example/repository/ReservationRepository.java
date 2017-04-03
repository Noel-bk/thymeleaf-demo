package com.example.repository;

import com.example.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Noel on 4/3/17.
 */
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
