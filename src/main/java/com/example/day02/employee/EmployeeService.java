package com.example.day02.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public EmployeeResponse get(int id){
        Optional<Employee> result = employeeRepository.findById(id);
        if(!result.isPresent()){
            throw new RuntimeException("Employee not found with id = "+id);
        }
        return new EmployeeResponse(id, result.get().getName());
    }
}
