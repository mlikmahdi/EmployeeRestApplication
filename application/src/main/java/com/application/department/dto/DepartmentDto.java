package com.application.department.dto;

import dto.IGenericDto;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DepartmentDto implements IGenericDto {

    private Long id;

    @NotNull
    private String name;
}
