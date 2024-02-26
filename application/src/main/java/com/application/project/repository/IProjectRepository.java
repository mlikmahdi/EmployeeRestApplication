package com.application.project.repository;

import com.application.project.entity.Project;
import org.springframework.stereotype.Repository;
import repositories.IGenericRepository;

import java.util.Optional;

@Repository
public interface IProjectRepository extends IGenericRepository<Project> {
    Optional<Project> findByCode(String code);
}
