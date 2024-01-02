package com.application.department.repository;

import com.application.department.entity.Department;
import org.springframework.stereotype.Repository;
import repositories.IGenericRepository;

@Repository
public interface IDepartmentRepository extends IGenericRepository<Department> {
}
