package com.application.project.services;

import com.application.project.dto.ProjectDto;
import com.application.project.entity.Project;
import com.application.project.mapper.IProjectMapper;
import com.application.project.repository.IProjectRepository;
import org.springframework.stereotype.Service;
import services.GenericService;

@Service
public class ProjectService extends GenericService<Project, ProjectDto> {

    private final IProjectRepository repository;
    public ProjectService(IProjectRepository repository, IProjectMapper mapper) {
        super(repository::findByCode, repository, mapper);
        this.repository = repository;
    }

    public Integer getTotalProjects() {
        return Math.toIntExact(repository.count());
    }
}
