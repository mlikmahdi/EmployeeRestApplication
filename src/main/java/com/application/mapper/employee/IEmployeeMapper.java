package com.application.mapper.employee;

import com.application.dto.EmployeeDto;
import com.application.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Set;

@Mapper(componentModel = "spring", uses = {IDepartmentMapper.class, IProjectMapper.class})
public interface IEmployeeMapper {

    @Mapping(target = "department", source = "departmentDto")
    @Mapping(target = "projects", source = "projectDtos")
    Employee toEmployee(EmployeeDto employeeDto);

    @Mapping(target = "departmentDto", source = "department")
    @Mapping(target = "projectDtos", source = "projects")
    EmployeeDto toDto(Employee employee);

    @Mapping(target = "departmentDto", source = "department")
    Set<EmployeeDto> toEmployeeDtos(Set<Employee> employee);


}
