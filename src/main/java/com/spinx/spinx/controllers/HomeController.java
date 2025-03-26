package com.spinx.spinx.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String handleRegistration(
            @RequestParam String name,
            @RequestParam String enroll,
            @RequestParam String room,
            @RequestParam String email,
            @RequestParam String phone,
            @RequestParam String password,
            @RequestParam String confirmPassword,
            Model model
    ) {

        // TODO: Save to DB (you can handle later)
        System.out.println("Registered: " + name + ", " + enroll +", " +password);

        return "redirect:/login";
    }


    @GetMapping("/login")
    public String login() {
        return "login";
    }

}
