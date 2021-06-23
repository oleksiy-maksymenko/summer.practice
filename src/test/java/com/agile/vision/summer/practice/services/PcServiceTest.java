package com.agile.vision.summer.practice.services;

import com.agile.vision.summer.practice.entities.PC;
import com.agile.vision.summer.practice.repositories.PcRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

@ActiveProfiles("test")
@SpringBootTest
public class PcServiceTest {

    @InjectMocks
    private PcService pcService;

    @Mock
    private PcRepository pcRepository;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void whenPcIdIsProvided_thenReturnCorrectUser() {
        Mockito.when(pcRepository.getById(1)).thenReturn(Optional.of(PC.builder().id(1).createdBy("Oleksiy").build()));
        String testId = pcRepository.getById(1).get().getCreatedBy();
        String resultId = pcService.getById(1).getCreatedBy();
        assertEquals(resultId, testId);
    }

    @Test
    public void getAll_Test() {
        List<PC> monitors = new ArrayList<>();

        monitors.add(PC.builder().id(1).createdBy("Oleksiy").build());
        monitors.add(PC.builder().id(2).createdBy("Maxim").build());
        monitors.add(PC.builder().id(3).createdBy("Ivan").build());

        Mockito.doReturn(monitors).when(pcRepository).getById(1);

        List<PC> monitors_result = pcService.getAll();
        assertEquals(3, monitors_result.size());
        assertEquals(monitors.get(1).getCreatedBy(), monitors_result.get(1).getCreatedBy());
    }

    @Test
    public void getById_Test() {
        Mockito.doThrow(new IllegalArgumentException()).when(pcRepository).getById(Mockito.eq(1));
        try {
            pcRepository.getById(1);
        } catch (IllegalArgumentException e) {
            System.err.println("Exception was thrown");
        }
    }

}