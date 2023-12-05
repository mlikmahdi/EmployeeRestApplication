package com.application.project.dto;


import dto.IGenericDto;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ProjectDto implements IGenericDto {

    @Schema(hidden = true)
    private Long id;

    private String name;

    private String description;

    @Valid
    private LocalDate startDate;

    private LocalDate endDate;
}
