package com.agile.vision.summer.practice.controllers;

import com.agile.vision.summer.practice.entities.Monitor;
import com.agile.vision.summer.practice.services.MonitorService;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

import javax.persistence.Column;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@AutoConfigureJsonTesters
@AutoConfigureMockMvc
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ControllerMonitorTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void testGetAll() throws Exception {
        MockHttpServletResponse response = mvc.perform(
                get("/monitor/"))
                .andReturn().getResponse();
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isNotEmpty();
    }

    @Test
    public void testGetById() throws Exception {
        MockHttpServletResponse response = mvc.perform(
                get("/monitor/2"))
                .andReturn().getResponse();
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isNotEmpty();
    }

    @Test
    public void testGetById_withError() throws Exception {
        MockHttpServletResponse response = mvc.perform(
                get("/monitor/13"))
                .andReturn().getResponse();
        assertThat(response.getStatus()).isEqualTo(HttpStatus.NOT_ACCEPTABLE.value());
        assertThat(response.getContentAsString()).isEmpty();
    }

    @Test
    public void testAddingMonitor() throws Exception {

        MockHttpServletResponse response = mvc.perform(
                put("/monitor/").requestAttr("id",(Integer)1).requestAttr("createdBy",3).requestAttr("createdAt",3)
                        .requestAttr("updatedBy",3).requestAttr("updatedAt",3).requestAttr("height",3)
                        .requestAttr("width",3).requestAttr("length",3).requestAttr("displaySize",3).requestAttr("place_id",1))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());
    }

    @Test
    public void testDeletingMonitor() throws Exception {

        MockHttpServletResponse response = mvc.perform(
                delete("/monitor/1"))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }

}
