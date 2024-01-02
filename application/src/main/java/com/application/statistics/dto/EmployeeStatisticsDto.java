package com.application.statistics.dto;

import lombok.Data;

import java.util.Map;

@Data
public class EmployeeStatisticsDto {
    private Double averageProjectPerEmployee;
    private Map<String, Double> percentageEmployeeByDepartment;
}
