package com.example.lab14.repository;

import com.example.lab14.entity.Manufacture;
import com.example.lab14.entity.Worker;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkerRepository extends JpaRepository<Worker, Long> {
    List<Worker> findAll(Specification<Worker> specification, Sort sort);
}