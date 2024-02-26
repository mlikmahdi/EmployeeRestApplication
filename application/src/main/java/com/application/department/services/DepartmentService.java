package com.application.department.services;

import com.application.department.dto.DepartmentDto;
import com.application.department.entity.Department;
import com.application.department.mapper.IDepartmentMapper;
import com.application.department.repository.IDepartmentRepository;
import org.springframework.stereotype.Service;
import services.GenericService;

@Service
public class DepartmentService extends GenericService<Department, DepartmentDto> {
    public DepartmentService(IDepartmentRepository repository, IDepartmentMapper mapper) {
        super(repository::findByCode, repository, mapper);
    }
}
