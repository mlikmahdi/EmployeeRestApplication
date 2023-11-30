package com.application.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DepartmentDto {

    private Long id;

    @NotNull
    private String name;
}
