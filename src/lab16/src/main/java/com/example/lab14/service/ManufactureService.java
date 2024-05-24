package com.example.lab14.service;

import java.util.List;

import com.example.lab14.entity.Manufacture;
import com.example.lab14.repository.ManufactureRepository;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ManufactureService {
    private final ManufactureRepository manufactureRepository;

    public Long createManufacture(Manufacture manufacture) {
        manufactureRepository.save(manufacture);
        return manufacture.getId();
    }

    public List<Manufacture> getManufacture() {
        return manufactureRepository.findAll();
    }

    public void deleteManufacture(Long id) {
        manufactureRepository.deleteById(id);
    }
}
