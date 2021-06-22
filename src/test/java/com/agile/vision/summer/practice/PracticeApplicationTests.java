package com.agile.vision.summer.practice;

import com.agile.vision.summer.practice.entities.Monitor;
import com.agile.vision.summer.practice.entities.Place;
import com.agile.vision.summer.practice.repositories.MonitorRepository;
import com.agile.vision.summer.practice.repositories.WorkingPlaceRepository;
import com.agile.vision.summer.practice.services.MonitorService;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PracticeApplicationTests {

    @Autowired
    MonitorService monitorService;

    @Test
    void contextLoads() {
        System.out.println(monitorService.getAll());
    }

}
