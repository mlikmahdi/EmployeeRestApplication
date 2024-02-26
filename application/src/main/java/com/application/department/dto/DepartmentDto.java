package com.application.department.dto;

import dto.IGenericDto;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record DepartmentDto(
        @NotNull
        String code,

        @NotNull
        String name
) implements IGenericDto {

        @Override
        public String id() {
                return code;
        }
}
