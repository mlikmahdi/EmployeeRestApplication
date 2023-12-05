package com.application.statistics.dto;

import lombok.Data;

import java.util.Map;

@Data
public class EmployeeStatisticsByDepartmentDto {
    private Integer totalEmployees;
    private Map<String, Long> roleDistribution;
    private String oldestEmployee;
}
