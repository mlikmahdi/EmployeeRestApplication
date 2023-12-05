package com.application.project.controllers;

import com.application.core.controllers.GenericRestController;
import com.application.core.services.GenericService;
import com.application.project.dto.ProjectDto;
import com.application.project.entity.Project;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/project")
public class ProjectRestController extends GenericRestController<Project, ProjectDto> {
    public ProjectRestController(GenericService<Project, ProjectDto> projectService) {
        super(projectService);
    }
}
