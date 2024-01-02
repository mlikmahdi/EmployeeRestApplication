package com.application.employee.entity;

import com.application.department.entity.Department;
import com.application.project.entity.Project;
import entities.IGenericEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@Data
public class Employee implements IGenericEntity {

    private @Id @GeneratedValue Long id;

    @NotNull
    private String name;

    @NotNull
    private String role;

    @ManyToOne
    @JoinColumn(name = "department_id", foreignKey = @ForeignKey(name = "FK_employee_department", value = ConstraintMode.NO_CONSTRAINT))
    private Department department;

    @ManyToMany
    @JoinTable(
            name = "employee_project",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "project_id")
    )
    private Set<Project> projects = new HashSet<>();

    @NotNull
    @Column(nullable = false)
    private LocalDate hireDate;

    public Employee(String name, String role) {
        this.name = name;
        this.role = role;
    }
}