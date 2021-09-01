package com.anz.demo.services;

import com.anz.demo.config.JPATestConfig;
import com.anz.demo.config.TestConfig;
import com.anz.demo.model.Employee;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@ContextConfiguration(classes = { JPATestConfig.class, TestConfig.class})
@Transactional
class EmployeeServiceTest {
    @Autowired
    private EmployeeService employeeService;

    @Test
    public void given_when_empl_added_then_get_OK() {
        Employee empInput = new Employee();
        empInput.setFirstName("Junit");
        empInput.setLastName(("DAOTest"));
        Employee empOutput = employeeService.crateEmployee(empInput);
        assertTrue(empOutput.getId() > 0);
        assertTrue(employeeService.getAllEmployees().get(0).getFirstName().equals("Junit"));
    }

}