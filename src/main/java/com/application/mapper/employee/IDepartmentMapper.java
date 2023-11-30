package com.application.mapper.employee;

import com.application.dto.DepartmentDto;
import com.application.entity.Department;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IDepartmentMapper {

    DepartmentDto toDto(Department department);

    Department toDepartment(DepartmentDto departmentDto);
}
