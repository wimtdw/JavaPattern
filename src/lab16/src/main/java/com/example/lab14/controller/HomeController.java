package com.example.lab14.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.*;

@org.springframework.stereotype.Controller
public class HomeController {
    @GetMapping("/home")
    public String hello() {
        return "index.html";
    }
}
