package com.example.lab14.repository;

import com.example.lab14.entity.Manufacture;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ManufactureRepository extends JpaRepository<Manufacture, Long> {
    List<Manufacture> findAll(Specification<Manufacture> specification, Sort sort);
}
