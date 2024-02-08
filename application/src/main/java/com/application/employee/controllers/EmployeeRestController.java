package com.application.employee.controllers;

import com.application.employee.dto.EmployeeDto;
import com.application.employee.entity.Employee;
import com.application.employee.services.EmployeeService;
import controllers.GenericRestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/employees")
public class EmployeeRestController extends GenericRestController<Employee, EmployeeDto> {

    private final EmployeeService employeeService;

    public EmployeeRestController(EmployeeService employeeService) {
        super(employeeService);
        this.employeeService = employeeService;
    }

    @GetMapping("/departments/{id}")
    public Set<EmployeeDto> getEmployeesByDepartmentId(@PathVariable Long id) {
        return employeeService.getEmployeesByDepartmentId(id);
    }

}
