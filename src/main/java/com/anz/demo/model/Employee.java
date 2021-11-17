package com.anz.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;

@Entity
@Table(name="employee")
public class Employee {
    @Id
    //@GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="ID")
    private int id;
    @Column(name="FIRST_NAME")
    private String firstName;
    @Column(name="LAST_NAME")
    private String lastName;

    @OneToOne(targetEntity = Department.class,fetch = FetchType.LAZY)
    @JoinColumn(name="department_id")
    Department department;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="MANAGER",insertable = false, updatable = false)
    @JsonBackReference
    private Employee manager;

    @OneToMany(mappedBy= "manager", fetch = FetchType.EAGER)
    @JsonManagedReference
    private Collection<Employee> subordinates = new HashSet<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Collection<Employee> getSubordinates() {
        return subordinates;
    }

    public void setSubordinates(Collection<Employee> subordinates) {
        this.subordinates = subordinates;
    }

    public void setManager(Employee managerOfEmployee) { this.manager = managerOfEmployee;}

    public Employee getManager() { return this.manager;}

    public Employee() {}

    public Department getDepartment() {return this.department;}

    public void setDepartment(Department department) {
        this.department = department;
    }
}
