package com.anz.demo.config;

import com.anz.demo.services.EmployeeService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {

        "com.anz.demo.model",
        "com.anz.demo.repository",
        "com.anz.demo.service"
})

public class TestConfig {

    @Bean
    public EmployeeService employeeService() {
        return new EmployeeService();
    }

}
