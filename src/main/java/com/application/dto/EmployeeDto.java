package com.application.dto;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class EmployeeDto {

    private Long id;

    private String name;

    private String role;

    private DepartmentDto departmentDto;

    private Set<ProjectDto> projectDtos = new HashSet<>();
}
