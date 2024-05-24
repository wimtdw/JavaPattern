package com.example.lab14.controller;

import com.example.lab14.Manufacture;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/manufactures")
public class ManufactureController {
    private ConcurrentHashMap<String, Manufacture> manufactures = new ConcurrentHashMap<>();

    @PostMapping
    public void createManufacture(@RequestBody Manufacture manufacture) {
        manufactures.put(manufacture.getName(), manufacture);
    }

    @GetMapping
    public ConcurrentHashMap<String, Manufacture> getAllManufactures() {
        return manufactures;
    }

    @DeleteMapping("/{name}")
    public void deleteManufacture(@PathVariable String name) {
        manufactures.remove(name);
    }
}
