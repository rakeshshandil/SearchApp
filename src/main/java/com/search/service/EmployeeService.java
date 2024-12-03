package com.search.service;

import com.search.model.Employee;
import com.search.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository repository;

    public Employee saveEmployee(Employee employee) {
        return repository.save(employee);
    }

    public List<Employee> searchByName(String name) {
        return repository.findByNameContainingIgnoreCase(name);
    }

    public Optional<Employee> getEmployeeById(Long id) {
        return repository.findById(id);
    }


}
