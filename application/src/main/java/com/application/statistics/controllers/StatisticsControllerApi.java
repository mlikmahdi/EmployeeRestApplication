package com.application.statistics.controllers;

import com.application.statistics.dto.EmployeeStatisticsByDepartmentDto;
import com.application.statistics.dto.EmployeeStatisticsDto;
import com.application.statistics.services.StatisticsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/statistics")
@AllArgsConstructor
public class StatisticsControllerApi implements IStatisticsControllerApi {

    private StatisticsService statisticsService;

    @Override
    @GetMapping("/employees/department/{id}")
    public EmployeeStatisticsByDepartmentDto getEmployeeStatisticsByDepartment(@PathVariable Long id) {
        return statisticsService.getEmployeeStatisticsByDepartment(id);
    }


    @Override
    @GetMapping("/employees/projects/average")
    public EmployeeStatisticsDto getAverageProjectPerEmployee() {
        return statisticsService.getAverageProjectPerEmployee();
    }

    @Override
    @GetMapping("/employees/department/distribution")
    public EmployeeStatisticsDto getPercentageEmployeeByDepartment() {
        return statisticsService.getPercentageEmployeeByDepartment();
    }
}
