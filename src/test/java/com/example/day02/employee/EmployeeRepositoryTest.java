package com.example.day02.employee;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository repository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @MockBean
    private EmployeeRepository mock;
    @Test
    public void case01(){
        // arrange
        Employee employee = new Employee();
        employee.setName("Sarun");
        repository.save(employee);

        // act
        Optional<Employee> result = repository.findById(1);

        // assert
        assertTrue(result.isPresent());
        assertEquals(1, result.get().getId());
        assertEquals("Sarun", result.get().getName());

    }

    @Test
    public void case02(){
        // arrange

        // act
        Optional<Employee> result = repository.findById(1);

        // assert
        assertFalse(result.isPresent());
    }

}