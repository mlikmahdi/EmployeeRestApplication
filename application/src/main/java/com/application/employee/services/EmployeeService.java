package com.application.employee.services;

import com.application.employee.dto.EmployeeDto;
import com.application.employee.entity.Employee;
import com.application.employee.mapper.IEmployeeMapper;
import com.application.employee.repository.DepartmentEmployeeCount;
import com.application.employee.repository.IEmployeeRepository;
import org.springframework.stereotype.Service;
import services.GenericService;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EmployeeService extends GenericService<Employee, EmployeeDto> {

    private final IEmployeeRepository repository;

    private final IEmployeeMapper mapper;
    public EmployeeService(IEmployeeRepository repository, IEmployeeMapper mapper) {
        super(repository, mapper);
        this.repository = repository;
        this.mapper = mapper;
    }

    public Set<EmployeeDto> getEmployeesByDepartmentId(Long id) {
        Set<Employee> employees = repository.findByDepartmentId(id);
        return mapper.toDtos(employees);
    }

    public Integer getTotalEmployees() {
        return Math.toIntExact(repository.count());
    }

    public Map<String, Double> getCountEmployeesByDepartment() {
        List<DepartmentEmployeeCount> departmentEmployeeCounts = repository.countEmployeesByDepartment();

        return departmentEmployeeCounts.stream()
                .collect(Collectors.toMap(
                        DepartmentEmployeeCount::getDepartmentName,
                        departmentEmployeeCount -> departmentEmployeeCount.getEmployeeCount().doubleValue()
                ));
    }
}
