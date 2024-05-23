package com.example.lab14.service;

import java.util.List;

import com.example.lab14.entity.Manufacture;
import com.example.lab14.repository.ManufactureRepository;
import com.example.lab14.specs.ManufactureSpec;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Slf4j
@Transactional
public class ManufactureService {
    private final ManufactureRepository manufactureRepository;
//    @Autowired
//    private EmailService emailService;
    public Long createManufacture(Manufacture manufacture) {
        manufactureRepository.save(manufacture);
//        emailService.sendMessage("", "Object creation", manufacture.toString());
        return manufacture.getId();
    }

    public List<Manufacture> getManufacture() {
        return manufactureRepository.findAll();
    }

    public List<Manufacture> getManufacturesSortedBy(String attributeName) {
        Sort sort = Sort.by(Sort.Direction.ASC, attributeName);
        return manufactureRepository.findAll(ManufactureSpec.sortBy(attributeName), sort);
    }

    public void deleteManufacture(Long id) {
        manufactureRepository.deleteById(id);
    }
}
