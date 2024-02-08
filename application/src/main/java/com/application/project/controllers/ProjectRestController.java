package com.application.project.controllers;

import com.application.project.dto.ProjectDto;
import com.application.project.entity.Project;
import controllers.GenericRestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import services.GenericService;

@RestController
@RequestMapping("/projects")
public class ProjectRestController extends GenericRestController<Project, ProjectDto> {
    public ProjectRestController(GenericService<Project, ProjectDto> projectService) {
        super(projectService);
    }
}
