package com.application.statistics.controllers;

import com.application.statistics.dto.EmployeeStatisticsByDepartmentDto;
import com.application.statistics.dto.EmployeeStatisticsDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PathVariable;


@Tag(name = "Statistics", description = "Statistics API")
public interface IStatisticsControllerApi {

    @Operation(description = "Retourne les statistiques avancés des employés d'un département")
    @ApiResponse(responseCode = "200", description = "Nombres totales d'employés par département et la répartition des rôles",
            content = { @Content(mediaType = "application/json") })
    EmployeeStatisticsByDepartmentDto getEmployeeStatisticsByDepartment(@PathVariable Long departmentId);

    @Operation(description = "Calcule le nombre moyen de projet par employé")
    @ApiResponse(responseCode = "200", description = "Nombre moyen de projet par employé",
            content = { @Content(mediaType = "application/json") })
    EmployeeStatisticsDto getAverageProjectPerEmployee();

    @Operation(description = "Retourne le pourcentage d'employé par département")
    @ApiResponse(responseCode = "200", description = "Pourcentage d'employé par département",
            content = { @Content(mediaType = "application/json") })
    EmployeeStatisticsDto getPercentageEmployeeByDepartment();
}
