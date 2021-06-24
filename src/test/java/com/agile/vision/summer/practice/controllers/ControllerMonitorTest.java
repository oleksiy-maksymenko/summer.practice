package com.agile.vision.summer.practice.controllers;

import com.agile.vision.summer.practice.entities.Monitor;
import com.agile.vision.summer.practice.entities.Place;
import com.agile.vision.summer.practice.services.MonitorService;
import com.agile.vision.summer.practice.services.PlaceService;
import com.agile.vision.summer.practice.services.exception.NonExistingIdException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.apache.poi.hpsf.NoFormatIDException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

import javax.persistence.Column;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@AutoConfigureJsonTesters
@AutoConfigureMockMvc
@WebMvcTest(MonitorController.class)
@ExtendWith(MockitoExtension.class)
public class ControllerMonitorTest {

    @Autowired
    private MockMvc mvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private MonitorService monitorService;
    @MockBean
    private PlaceService placeService;

    @Test
    public void testGetAll() throws Exception {
        MockHttpServletResponse response = mvc.perform(
                get("/monitor/"))
                .andReturn().getResponse();
        verify(monitorService, times(1)).getAll();
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isNotEmpty();
    }

    @Test
    public void testGetById() throws Exception {
        when(monitorService.getById(Mockito.anyInt())).thenReturn(new Monitor());

        MockHttpServletResponse response = mvc.perform(
                get("/monitor/2"))
                .andReturn().getResponse();

        verify(monitorService, times(1)).getById(2);
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isNotEmpty();
    }

    @Test
    public void testGetById_withError() throws Exception {
        when(monitorService.getById(anyInt())).thenThrow(NonExistingIdException.class);

        MockHttpServletResponse response = mvc.perform(
                get("/monitor/213"))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.NOT_ACCEPTABLE.value());
        assertThat(response.getContentAsString()).isEmpty();
    }


    @Test
    public void testAddingMonitor() throws Exception {
        when(monitorService.save(Mockito.any())).thenReturn(new Monitor());

        MockHttpServletResponse response = mvc.perform(
                put("/monitor/").requestAttr("id", 1).requestAttr("createdBy", 3).requestAttr("createdAt", 3)
                        .requestAttr("updatedBy", 3).requestAttr("updatedAt", 3).requestAttr("height", 3)
                        .requestAttr("width", 3).requestAttr("length", 3).requestAttr("displaySize", 3)
                        .requestAttr("place_id", 1))
                .andReturn().getResponse();

        verify(monitorService, times(1)).save(Mockito.any());
        assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());
    }

    @Test
    public void testDeletingMonitor() throws Exception {
        when(monitorService.deleteById(Mockito.anyInt())).thenReturn(true);
        MockHttpServletResponse response = mvc.perform(
                delete("/monitor/1"))
                .andReturn().getResponse();
        verify(monitorService, times(1)).deleteById(Mockito.anyInt());
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }
}