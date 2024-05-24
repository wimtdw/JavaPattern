package com.example.lab14.repository;

import com.example.lab14.entity.Task;
import com.example.lab14.entity.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
