package com.application.statistics.services;

import com.application.employee.dto.EmployeeDto;
import com.application.employee.services.EmployeeService;
import com.application.project.services.ProjectService;
import com.application.statistics.dto.EmployeeStatisticsByDepartmentDto;
import com.application.statistics.dto.EmployeeStatisticsDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
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

        getOldestEmployeeName(employeesByDepartment).ifPresent(employeeDto -> employeeStatisticsByDepartmentDto.setOldestEmployee(employeeDto.getName()));

        return employeeStatisticsByDepartmentDto;
    }

    private static Map<String, Long> getRoleDistribution(Set<EmployeeDto> employeesByDepartment) {
        return employeesByDepartment.stream()
                .collect(
                        Collectors.groupingBy(
                                EmployeeDto::getRole,
                                Collectors.counting()
                        )
                );
    }

    private static Optional<EmployeeDto> getOldestEmployeeName(Set<EmployeeDto> employeesByDepartment) {
        return employeesByDepartment.stream()
                .min(
                        Comparator.comparing(
                                EmployeeDto::getStartDate
                        )
                );
    }

    public EmployeeStatisticsDto getAverageProjectPerEmployee() {
        Integer totalEmployees = employeeService.getTotalEmployees();
        Integer totalProjects = projectService.getTotalProjects();

        EmployeeStatisticsDto employeeStatisticsDto = new EmployeeStatisticsDto();

        employeeStatisticsDto.setAverageProjectPerEmployee((double) (totalProjects/totalEmployees));

        return employeeStatisticsDto;
    }
}
