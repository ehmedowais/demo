package com.anz.demo.repository;

import com.anz.demo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface EmployeeRepository extends JpaRepository<Employee, Integer>, EmployeeRepositoryCustom {
      @Query(
            name="FIND_SUB_ORDINATES",
            nativeQuery = true,
            value = "WITH recursive cte_org AS (\n" +
                    "    SELECT       \n" +
                    "        id, \n" +
                    "        first_name, last_name, \n" +
                    "        manager\n" +
                    "        \n" +
                    "    FROM       \n" +
                    "        test.employee\n" +
                    "    WHERE manager = ?1\n" +
                    "    UNION ALL\n" +
                    "    SELECT \n" +
                    "        e.id, \n" +
                    "        e.first_name, e.last_name,\n" +
                    "        e.manager\n" +
                    "    FROM \n" +
                    "        test.employee e\n" +
                    "        INNER JOIN cte_org o \n" +
                    "            ON o.id = e.manager\n" +
                    ")\n" +
                    "SELECT * FROM cte_org order by id;"
    )
    List<Employee> findSubordinatesOfManage(int manager);
    List<Employee> findAllByManager(Employee e);

}
