package com.example.lab14;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

import com.example.lab14.entity.Worker;
import com.example.lab14.repository.WorkerRepository;
import com.example.lab14.service.WorkerService;
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
public class WorkerServiceTest {
    @Mock
    private WorkerRepository workerRepo;

    @Captor
    ArgumentCaptor<Worker> captor;

    @Test
    public void createWorker() {
        Worker worker = new Worker(1L, "Test1", "Test2", "Test3");
        WorkerService service = new WorkerService(workerRepo);
        service.createWorker(worker);
        Mockito.verify(workerRepo).save(captor.capture());
        Worker captured = captor.getValue();
        assertEquals(1L, captured.getId());
    }

    @Test
    public void getWorkers() {
        Worker worker = new Worker(1L, "Test1", "Test2", "Test3");
        Worker worker2 = new Worker(2L, "Test1_", "Test2_", "Test3_");
        Mockito.when(workerRepo.findAll()).thenReturn(List.of(worker, worker2));
        WorkerService service = new WorkerService(workerRepo);
        Assertions.assertEquals(2, service.getWorkers().size());
        Assertions.assertEquals(1L, service.getWorkers().get(0).getId());
    }

    @Test
    public void deleteWorker() {
        Long id = (long)1;
        workerRepo.deleteById(id);
    }

    @Test
    public void getWorkersSortedBy() {
        Worker worker = new Worker(1L, "Test1", "Test2", "Test3");
        Worker worker2 = new Worker(2L, "Test1_", "Test2_", "Test3_");
        Mockito.when(workerRepo.findAll(any(Specification.class), any(Sort.class))).thenReturn(List.of(worker2, worker));
        WorkerService service = new WorkerService(workerRepo);
        Assertions.assertEquals(2, service.getWorkersSortedBy("firstName").size());
    }
}
