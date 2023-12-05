package com.application.project.repository;

import com.application.core.repositories.IGenericRepository;
import com.application.project.entity.Project;
import org.springframework.stereotype.Repository;

@Repository
public interface IProjectRepository extends IGenericRepository<Project> {
}
