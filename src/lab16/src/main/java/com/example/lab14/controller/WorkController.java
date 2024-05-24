package com.example.lab14.controller;

import com.example.lab14.entity.Worker;
import com.example.lab14.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/workers")
public class WorkController {
    @Autowired
    WorkerService service;
    @GetMapping
    public List<Worker> getWorkers() {
        return service.getWorkers();
    }

    @PostMapping
    public Long createWorker(@RequestBody Worker worker) {
        return service.createWorker(worker);
    }

    @DeleteMapping("/{id}")
    public void deleteWorker(@PathVariable Long id) {
        service.deleteWorker(id);
    }
}
