package com.example.controller;

import com.example.model.Reservation;
import com.example.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.stream.Stream;

/**
 * Created by Noel on 4/3/17.
 */
@Controller
public class ReservationController {

    @Autowired
    private ReservationRepository reservationRepository;


    @GetMapping(value = "/reservations")
    public String reservations(Model model) {
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, Locale.getDefault());
        model.addAttribute("serverTime", dateFormat.format(new Date()));
        saveMockData();
        model.addAttribute("reservations", reservationRepository.findAll());

        model.addAttribute("noel", reservationRepository.save(new Reservation("Noel")));
        model.addAttribute("booleanValue", true);
        model.addAttribute("nullValue", null);

        return "reservation";
    }

    private void saveMockData() {
        reservationRepository.deleteAll();
        Stream.of("Penny", "Bernadette", "Amy", "Emily")
            .forEach(name -> reservationRepository.save(new Reservation(name)));
        reservationRepository.findAll().forEach(System.out::println);
    }
}
