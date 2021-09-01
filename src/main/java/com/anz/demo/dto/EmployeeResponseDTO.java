package com.anz.demo.dto;

import com.anz.demo.model.Employee;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class EmployeeResponseDTO {
    @JsonProperty(value = "employees", required = true)
    private List<Employee> employees;
    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public EmployeeResponseDTO() {
    }
}
