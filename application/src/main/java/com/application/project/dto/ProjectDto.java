package com.application.project.dto;


import dto.IGenericDto;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public record ProjectDto(
        @NotNull
        String code,
        @NotNull
        String name,
        String description,

        LocalDate startDate,
        LocalDate endDate
) implements IGenericDto {
        @Override
        public String id() {
                return code;
        }
}
