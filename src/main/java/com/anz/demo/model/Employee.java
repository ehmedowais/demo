package com.anz.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="employee")
@ToString
public class Employee {
    @Id
    @GeneratedValue
    @Column(name="ID")
    private int id;
    @Column(name="FIRST_NAME")
    private String firstName;
    @Column(name="LAST_NAME")
    private String lastName;

    @OneToOne(targetEntity = Department.class,fetch = FetchType.LAZY )
    @JoinColumn(name="department_id",updatable = false, insertable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @NotFound(action = NotFoundAction.IGNORE)
    Department department;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="MANAGER",insertable = false, updatable = false)
    @JsonBackReference
    private Employee manager;

    @OneToMany(mappedBy= "manager", fetch = FetchType.EAGER)
    @JsonManagedReference
    private Collection<Employee> subordinates = new HashSet<>();

    @OneToMany(targetEntity = Skill.class,cascade = CascadeType.ALL)
    @JoinColumn(name ="es_fk",referencedColumnName = "id")
    @NotFound(action = NotFoundAction.IGNORE)
    private List<Skill> skills;
}
