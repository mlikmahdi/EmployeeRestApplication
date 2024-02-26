package com.application.statistics.services;

import com.application.employee.dto.EmployeeDto;
import com.application.employee.services.EmployeeService;
import com.application.project.services.ProjectService;
import com.application.statistics.dto.EmployeeStatisticsByDepartmentDto;
import com.application.statistics.dto.EmployeeStatisticsDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StatisticsService {

    private final EmployeeService employeeService;

    private final ProjectService projectService;

    public EmployeeStatisticsByDepartmentDto getEmployeeStatisticsByDepartment(Long departmentId) {
        Set<EmployeeDto> employeesByDepartment = employeeService.getEmployeesByDepartmentId(departmentId);

        EmployeeStatisticsByDepartmentDto employeeStatisticsByDepartmentDto = new EmployeeStatisticsByDepartmentDto();

        employeeStatisticsByDepartmentDto.setTotalEmployees(employeesByDepartment.size());

        employeeStatisticsByDepartmentDto.setRoleDistribution(getRoleDistribution(employeesByDepartment));

        getOldestEmployeeName(employeesByDepartment).ifPresent(employeeDto -> employeeStatisticsByDepartmentDto.setOldestEmployee(employeeDto.name()));

        return employeeStatisticsByDepartmentDto;
    }

    private static Map<String, Long> getRoleDistribution(Set<EmployeeDto> employeesByDepartment) {
        return employeesByDepartment.stream()
                .collect(
                        Collectors.groupingBy(
                                EmployeeDto::role,
                                Collectors.counting()
                        )
                );
    }

    private static Optional<EmployeeDto> getOldestEmployeeName(Set<EmployeeDto> employeesByDepartment) {
        return employeesByDepartment.stream()
                .min(
                        Comparator.comparing(
                                EmployeeDto::hireDate
                        )
                );
    }

    public EmployeeStatisticsDto getAverageProjectPerEmployee() {
        Integer totalEmployees = employeeService.getTotalEmployees();
        Integer totalProjects = projectService.getTotalProjects();

        EmployeeStatisticsDto employeeStatisticsDto = new EmployeeStatisticsDto();

        employeeStatisticsDto.setAverageProjectPerEmployee((double)totalProjects/totalEmployees);

        return employeeStatisticsDto;
    }

    public EmployeeStatisticsDto getPercentageEmployeeByDepartment() {
        Integer totalEmployees = employeeService.getTotalEmployees();
        Map<String, Double> countEmployeesByDepartment = employeeService.getCountEmployeesByDepartment();
        EmployeeStatisticsDto employeeStatisticsDto = new EmployeeStatisticsDto();

        Map<String, Double> percentageByDepartment = countEmployeesByDepartment.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue() / totalEmployees * 100
                ));

        employeeStatisticsDto.setPercentageEmployeeByDepartment(percentageByDepartment);

        return employeeStatisticsDto;
    }
}
