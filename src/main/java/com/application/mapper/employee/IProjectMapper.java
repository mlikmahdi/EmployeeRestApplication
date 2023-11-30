package com.application.mapper.employee;

import com.application.dto.ProjectDto;
import com.application.entity.Project;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Set;

@Mapper(componentModel = "spring")
public interface IProjectMapper {

    @Mapping(target = "employeeDtos", source = "employees", ignore = true)
    Set<ProjectDto> toProjectDto(Set<Project> projects);

    @Mapping(target = "employees", source = "employeeDtos", ignore = true)
    Set<Project> toProject(Set<ProjectDto> projectDtos);

}
