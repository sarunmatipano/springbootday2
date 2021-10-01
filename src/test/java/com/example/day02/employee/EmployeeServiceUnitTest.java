package com.example.day02.employee;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

import static org.assertj.core.api.BDDAssumptions.given;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceUnitTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @Test
    public void get(){

        // arrange
        Employee employee = new Employee();
        employee.setId(11);
        employee.setName("Nume");
        when(employeeRepository.findById(11)).thenReturn(Optional.of(employee));
        EmployeeService service = new EmployeeService(employeeRepository);

        // act
        EmployeeResponse employeeResponse = service.get(11);

        // assert
        assertEquals(11, employeeResponse.getId());

    }
}