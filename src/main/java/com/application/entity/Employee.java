package com.application.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@Data
public class Employee {

    private @Id @GeneratedValue Long id;

    @NotNull
    private String name;

    @NotNull
    private String role;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "employee_project",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "project_id")
    )
    private Set<Project> projects = new HashSet<>();

    public Employee(String name, String role) {
        this.name = name;
        this.role = role;
    }
}