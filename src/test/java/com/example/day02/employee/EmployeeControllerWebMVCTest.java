package com.example.day02.employee;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


import static org.junit.jupiter.api.Assertions.*;


@WebMvcTest(EmployeeController.class)
public class EmployeeControllerWebMVCTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private EmployeeService employeeService;

    @Test
    public void getById() throws Exception{

        // arrange
        when(EmployeeService.get(1)).thenReturn(new EmployeeResponse(1, "Sarun"));

        MvcResult mvcResult = mvc.perform(get("/employee/1")).andExpect(status().isOk()).andReturn();
        ObjectMapper mapper = new ObjectMapper();
        EmployeeResponse actual = mapper.readValue(mvcResult.getResponse().getContentAsByteArray(), EmployeeResponse.class);

        // assert
        assertEquals(1, actual.getId());
        assertEquals("SarunM", actual.getName());
    }
}