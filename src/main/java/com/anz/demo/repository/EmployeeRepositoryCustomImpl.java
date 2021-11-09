package com.anz.demo.repository;

import com.anz.demo.model.Employee;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
//https://dzone.com/articles/add-custom-functionality-to-a-spring-data-reposito
public class EmployeeRepositoryCustomImpl implements EmployeeRepositoryCustom {
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public List<Employee> getEmployeesByNames(String fName, String lName) {
        String qString = "SELECT em.* FROM employee em ";
        Query query = null;
        if(fName != null && lName != null){
            qString += " Where em.first_Name like ?1 and em.last_Name like ?2";
            query = entityManager.createNativeQuery( qString, Employee.class);
            query.setParameter(1, fName + "%");
            query.setParameter(2, lName + "%");

        }
        if(fName != null && lName == null) {
            qString += " Where em.first_Name like ?1";
            query = entityManager.createNativeQuery( qString, Employee.class);
            query.setParameter(1, fName + "%");
        }
        if(lName != null && fName == null) {
            qString += " Where em.last_Name like ?1";
            query = entityManager.createNativeQuery( qString, Employee.class);
            query.setParameter(1, lName + "%");
        }

        return query.getResultList();
    }
}
