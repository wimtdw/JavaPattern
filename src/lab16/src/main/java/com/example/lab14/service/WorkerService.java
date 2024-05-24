package com.example.lab14.service;

import java.util.List;

import com.example.lab14.entity.Worker;
import com.example.lab14.repository.WorkerRepository;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class WorkerService {
    private final WorkerRepository workerRepository;

    public Long createWorker(Worker worker) {
        workerRepository.save(worker);
        return worker.getId();
    }

    public List<Worker> getWorkers() {
        return workerRepository.findAll();
    }

    public void deleteWorker(Long id) {
        workerRepository.deleteById(id);
    }
}
