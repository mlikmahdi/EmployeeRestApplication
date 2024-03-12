package com.application.employee.mapper;

import com.application.department.services.DepartmentService;
import com.application.employee.dto.EmployeeDto;
import com.application.employee.entity.Employee;
import mappers.IGenericMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = { DepartmentService.class })
public interface IEmployeeMapper extends IGenericMapper<Employee, EmployeeDto> {
    @Override
    @Mapping(target = "department", source = "departmentCode", qualifiedByName = "mapCodeToDepartment")
    Employee toEntity(EmployeeDto dto);

    @Override
    @Mapping(target = "departmentCode", source = "department.code")
    EmployeeDto toDto(Employee entity);

    @Override
    @Mapping(target = "department", source = "departmentCode", qualifiedByName = "mapCodeToDepartment")
    void updateEntity(EmployeeDto dto, @MappingTarget Employee entity);
}
