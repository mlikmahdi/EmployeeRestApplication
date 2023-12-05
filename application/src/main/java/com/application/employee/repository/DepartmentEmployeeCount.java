package com.application.employee.repository;

import lombok.Data;

@Data
public class DepartmentEmployeeCount {

    private String departmentName;
    private Long employeeCount;

    public DepartmentEmployeeCount(String departmentName, Long employeeCount) {
        this.departmentName = departmentName;
        this.employeeCount = employeeCount;
    }
}
