package com.application.department.mapper;

import com.application.core.mappers.IGenericMapper;
import com.application.department.dto.DepartmentDto;
import com.application.department.entity.Department;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IDepartmentMapper extends IGenericMapper<Department, DepartmentDto> {
}
