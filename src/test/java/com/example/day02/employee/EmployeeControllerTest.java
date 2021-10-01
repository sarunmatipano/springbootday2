package com.example.day02.employee;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

import static org.assertj.core.api.BDDAssumptions.given;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EmployeeControllerTest {

    @Autowired
    TestRestTemplate restTemplate;

    @Autowired
    private EmployeeRepository repository;

    @MockBean
    private EmployeeRepository mock;

    @AfterEach
    public void clearData(){
        repository.deleteAll();
    }

    @Test
    void case01() {
        // arrange
        Employee employee = new Employee();
        employee.setName("Sarun");
        repository.save(employee);

        // act
        EmployeeResponse actual = restTemplate.getForObject("/employee/1", EmployeeResponse.class);

        // assert
        assertEquals(1, actual.getId());
        assertEquals("SarunM", actual.getName());
        assertNotEquals("SarunMM", actual.getName());
        assertNotNull(actual);
    }

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




