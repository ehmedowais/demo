package com.anz.demo.repository;

import com.anz.demo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface EmployeeRepository extends JpaRepository<Employee, Integer>, EmployeeRepositoryCustom {

}
