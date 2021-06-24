package com.agile.vision.summer.practice.service;

import com.agile.vision.summer.practice.entities.Monitor;
import com.agile.vision.summer.practice.repositories.MonitorRepository;
import com.agile.vision.summer.practice.services.MonitorService;
import com.agile.vision.summer.practice.services.MonitorServiceImpl;
import com.github.database.rider.core.api.configuration.DBUnit;
import com.github.database.rider.core.api.configuration.DataSetMergingStrategy;
import com.github.database.rider.core.api.configuration.Orthography;
import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.spring.api.DBRider;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;
import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


@ActiveProfiles("test")
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class MonitorServiceTest {

    @Autowired
    MonitorService monitorService;

    @Mock
    private MonitorRepository monitorRepository;


    @Test
    public void whenMonitorIdIsProvided_thenReturnCorrectUser() {
        Mockito.when(monitorRepository.getById(1)).thenReturn(Monitor.builder().id(1).createdBy("Oleksiy").build());
        String testId = monitorRepository.getById(1).getCreatedBy();
        String resultId = monitorService.getById(1).getCreatedBy();
        assertEquals(resultId, testId);
    }

    @Test
    public void getAll_Test() {
        List<Monitor> monitors_result = monitorService.getAll();
        assertEquals(2, monitors_result.size());
    }

    @Test
    public void getById_catch_exception_Test() {
        Mockito.doThrow(new IllegalArgumentException()).when(monitorRepository).getById(Mockito.eq(1));
        try {
            monitorRepository.getById(1);
        } catch (IllegalArgumentException e) {
            Logger.getLogger("Exception was thrown");
        }
    }

    @Test
    public void TestServiceUpdate() {
        Monitor monitor = Monitor.builder().id(666).displaySize(24.7).build();
        monitorService.save(monitor);
        verify(monitorRepository, times(1)).save(monitor);
    }

    @Test
    public void TestServiceDelete() {
        monitorService.deleteById(1);
        verify(monitorRepository, times(1)).deleteById(1);
    }

}
