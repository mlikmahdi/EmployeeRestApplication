package com.application.employee.repository;

import com.application.employee.entity.Employee;
import org.springframework.stereotype.Repository;
import repositories.IGenericRepository;

import java.util.Set;

@Repository
public interface IEmployeeRepository extends IGenericRepository<Employee> {

    Set<Employee> findByDepartmentId(Long departmentId);

}
