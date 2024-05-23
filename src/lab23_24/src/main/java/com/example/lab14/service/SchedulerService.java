/*
package com.example.lab14.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

import javax.management.MBeanServer;
import java.lang.management.ManagementFactory;

import javax.management.ObjectName;

@Service
@AllArgsConstructor
public class SchedulerService implements SchedulerServiceMBean {
    WorkerService workerService;

    ManufactureService manufactureService;

    @PostConstruct
    private void init() {
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();

        try {
            ObjectName name = new ObjectName("com.example.lab14:type=service,name=scheduler");

            mbs.registerMBean(this, name);
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    @Scheduled(fixedDelay = 30_000) //now 30 seconds
    public void task() throws IOException {
        String path = "files";
        System.out.println("Scheduled task");
        for (File myFile : Objects.requireNonNull(new File(path).listFiles())) {
            if (myFile.isFile()) {
                myFile.delete();
            }
        }

        File file = new File(path + "/workers.txt");
        file.createNewFile();
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(workerService.getWorkers().toString());
        fileWriter.close();

        file = new File(path + "/manufactures.txt");
        file.createNewFile();
        fileWriter = new FileWriter(file);
        fileWriter.write(manufactureService.getManufacture().toString());
        fileWriter.close();
    }
}
*/
