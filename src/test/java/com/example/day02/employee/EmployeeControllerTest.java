package com.example.day02.employee;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class EmployeeControllerTest {

    @Autowired
    TestRestTemplate restTemplate;


    @Test
    void exampleTest() {
        // act
        EmployeeResponse actual = restTemplate.getForObject("/employee/1", EmployeeResponse.class);

        // assert
        assertEquals(1, actual.getId());
        assertEquals("SarunM", actual.getName());
        assertNotEquals("SarunMM", actual.getName());
        assertNotNull(actual);
    }


}




