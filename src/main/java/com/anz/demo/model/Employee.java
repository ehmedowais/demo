package com.anz.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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

    @ManyToOne(cascade={CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinColumn(name="manager")
    @JsonIgnoreProperties("subordinates")
    private Employee manager;

    @OneToMany(mappedBy="manager", fetch = FetchType.EAGER)
    @JsonIgnoreProperties("manager")
    private Set<Employee> subordinates = new HashSet<>();

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

    public void setManager(Employee manager) { this.manager = manager;}

    public Employee getManager() { return this.manager;}

    public Employee() {}

    public Employee(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public Employee(int id, String firstName, String lastName, Set<Employee> subordinates) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.subordinates = subordinates;
    }
}
