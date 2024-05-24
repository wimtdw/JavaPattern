package com.example.lab14.controller;

import com.example.lab14.entity.Manufacture;
import com.example.lab14.entity.Worker;
import com.example.lab14.service.ManufactureService;
import com.example.lab14.service.WorkerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/manufactures")
public class ManufactureController {
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
