package com.application.employee.dto;

import dto.IGenericDto;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.time.LocalDate;

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
        String departmentCode
) implements IGenericDto {

        @Override
        public String id() {
                return matricule;
        }
}
