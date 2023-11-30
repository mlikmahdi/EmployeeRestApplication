package com.application.controllers;

import com.application.dto.EmployeeDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Set;

@Tag(name = "Employee", description = "Employee API")
public interface IEmployeeControllerApi {
    @Operation(description = "Retourne tous les employés")
    @ApiResponse(responseCode = "200", description = "Employés trouvés",
            content = { @Content(mediaType = "application/json") })
    Set<EmployeeDto> getAllEmployees();

    @Operation(description = "Retourne un employé")
    @ApiResponse(responseCode = "200", description = "Employé trouvé",
            content = { @Content(mediaType = "application/json") })
    EmployeeDto getOneEmployee(@PathVariable Long id);

    @Operation(description = "Crée un employé")
    @ApiResponse(responseCode = "201", description = "Employé crée",
            content = { @Content(mediaType = "application/json") })
    ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto);

    @Operation(description = "Modifie un employé")
    @ApiResponse(responseCode = "200", description = "Employé modifié",
            content = { @Content(mediaType = "application/json") })
    ResponseEntity<EmployeeDto> updateEmployee(@RequestBody EmployeeDto employeeDto);

    @Operation(description = "Supprime un employé")
    @ApiResponse(responseCode = "200", description = "Employé supprimé")
    void deleteEmployee(@PathVariable Long id);
}
