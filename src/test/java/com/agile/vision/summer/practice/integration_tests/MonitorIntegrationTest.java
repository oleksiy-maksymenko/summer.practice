package com.agile.vision.summer.practice.integration_tests;

import com.agile.vision.summer.practice.controllers.MonitorController;
import com.agile.vision.summer.practice.controllers.PlaceController;
import com.agile.vision.summer.practice.entities.Monitor;
import com.agile.vision.summer.practice.entities.Place;
import com.agile.vision.summer.practice.repositories.MonitorRepository;
import com.agile.vision.summer.practice.services.MonitorService;
import com.agile.vision.summer.practice.services.PlaceService;
import com.agile.vision.summer.practice.services.exception.NonExistingIdException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletResponse;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureJsonTesters
@AutoConfigureMockMvc
@SpringBootTest
@ExtendWith(SpringExtension.class)
public class MonitorIntegrationTest {

    @Autowired
    private MockMvc mvc;
    @Autowired
    private MonitorService monitorService;
    @Autowired
    private MonitorRepository monitorRepository;

    @Test
    public void testSaveMonitor() throws Exception {
        mvc.perform(put("/monitor/").requestAttr("id", 1).requestAttr("createdBy", 3).requestAttr("createdAt", 3)
                .requestAttr("updatedBy", 3).requestAttr("updatedAt", 3).requestAttr("height", 3)
                .requestAttr("width", 3).requestAttr("length", 3).requestAttr("displaySize", 3)
                .requestAttr("place_id", 0))
                .andExpect(status().isCreated());

        Monitor monitor = monitorRepository.getById(1);
        assertThat(monitor.getCreatedBy()).isEqualTo("createdBy");
    }


    @Test
    public void testGetAll() throws Exception {
        HttpServletResponse response = mvc.perform(
                get("/monitor/"))
                .andReturn().getResponse();
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(((MockHttpServletResponse) response).getContentAsString()).isNotEmpty();
    }

    @Test
    public void testGetById() throws Exception {
        HttpServletResponse response = mvc.perform(
                get("/monitor/2"))
                .andReturn().getResponse();
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(((MockHttpServletResponse) response).getContentAsString()).isNotEmpty();
    }

    @Test
    public void testGetById_withError() throws Exception {
        MockHttpServletResponse response = mvc.perform(
                get("/monitor/213"))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.NOT_ACCEPTABLE.value());
        assertThat(response.getContentAsString()).isEmpty();
    }


    @Test
    public void testAddingAndDeletingMonitor() throws Exception {
        HttpServletResponse response = mvc.perform(
                put("/monitor/").requestAttr("id", 1).requestAttr("createdBy", 3).requestAttr("createdAt", 3)
                        .requestAttr("updatedBy", 3).requestAttr("updatedAt", 3).requestAttr("height", 3)
                        .requestAttr("width", 3).requestAttr("length", 3).requestAttr("displaySize", 3)
                        .requestAttr("place_id", 1))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());
        response = mvc.perform(
                delete("/monitor/1"))
                .andReturn().getResponse();
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }


}