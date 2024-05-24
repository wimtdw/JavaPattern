package com.example.lab14.service;

import java.util.List;

import com.example.lab14.entity.Manufacture;
import com.example.lab14.entity.Worker;
import com.example.lab14.repository.WorkerRepository;
import com.example.lab14.specs.ManufactureSpec;
import com.example.lab14.specs.WorkerSpec;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Slf4j
public class WorkerService {
    private final WorkerRepository workerRepository;

    public Long createWorker(Worker worker) {
        workerRepository.save(worker);
        return worker.getId();
    }

    public List<Worker> getWorkers() {
        return workerRepository.findAll();
    }

    public List<Worker> getWorkersSortedBy(String attributeName) {
        Sort sort = Sort.by(Sort.Direction.ASC, attributeName);
        return workerRepository.findAll(WorkerSpec.sortBy(attributeName), sort);
    }

    public void deleteWorker(Long id) {
        workerRepository.deleteById(id);
    }
}
