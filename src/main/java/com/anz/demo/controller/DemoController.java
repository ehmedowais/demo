package com.anz.demo.controller;

import com.anz.demo.dto.EmployeeResponseDTO;
import com.anz.demo.model.Employee;
import com.anz.demo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("employee")
public class DemoController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("demo")
    public ResponseEntity<String> demoMessge() {
        return ResponseEntity.ok("Hello world");
    }

    @GetMapping("listAll")
    public ResponseEntity<EmployeeResponseDTO> listAllEmployees() {
        EmployeeResponseDTO dto = new EmployeeResponseDTO();
        dto.setEmployees(employeeService.getAllEmployees());
        return ResponseEntity.ok(dto);
    }
    @PostMapping("create")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee emp) {
        return ResponseEntity.ok(employeeService.crateEmployee(emp));
    }

}
