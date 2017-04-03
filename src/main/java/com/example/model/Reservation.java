package com.example.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Noel on 4/3/17.
 */
@Entity
@Data
@NoArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue
    private Long id;

    public Reservation(String reservationName) {
        this.reservationName = reservationName;
    }

    private String reservationName;

}
