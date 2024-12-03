package com.search.controller;

import com.search.model.Employee;
import com.search.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @GetMapping("/test")
    public String MyTest() {
        return "I am ok...";
    }

    @PostMapping("/save")
    public Employee saveEmployee(@RequestBody Employee employee) {
        System.out.println(employee);
        return service.saveEmployee(employee);
    }

    @GetMapping("/autocomplete")
    public List<Employee> autocomplete(@RequestParam String query) {
        return service.searchByName(query);
    }

    @GetMapping("/details/{id}")
    public Optional<Employee> getEmployeeDetails(@PathVariable Long id) {
        return service.getEmployeeById(id);
    }


}
