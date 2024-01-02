package com.application.employee.mapper;

import com.application.employee.dto.EmployeeDto;
import com.application.employee.entity.Employee;
import mappers.IGenericMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IEmployeeMapper extends IGenericMapper<Employee, EmployeeDto> {
}
