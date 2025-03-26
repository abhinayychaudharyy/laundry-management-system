package com.spinx.spinx.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GeneralController {

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }

    @GetMapping("/track")
    public String track() {
        return "track";
    }

}
