package com.agile.vision.summer.practice.controllers;

import com.agile.vision.summer.practice.services.MonitorService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@ExtendWith(SpringExtension.class)
@AutoConfigureJsonTesters
@SpringBootTest
@AutoConfigureMockMvc
public class MonitorControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private MonitorService monitorService;


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
                get("/monitor/?id=2"))
                .andReturn().getResponse();
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isNotEmpty();
    }

    @Test
    public void testGetById_withError() throws Exception {
        MockHttpServletResponse response = mvc.perform(
                get("/monitor/?id=666"))
                .andReturn().getResponse();
        assertThat(response.getStatus()).isEqualTo(HttpStatus.NOT_FOUND.value());
        assertThat(response.getContentAsString()).isEmpty();
    }

}
