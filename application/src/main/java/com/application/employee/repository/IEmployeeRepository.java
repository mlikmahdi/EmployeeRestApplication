package com.application.employee.repository;

import com.application.employee.entity.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import repositories.IGenericRepository;

import java.util.List;
import java.util.Set;

@Repository
public interface IEmployeeRepository extends IGenericRepository<Employee> {

    Set<Employee> findByDepartmentId(Long departmentId);

    @Query("SELECT new com.application.employee.repository.DepartmentEmployeeCount(e.department.name, COUNT(e)) FROM Employee e GROUP BY e.department.name")
    List<DepartmentEmployeeCount> countEmployeesByDepartment();

}
