package com.example.day02.employee;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EmployeeControllerMockBeanTest {

    @MockBean
    private EmployeeRepository mock;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void case02() {
        // arrange
        Employee employee = new Employee();
        employee.setId(11);
        employee.setName("Nume");
        when(mock.findById(11)).thenReturn(Optional.of(employee));

        // act
        EmployeeResponse actual = restTemplate.getForObject("/employee/11", EmployeeResponse.class);

        // assert
        assertEquals(11, actual.getId());
        assertEquals("Nume", actual.getName());
    }

}




