package com.example.lab15.controller;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class HomeController {
    @GetMapping("/home")
    public String hello() {
        return "index.html";
    }
}
