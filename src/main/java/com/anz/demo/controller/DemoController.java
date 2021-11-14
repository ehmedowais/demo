package com.anz.demo.controller;

import com.anz.demo.dto.EmployeeResponseDTO;
import com.anz.demo.model.Employee;
import com.anz.demo.repository.EmployeeRepository;
import com.anz.demo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("employee")
public class DemoController {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    EmployeeRepository employeeRepository;
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
    @GetMapping("getByFirstOrLastName")
    public ResponseEntity<EmployeeResponseDTO> getEmployeesByNames(
            @RequestParam(value = "firstName", required = false) String firstName,
            @RequestParam(value = "lastName", required = false) String lastName) {
        EmployeeResponseDTO dto = new EmployeeResponseDTO();
        if(firstName == null && lastName == null ) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        dto.setEmployees(employeeService.getEmployeesByFirstOrLastName(firstName,lastName));
        return ResponseEntity.ok(dto);
    }
    @GetMapping("getSubOrdinates/{id}")
    public ResponseEntity<List<Employee>> getSubOrdinates(@PathVariable(name="id") int id) {
       return ResponseEntity.ok(
               employeeRepository.findAllByManager(
                       employeeRepository.getById(id).getManager()));

    }
    @PostMapping("create")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee emp) {
        return ResponseEntity.ok(employeeService.crateEmployee(emp));
    }

}
