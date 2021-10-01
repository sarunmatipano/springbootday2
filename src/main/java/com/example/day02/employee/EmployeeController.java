package com.example.day02.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @GetMapping("/employee/{id}")
    public EmployeeResponse getById(@PathVariable String id){
        return service.get(Integer.parseInt(id));
    }
}
