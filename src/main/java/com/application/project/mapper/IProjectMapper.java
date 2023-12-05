package com.application.project.mapper;

import com.application.core.mappers.IGenericMapper;
import com.application.project.dto.ProjectDto;
import com.application.project.entity.Project;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IProjectMapper extends IGenericMapper<Project, ProjectDto> {

}
