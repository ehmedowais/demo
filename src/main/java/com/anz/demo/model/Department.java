package com.anz.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "department")
@Entity
@ToString
public class Department {
    @Id
    @Column(name = "department_id", nullable = false)
    private Integer department_id;

    @Column(name="department_name")
    private String departmentName;


}