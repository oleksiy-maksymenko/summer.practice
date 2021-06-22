package com.agile.vision.summer.practice.services;

import com.agile.vision.summer.practice.entities.Monitor;
import com.agile.vision.summer.practice.repositories.MonitorRepository;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ActiveProfiles("test")
@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class MonitorServiceTest {

    @InjectMocks
    MonitorService monitorService;

    @Mock
    private MonitorRepository monitorRepository = Mockito.mock(MonitorRepository.class);


    @Test
    public void whenMonitorIdIsProvided_thenReturnCorrectUser() {
        Mockito.when(monitorRepository.getById(1)).thenReturn(Monitor.builder().id(1).createdBy("Oleksiy").build());
        String testId = monitorRepository.getById(1).getCreatedBy();
        System.out.println(testId);
        String resultId = monitorService.getById(1).getCreatedBy();
        System.out.println(resultId);
        assertEquals(resultId, testId);
    }

    @Test
    public void getAll_Test() {
        List<Monitor> monitors = new ArrayList<>();

        monitors.add(Monitor.builder().id(1).createdBy("Oleksiy").build());
        monitors.add(Monitor.builder().id(2).createdBy("Maxim").build());
        monitors.add(Monitor.builder().id(3).createdBy("Ivan").build());

        Mockito.doReturn(monitors).when(monitorRepository).getById(1);

        List<Monitor> monitors_result = monitorService.getAll();
        assertEquals(3, monitors_result.size());
        assertEquals(monitors.get(1).getCreatedBy(), monitors_result.get(1).getCreatedBy());
    }

    @Test
    public void getById_catch_exception_Test() {
        Mockito.doThrow(new IllegalArgumentException()).when(monitorRepository).getById(Mockito.eq(1));
        try {
            monitorRepository.getById(1);
        } catch (IllegalArgumentException e) {
            System.err.println("Exception was thrown");
        }
    }

    @Test
    public void testServiceUpdate() {
        Monitor monitor = Monitor.builder().id(666).displaySize(24.7).build();
        monitorService.save(monitor);
        verify(monitorRepository, times(1)).save(monitor);
    }

    @Test
    public void testServiceDelete() {
        monitorService.deleteById(1);
        verify(monitorRepository, times(1)).deleteById(1);
    }

}
