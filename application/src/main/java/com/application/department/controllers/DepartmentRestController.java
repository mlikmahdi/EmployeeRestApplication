package com.application.department.controllers;

import com.application.department.dto.DepartmentDto;
import com.application.department.entity.Department;
import com.application.department.services.DepartmentService;
import controllers.GenericRestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/department")
public class DepartmentRestController extends GenericRestController<Department, DepartmentDto> {
    public DepartmentRestController(DepartmentService departmentService) {
        super(departmentService);
    }
}
