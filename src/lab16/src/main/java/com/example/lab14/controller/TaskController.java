package com.example.lab14.controller;

import com.example.lab14.entity.Task;
import com.example.lab14.entity.Worker;
import com.example.lab14.service.TaskService;
import com.example.lab14.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    TaskService service;
    @GetMapping
    public List<Task> getTasks() {
        return service.getTasks();
    }

    @PostMapping
    public Long createTask(@RequestBody Task task) {
        return service.createTask(task);
    }

}
