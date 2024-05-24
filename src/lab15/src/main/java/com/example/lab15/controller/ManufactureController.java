package com.example.lab15.controller;

import com.example.lab15.entity.Manufacture;
import com.example.lab15.service.ManufactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manufactures")
public class ManufactureController {
    @Autowired
    ManufactureService service;
    @GetMapping
    public List<Manufacture> getManufactures() {
        return service.getManufacture();
    }

    @PostMapping
    public Long createManufacture(@RequestBody Manufacture manufacture) {
        return service.createManufacture(manufacture);
    }

    @DeleteMapping("/{id}")
    public void deleteManufacture(@PathVariable Long id) {
        service.deleteManufacture(id);
    }
}
