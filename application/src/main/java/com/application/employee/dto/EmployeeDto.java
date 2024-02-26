package com.application.employee.dto;

import com.application.department.dto.DepartmentDto;
import com.application.project.dto.ProjectDto;
import dto.IGenericDto;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.time.LocalDate;
import java.util.Set;

@Builder
public record EmployeeDto(
        @NotNull
        @Schema(description = "Employee's code with letters and numbers")
        String matricule,
        @NotNull
        String name,
        @NotNull
        String role,
        @NotNull
        LocalDate hireDate,
        DepartmentDto department,
        Set<ProjectDto> projects
) implements IGenericDto {

        @Override
        public String id() {
                return matricule;
        }
}
