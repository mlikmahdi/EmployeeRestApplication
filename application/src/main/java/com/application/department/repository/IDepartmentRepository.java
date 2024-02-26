package com.application.department.repository;

import com.application.department.entity.Department;
import org.springframework.stereotype.Repository;
import repositories.IGenericRepository;

import java.util.Optional;

@Repository
public interface IDepartmentRepository extends IGenericRepository<Department> {
    Optional<Department> findByCode(String code);
}
