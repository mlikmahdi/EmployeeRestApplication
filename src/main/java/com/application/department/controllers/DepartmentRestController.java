package com.application.department.controllers;

import com.application.core.controllers.GenericRestController;
import com.application.department.dto.DepartmentDto;
import com.application.department.entity.Department;
import com.application.department.services.DepartmentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/department")
public class DepartmentRestController extends GenericRestController<Department, DepartmentDto> {
    public DepartmentRestController(DepartmentService departmentService) {
        super(departmentService);
    }
}
