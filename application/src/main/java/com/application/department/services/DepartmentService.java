package com.application.department.services;

import com.application.department.dto.DepartmentDto;
import com.application.department.entity.Department;
import com.application.department.mapper.IDepartmentMapper;
import com.application.department.repository.IDepartmentRepository;
import org.mapstruct.Named;
import org.springframework.stereotype.Service;
import services.GenericService;

@Service
public class DepartmentService extends GenericService<Department, DepartmentDto> {

    private final IDepartmentRepository repository;
    public DepartmentService(IDepartmentRepository repository, IDepartmentMapper mapper) {
        super(repository::findByCode, repository, mapper);
        this.repository = repository;
    }

    @Named("mapCodeToDepartment")
    public Department mapCodeToDepartment(String departmentCode) {
        if (departmentCode == null) {
            return null;
        }

       return repository.findByCode(departmentCode).orElseThrow(() -> new IllegalArgumentException("Department code not found " + departmentCode));
    }
}
