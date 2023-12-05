package com.application.employee.mapper;

import com.application.core.mappers.IGenericMapper;
import com.application.employee.dto.EmployeeDto;
import com.application.employee.entity.Employee;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IEmployeeMapper extends IGenericMapper<Employee, EmployeeDto> {
}
