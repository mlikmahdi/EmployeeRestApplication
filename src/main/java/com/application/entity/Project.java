package com.application.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@RequiredArgsConstructor
@Data
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    private String description;

    @ManyToMany(mappedBy = "projects", fetch = FetchType.LAZY)
    private Set<Employee> employees = new HashSet<>();
}
