package com.example.lab14.controller;

import com.example.lab14.Worker;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/workers")
public class WorkController {
    private ConcurrentHashMap<String, Worker> workers = new ConcurrentHashMap<>();

    @PostMapping
    public void createWorker(@RequestBody Worker worker) {
        workers.put(worker.getLastName(), worker);
    }

    @GetMapping
    public ConcurrentHashMap<String, Worker> getAllWorkers() {
        return workers;
    }

    @DeleteMapping("/{lastName}")
    public void deleteWorker(@PathVariable String lastName) {
        workers.remove(lastName);
    }
}
