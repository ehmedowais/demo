package com.anz.demo.repository;

import com.anz.demo.model.Employee;

import java.util.List;

public interface EmployeeRepositoryCustom {
    List<Employee> getEmployeesByNames(String fName, String lName);
}
