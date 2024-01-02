package com.application.employee.repository;

import lombok.Data;

@Data
public class CountEmployeeByDepartment {

    private String departmentName;
    private Integer employeeCount;

    public CountEmployeeByDepartment(String departmentName, Integer employeeCount) {
        this.departmentName = departmentName;
        this.employeeCount = employeeCount;
    }
}
