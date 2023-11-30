package com.application.controllers;

import com.application.dto.EmployeeDto;
import com.application.exceptions.EmployeeNotFoundException;
import com.application.services.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/employee")
@AllArgsConstructor
public class EmployeeController implements IEmployeeControllerApi {

    private EmployeeService employeeService;

    @Override
    @GetMapping("/all")
    public Set<EmployeeDto> getAllEmployees() {

        return employeeService.findAllEmployees();
    }

    @Override
    @GetMapping("/{id}")
    public EmployeeDto getOneEmployee(@PathVariable Long id) {
        return employeeService.getEmployeeById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    @Override
    @PostMapping("/new")
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(employeeService.createNewEmployee(employeeDto));
    }

    @Override
    @PutMapping("/update")
    public ResponseEntity<EmployeeDto> updateEmployee(@RequestBody EmployeeDto employeeDto) {

        EmployeeDto body = employeeService.updateEmployee(employeeDto).orElseThrow(() -> new EmployeeNotFoundException(employeeDto.getId()));

        return ResponseEntity.status(HttpStatus.OK)
                .body(body);
    }

    @Override
    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployeeByID(id).orElseThrow(() -> new EmployeeNotFoundException(id));
    }
}
