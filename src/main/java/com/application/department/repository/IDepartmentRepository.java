package com.application.department.repository;

import com.application.core.repositories.IGenericRepository;
import com.application.department.entity.Department;
import org.springframework.stereotype.Repository;

@Repository
public interface IDepartmentRepository extends IGenericRepository<Department> {
}
