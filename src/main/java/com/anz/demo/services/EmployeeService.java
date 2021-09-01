package com.anz.demo.services;

import com.anz.demo.model.Employee;
import com.anz.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
    public Employee crateEmployee(Employee employee) {
       return employeeRepository.save(employee);

    }


}
