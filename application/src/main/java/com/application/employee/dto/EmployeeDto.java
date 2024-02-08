package com.application.employee.dto;

import com.application.department.dto.DepartmentDto;
import com.application.project.dto.ProjectDto;
import dto.IGenericDto;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Data
public class EmployeeDto implements IGenericDto {

    @Schema(hidden = true)
    private Long id;

    private String name;

    private String role;

    @Valid
    private LocalDate hireDate;

    @Valid
    private DepartmentDto department;

    private Set<ProjectDto> projects;
}
