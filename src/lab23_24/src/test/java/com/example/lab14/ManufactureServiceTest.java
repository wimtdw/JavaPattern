package com.example.lab14;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

import com.example.lab14.entity.Manufacture;
import com.example.lab14.repository.ManufactureRepository;
import com.example.lab14.service.ManufactureService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;


import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ManufactureServiceTest {
    @Mock
    private ManufactureRepository manufactureRepository;

    @Captor
    ArgumentCaptor<Manufacture> captor;

    @Test
    public void createManufacture() {
        Manufacture manufacture = new Manufacture(3L, "m1", "addr1");
        ManufactureService service = new ManufactureService(manufactureRepository);
        service.createManufacture(manufacture);
        Mockito.verify(manufactureRepository).save(captor.capture());
        Manufacture captured = captor.getValue();
        assertEquals("addr1", captured.getAddress());
    }

    @Test
    public void getManufactures() {
        Manufacture manufacture = new Manufacture(3L, "m1", "addr1");
        Manufacture manufacture2 = new Manufacture(5L, "m2", "addr2");
        Mockito.when(manufactureRepository.findAll()).thenReturn(List.of(manufacture, manufacture2));
        ManufactureService service = new ManufactureService(manufactureRepository);
        Assertions.assertEquals(2, service.getManufacture().size());
        Assertions.assertEquals("addr1", service.getManufacture().get(0).getAddress());
    }

    @Test
    public void deleteManufacture() {
        Long id = (long)1;
        manufactureRepository.deleteById(id);
    }

    @Test
    public void getManufacturesSortedBy() {
        Manufacture manufacture = new Manufacture(3L, "m1", "addr1");
        Manufacture manufacture2 = new Manufacture(5L, "m2", "addr2");
        Mockito.when(manufactureRepository.findAll(any(Specification.class), any(Sort.class))).thenReturn(List.of(manufacture, manufacture2));
        ManufactureService service = new ManufactureService(manufactureRepository);
        Assertions.assertEquals(2, service.getManufacturesSortedBy("type").size());
    }
}
