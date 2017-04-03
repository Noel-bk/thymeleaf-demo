package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Noel on 4/1/17.
 */
@Controller
public class HomeController {

    @GetMapping(value = "/")
    public String home(Model model) {
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, Locale.getDefault());
        model.addAttribute("message", "YOLO!");
        model.addAttribute("serverTime", dateFormat.format(new Date()));
        return "home";
    }

}
